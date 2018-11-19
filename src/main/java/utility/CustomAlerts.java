package utility;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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
}
