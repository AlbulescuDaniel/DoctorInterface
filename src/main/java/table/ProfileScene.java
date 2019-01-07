package table;

import java.io.IOException;

import application.DoctorProfileController;
import application.Main;
import entity.DoctorProfile;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ProfileScene {

  public void initProfile(DoctorProfile doctorProfile) {
    DoctorProfileController profileController = new DoctorProfileController();
    profileController.setDoctorProfile(doctorProfile);

    FXMLLoader loader = new FXMLLoader(Main.class.getResource("/fxml/doctorProfile.fxml"));

    loader.setController(profileController);

    Stage stage = new Stage();
    try {
      stage.setScene(new Scene((AnchorPane)loader.load()));
    }
    catch (IOException e) {
    }

    stage.setResizable(false);
    stage.showAndWait();
  }
}
