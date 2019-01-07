package application;

import entity.DoctorProfile;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class DoctorProfileController {
  
  @FXML
  private TextArea firstNameProfile;
  
  @FXML
  private TextArea lastNameProfile;
  
  @FXML
  private TextArea userNameProfile;
  
  @FXML
  private TextArea specialityProfile;
  
  @FXML
  private TextArea emailProfile;
  
  @FXML
  private TextArea phoneProfile;
  
  @FXML
  private TextArea countryProfile;
  
  @FXML
  private TextArea cityProfile;
  
  @FXML
  private TextArea regionProfile;
  
  @FXML
  private TextArea postalCodeProfile;
  
  @FXML
  private TextArea streetProfile;
  
  @FXML
  private TextArea streetNumberProfile;
  
  @FXML
  private TextArea hospitalProfile;
  
  @FXML
  private TextArea hospitalEmailProfile;
  
  @FXML
  private Button closeButton;
  
  private DoctorProfile doctorProfile;
  
  public void setDoctorProfile(DoctorProfile doctorProfile) {
    this.doctorProfile = doctorProfile;
  }

  @FXML
  private void initialize() {
    System.err.println(doctorProfile);
    firstNameProfile.setText(doctorProfile.getFirstName());
    lastNameProfile.setText(doctorProfile.getLastName());
    userNameProfile.setText(doctorProfile.getUserName());
    specialityProfile.setText(doctorProfile.getSpeciality());
    emailProfile.setText(doctorProfile.getEmail());
    phoneProfile.setText(doctorProfile.getPhoneNumber());
    countryProfile.setText(doctorProfile.getAddressDTO().getCountryName());
    cityProfile.setText(doctorProfile.getAddressDTO().getCity());
    regionProfile.setText(doctorProfile.getAddressDTO().getRegion());
    postalCodeProfile.setText(doctorProfile.getAddressDTO().getPostalCode());
    streetProfile.setText(doctorProfile.getAddressDTO().getStreet());
    streetNumberProfile.setText(doctorProfile.getAddressDTO().getStreetNumber());
    hospitalProfile.setText(doctorProfile.getHospitalName());
    hospitalEmailProfile.setText(doctorProfile.getHospitalEmail());
    
    closeButton.setOnAction(event -> {
      Stage stage = (Stage) closeButton.getScene().getWindow();
      stage.close();
    });
  }
}
