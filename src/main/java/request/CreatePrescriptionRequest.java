package request;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Instant;
import java.time.ZoneId;

import org.json.JSONArray;
import org.json.JSONObject;

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

    URL object = new URL(Consts.CREATE_PRESCRIPTION_URL + "?firstName=" + firstName + "&lastName=" + lastName);
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

    System.out.println(jsonResponse);

    OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
    wr.write(jsonResponse.toString());
    wr.flush();

    if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
      System.err.println("created");
    }
    else if (con.getResponseCode() == 503) {
      CustomAlerts.showServiceUnavailableAlert();
    }
    else if (con.getResponseCode() == 404) {
      System.err.println(con.getResponseCode());
    }
    else {
      System.err.println(con.getResponseCode());

    }
  }

}
