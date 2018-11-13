package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import utility.JWTInfo;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public class Main extends Application {

  private static Stage primaryStage;

  @Override
  public void start(Stage primaryStage) {
    Main.primaryStage = primaryStage;
    showLoginView();
  }

  public static void main(String[] args) {
    launch(args);
  }

  public void showLoginView() {
    try {
      Scene scene = new Scene((Parent)FXMLLoader.load(getClass().getResource("DoctorLogin.fxml")));
      scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
      primaryStage.setScene(scene);
      primaryStage.setWidth(1200);
      primaryStage.setHeight(800);
      primaryStage.setResizable(false);
      primaryStage.show();
    }
    catch (Exception e) {
    }
  }

  public static void showPrincipalDoctorView(JWTInfo parsedJWT) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader();
    fxmlLoader.setLocation(Main.class.getResource("DoctorPrincipalScene.fxml"));
    GridPane pane = fxmlLoader.load();

    DoctorPrincipalSceneController cvc = fxmlLoader.getController();
    cvc.setToken(parsedJWT);

    Scene scene = new Scene(pane, 1200, 800);
    scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.setResizable(true);
    primaryStage.show();
  }
}
