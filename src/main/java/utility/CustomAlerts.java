package utility;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import application.CustomAlertController;
import application.Main;
import application.MultiplePatientsAlertController;
import entity.Drug;
import entity.PrescriptionWithPatientName;
import entity.UserDetailsFromPrescriptions;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CustomAlerts {

  private CustomAlerts() {
  }

  public static void showInternetErrorConnectionAlert() {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Connection eror");
    alert.setHeaderText("Error:");
    alert.setContentText("Could not connect to the internet");
    alert.showAndWait();
  }

  public static void showServerErrorConnectionAlert() {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Connection eror");
    alert.setHeaderText("Error:");
    alert.setContentText("Could not connect to server");
    alert.showAndWait();
  }

  public static void showServiceUnavailableAlert() {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Connection eror");
    alert.setHeaderText("Error:");
    alert.setContentText("Service unavailable");
    alert.showAndWait();
  }

  public static void showemptyPrescriptionListAlert() {
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Empty list");
    alert.setHeaderText("Prescription:");
    alert.setContentText("This patient does not have any prescription in this period");
    alert.showAndWait();
  }

  public static void showPatientDoesNotExistAlert() {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Database eror");
    alert.setHeaderText("Error:");
    alert.setContentText("Patient does not exist");
    alert.showAndWait();
  }

  public static void showDoctorDoesNotExistAlert() {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Database eror");
    alert.setHeaderText("Error:");
    alert.setContentText("Doctor does not exist");
    alert.showAndWait();
  }

  public static void showNoDrugslert() {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Fields error");
    alert.setHeaderText("Error:");
    alert.setContentText("Please insert at least 1 drug.");
    alert.showAndWait();
  }

  public static void showFutureDateAlert() {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Future date error");
    alert.setHeaderText("Date error:");
    alert.setContentText("Birth date or prescripted date can not be on the future.");
    alert.showAndWait();

  }

  public static void showPresciptionDatabaseAlert(String message) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Database error");
    alert.setHeaderText("Database error:");
    alert.setContentText(message);
    alert.showAndWait();
  }

  public static void showPrescriptionCreatedAlert(String firstName, String lastName) {
    Alert alert = new Alert(AlertType.CONFIRMATION);
    alert.setTitle("Prescrption created");
    alert.setHeaderText("Prescrption created");
    alert.setContentText("Prescrption created with success for " + firstName + " " + lastName + " at " + LocalDate.now());
    alert.showAndWait();
  }

  public static void showEmptyFieldsAlert() {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Error");
    alert.setHeaderText("Empty fields error:");
    alert.setContentText("Please complete all fields.");
    alert.showAndWait();
  }

  public static void showPrescriptionDoesNotExistAlert() {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Error");
    alert.setHeaderText("Database error:");
    alert.setContentText("Prescription could not be returned. Plase try again.");
    alert.showAndWait();
  }

  public static void showRegisteredPatientAlert(String firstName, String lastName) {
    Alert alert = new Alert(AlertType.CONFIRMATION);
    alert.setTitle("Patient registered");
    alert.setHeaderText("Patient registered sucessfully");
    alert.setContentText("Patient " + firstName + " " + lastName + " registered with success.");
    alert.showAndWait();
  }

  public static void showEmailSendingErrorAlert() {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Error");
    alert.setHeaderText("Server error error:");
    alert.setContentText("Email could not be sent. Please try again.");
    alert.showAndWait();
  }

  public static void showemptyDrugListAlert() {
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Empty list");
    alert.setHeaderText("Medicine:");
    alert.setContentText("There is no medicine with this name.");
    alert.showAndWait();
  }

  public static Drug showemptyDrugMultipleAlert(List<Drug> drugs) throws IOException {

    CustomAlertController dialogController = new CustomAlertController();
    dialogController.setDrugs(drugs);

    FXMLLoader loader = new FXMLLoader(Main.class.getResource("/fxml/customAlert.fxml"));

    loader.setController(dialogController);

    Stage stage = new Stage();
    try {
      stage.setScene(new Scene((AnchorPane)loader.load()));
    }
    catch (IOException e) {
    }

    stage.setResizable(false);
    stage.showAndWait();

    Drug result = dialogController.getDrugResult();
    
    if(result == null)
    {
      throw new IOException();
    }
    
    return result;
  }


  public static List<PrescriptionWithPatientName> showemptyPatientMultipleAlert(Set<UserDetailsFromPrescriptions> userDetailsFromPrescriptions, List<PrescriptionWithPatientName> prescriptions) throws IOException {
    MultiplePatientsAlertController dialogController = new MultiplePatientsAlertController();
    dialogController.setPrescriptions(prescriptions);
    dialogController.setUserDetailsFromPrescriptions(userDetailsFromPrescriptions);

    FXMLLoader loader = new FXMLLoader(Main.class.getResource("/fxml/multiplePatientsAlert.fxml"));

    loader.setController(dialogController);

    Stage stage = new Stage();
    try {
      stage.setScene(new Scene((AnchorPane)loader.load()));
    }
    catch (IOException e) {
    }

    stage.setResizable(false);
    stage.showAndWait();

    List<PrescriptionWithPatientName> result = dialogController.getResult();
    
    if(result == null)
    {
      throw new IOException();
    }
    
    return result;
  }
  
  public static void showDrugDoesNotExistAlert() {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Database eror");
    alert.setHeaderText("Error:");
    alert.setContentText("Medication does not exist");
    alert.showAndWait();
  }
}
