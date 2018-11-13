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
}
