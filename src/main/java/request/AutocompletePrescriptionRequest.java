package request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import constant.Consts;
import entity.PrescriptionDoctorHospital;
import utility.CustomAlerts;
import utility.JWTInfo;
import utility.Utility;

public class AutocompletePrescriptionRequest {
  private AutocompletePrescriptionRequest() {
  }

  public static PrescriptionDoctorHospital autocompleteRequest(JWTInfo token) throws IOException {
    // if (!new Utility().isOnline()) {
    // CustomAlerts.showInternetErrorConnectionAlert();
    // throw new IOException();
    // }

    URL obj = new URL(Consts.AUTOFILL_PRESCRIPTION_URL + "?userName=" + token.getUser());

    HttpURLConnection con = (HttpURLConnection)obj.openConnection();
    con.setRequestMethod("GET");
    con.setRequestProperty("Content-Type", "application/json");
    con.setRequestProperty("Accept", "application/json");
    con.setRequestProperty("Authorization", token.getToken());

    try {
      con.connect();
    }
    catch (Exception e) {
      CustomAlerts.showServerErrorConnectionAlert();
      throw new IOException();
    }

    if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {

      BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
      String inputLine;
      StringBuilder response = new StringBuilder();

      while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
      }
      in.close();
      
      Gson gson = new GsonBuilder().create();
      
      return gson.fromJson(response.toString().trim(), PrescriptionDoctorHospital.class);
    }
    else if (con.getResponseCode() == 503) {
      CustomAlerts.showServiceUnavailableAlert();
      throw new IOException();
    }
    else if (con.getResponseCode() == 404) {
      CustomAlerts.showDoctorDoesNotExistAlert();
      throw new IOException();
    }
    else {
      return null;
    }
  }
}
