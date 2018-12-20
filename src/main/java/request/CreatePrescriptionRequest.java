package request;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import constant.Consts;
import entity.Prescription;
import utility.CustomAlerts;
import utility.JWTInfo;

public class CreatePrescriptionRequest {

  private CreatePrescriptionRequest() {
  }

  public static void createPrescriptionRequest(String firstName, String lastName, JWTInfo token, Prescription prescription) throws IOException {
    // if (!new Utility().isOnline()) {
    // CustomAlerts.showInternetErrorConnectionAlert();
    // throw new IOException();
    // }

    URL object = new URL((Consts.LOCAL_SERVER ? Consts.CREATE_PRESCRIPTION_URL : Consts.OPENSHIFT_CREATE_PRESCRIPTION_URL) + "?firstName=" + firstName + "&lastName=" + lastName);
    HttpURLConnection con = (HttpURLConnection)object.openConnection();
    con.setDoOutput(true);
    con.setDoInput(true);
    con.setRequestProperty("Content-Type", "application/json");
    con.setRequestProperty("Accept", "application/json");
    con.setRequestProperty("Authorization", token.getToken());
    con.setRequestMethod("POST");
    try {
      con.connect();
    }
    catch (Exception e) {
      CustomAlerts.showServerErrorConnectionAlert();
    }

    if (prescription.getPrescriptionDrugs().isEmpty()) {
      CustomAlerts.showNoDrugslert();
      throw new IOException();
    }

    if (Instant.ofEpochMilli(prescription.getDatePrescripted().getTime()).atZone(ZoneId.systemDefault()).toLocalDate().isAfter(LocalDate.now())) {
      CustomAlerts.showFutureDateAlert();
      throw new IOException();
    }

    JSONObject jsonResponse = new JSONObject();
    jsonResponse.put("prescriptionNumber", prescription.getPrescriptionNumber());
    jsonResponse.put("hospitalType", prescription.getHospitalType());
    jsonResponse.put("patientType", prescription.getPatientType());
    jsonResponse.put("diagnostic", prescription.getDiagnostic());
    jsonResponse.put("datePrescripted", Instant.ofEpochMilli(prescription.getDatePrescripted().getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
    jsonResponse.put("userGender", prescription.getUserGender());
    jsonResponse.put("nationality", prescription.getNationality());

    JSONArray array = new JSONArray();
    prescription.getPrescriptionDrugs().forEach(prescriptionDrug -> {
      JSONObject prescriptionDrugJson = new JSONObject();
      prescriptionDrugJson.put("description", prescriptionDrug.getDescription());
      prescriptionDrugJson.put("pillsNumber", prescriptionDrug.getPillsNumber());
      prescriptionDrugJson.put("drug", prescriptionDrug.getDrug());
      prescriptionDrugJson.put("days", prescriptionDrug.getDays());
      array.put(prescriptionDrugJson);
    });

    jsonResponse.put("prescriptionDrugs", array);

    OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
    wr.write(jsonResponse.toString());
    wr.flush();

    if (con.getResponseCode() == 201) {
      CustomAlerts.showPrescriptionCreatedAlert(firstName, lastName);
    }
    else if (con.getResponseCode() == 503) {
      CustomAlerts.showServiceUnavailableAlert();
    }
    else if (con.getResponseCode() == 404) {

      Gson gson = new Gson();

      JsonReader reader = new JsonReader(new InputStreamReader(con.getErrorStream()));
      JsonObject response = gson.fromJson(reader, JsonObject.class);
      CustomAlerts.showPresciptionDatabaseAlert(response.get("details").toString().replace("[", "").replace("]", ""));
    }
    else {
      System.err.println(con.getResponseCode());
    }
  }

}
