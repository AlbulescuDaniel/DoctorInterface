package request;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import constant.Consts;
import entity.CreatePatientDTO;
import utility.CustomAlerts;
import utility.JWTInfo;

public class RegisterPatientRequest {

  private RegisterPatientRequest() {
  }

  public static void registerPatientRequest(JWTInfo token, CreatePatientDTO createPatientDTO) throws IOException {
    // if (!new Utility().isOnline()) {
    // CustomAlerts.showInternetErrorConnectionAlert();
    // throw new IOException();
    // }

    URL object = new URL(Consts.LOCAL_SERVER ? Consts.PREGISTER_PATIENT_URL : Consts.OPENSHIFT_PREGISTER_PATIENT_URL);
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
    jsonResponse.put("firstName", createPatientDTO.getFirstName());
    jsonResponse.put("lastName", createPatientDTO.getLastName());
    jsonResponse.put("cnp", createPatientDTO.getCnp());
    jsonResponse.put("birthDate", createPatientDTO.getBirthDate());
    jsonResponse.put("email", createPatientDTO.getEmail());
    jsonResponse.put("phoneNumber", createPatientDTO.getPhoneNumber());
    jsonResponse.put("gender", createPatientDTO.getGender());

    JSONObject jsonResponseAddress = new JSONObject();
    jsonResponseAddress.put("countryName", createPatientDTO.getAddress().getCountryName());
    jsonResponseAddress.put("postalCode", createPatientDTO.getAddress().getPostalCode());
    jsonResponseAddress.put("city", createPatientDTO.getAddress().getCity());
    jsonResponseAddress.put("region", createPatientDTO.getAddress().getRegion());
    jsonResponseAddress.put("street", createPatientDTO.getAddress().getStreet());
    jsonResponseAddress.put("streetNumber", createPatientDTO.getAddress().getStreetNumber());
    jsonResponse.put("address", jsonResponseAddress);

    OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
    wr.write(jsonResponse.toString());
    wr.flush();

    if (con.getResponseCode() == 201) {
      CustomAlerts.showRegisteredPatientAlert(createPatientDTO.getFirstName(), createPatientDTO.getFirstName());
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
    else if (con.getResponseCode() == 400) {
      CustomAlerts.showEmailSendingErrorAlert();
    }
    else {
      System.err.println(con.getResponseCode());
    }
  }
}