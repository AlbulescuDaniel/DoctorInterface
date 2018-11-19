package request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.JSONArray;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import constant.Consts;
import entity.Prescription;
import utility.CustomAlerts;

public class PrescriptionsTabRequest {

  private PrescriptionsTabRequest() {
  }

  public static List<Prescription> requestFillPrescriptionTable(String firstName, String lastName, LocalDate from, LocalDate to) throws Exception {
    // if (!new Utility().isOnline()) {
    // CustomAlerts.showInternetErrorConnectionAlert();
    // throw new IOException();
    // }

    from = from.minusDays(1);
    to = to.plusDays(1);

    URL obj = new URL(Consts.FILL_PRESCRIPTION_TABLE_URL + "?firstName=" + firstName + "&lastName=" + lastName + "&startDate=" + from + "&endDate=" + to);

    HttpURLConnection con = (HttpURLConnection)obj.openConnection();
    con.setRequestMethod("GET");

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

      JSONArray jsonArray = new JSONArray(response.toString());
      List<Prescription> prescriptions = new ArrayList<>();
      for (Object object : jsonArray) {
        Gson gson = new GsonBuilder().create();
        prescriptions.add(gson.fromJson(object.toString().trim(), Prescription.class));
      }

      if (prescriptions.isEmpty()) {
        CustomAlerts.showemptyPrescriptionListAlert();
        throw new IOException();
      }

      return prescriptions;
    }
    else if (con.getResponseCode() == 503) {
      CustomAlerts.showServiceUnavailableAlert();
      throw new IOException();
    }
    else if (con.getResponseCode() == 404) {
      CustomAlerts.showPatientDoesNotExistAlert();
      throw new IOException();
    }
    else {
      return Collections.emptyList();
    }
  }
}
