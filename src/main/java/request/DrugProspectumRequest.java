package request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import constant.Consts;
import entity.Drug;
import utility.CustomAlerts;
import utility.JWTInfo;

public class DrugProspectumRequest {

  private DrugProspectumRequest() {
  }

  public static Drug drugProspectumRequest(String name, JWTInfo token) throws IOException {
    // if (!new Utility().isOnline()) {
    // CustomAlerts.showInternetErrorConnectionAlert();
    // throw new IOException();
    // }

    URL obj = new URL(((Consts.LOCAL_SERVER ? Consts.DRUG_PROSPECTUS_URL : Consts.OPENSHIFT_DRUG_PROSPECTUS_URL) + "?name=" + name).replaceAll(" ", "%20"));

    System.out.println(obj.toString());

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

    if (name.equals("")) {
      CustomAlerts.showEmptyFieldsAlert();
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

      JSONArray jsonArray = new JSONArray(response.toString());
      List<Drug> drugs = new ArrayList<>();
      for (Object object : jsonArray) {
        Gson gson = new GsonBuilder().create();
        drugs.add(gson.fromJson(object.toString().trim(), Drug.class));
      }

      if (drugs.size() == 0) {
        CustomAlerts.showemptyDrugListAlert();
        throw new IOException();
      }

      if (drugs.size() == 1) {
        return drugs.get(0);
      }
      else {
        return CustomAlerts.showemptyDrugMultipleAlert(drugs);
      }
    }
    else if (con.getResponseCode() == 503) {
      CustomAlerts.showServiceUnavailableAlert();
      throw new IOException();
    }
    else if (con.getResponseCode() == 404) {
      CustomAlerts.showDrugDoesNotExistAlert();
      throw new IOException();
    }
    return new Drug();
  }
}
