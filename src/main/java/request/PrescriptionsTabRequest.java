package request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import constant.Consts;
import entity.PrescriptionWithPatientName;
import entity.UserDetailsFromPrescriptions;
import utility.CustomAlerts;
import utility.JWTInfo;

public class PrescriptionsTabRequest {

  static Boolean ok = true;

  private PrescriptionsTabRequest() {
  }

  public static List<PrescriptionWithPatientName> requestFillPrescriptionTable(String firstName, String lastName, LocalDate from, LocalDate to, JWTInfo token) throws IOException {
    // if (!new Utility().isOnline()) {
    // CustomAlerts.showInternetErrorConnectionAlert();
    // throw new IOException();
    // }

    from = from.minusDays(1);
    to = to.plusDays(1);

    URL obj = new URL((Consts.LOCAL_SERVER ? Consts.FILL_PRESCRIPTION_TABLE_URL : Consts.OPENSHIFT_FILL_PRESCRIPTION_TABLE_URL) + "?firstName=" + firstName + "&lastName=" + lastName + "&startDate="
        + from + "&endDate=" + to);

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

    if (firstName.equals("")) {
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
      List<PrescriptionWithPatientName> prescriptions = new ArrayList<>();
      for (Object object : jsonArray) {
        Gson gson = new GsonBuilder().create();
        prescriptions.add(gson.fromJson(object.toString().trim(), PrescriptionWithPatientName.class));
      }

      if (prescriptions.isEmpty()) {
        CustomAlerts.showemptyPrescriptionListAlert();
        throw new IOException();
      }

      Set<UserDetailsFromPrescriptions> userDetailsFromPrescriptions = new HashSet<>();
      prescriptions.forEach(p -> userDetailsFromPrescriptions.add(new UserDetailsFromPrescriptions(p.getPatientFirstName(), p.getPatientLastName(), p.getBirthDate(), p.getUserGender())));

      if (userDetailsFromPrescriptions.size() == 1) {
        return prescriptions;
      }
      else {
        return CustomAlerts.showemptyPatientMultipleAlert(userDetailsFromPrescriptions, prescriptions);
      }
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
