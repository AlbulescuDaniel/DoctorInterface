package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import utility.JWTInfo;

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
    Scene scene;
    try {
      scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/DoctorPrincipalScene.fxml")));
      scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
      primaryStage.setScene(scene);
      primaryStage.setWidth(1200);
      primaryStage.setMinWidth(1200);
      primaryStage.setHeight(800);
      primaryStage.setMinHeight(800);
      primaryStage.setResizable(true);
      primaryStage.show();
    }
    catch (IOException e) {
      e.getStackTrace();
    }
  }

  public static void showPrincipalDoctorView(JWTInfo parsedJWT) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader();
    fxmlLoader.setLocation(Main.class.getResource("/fxml/DoctorPrincipalScene.fxml"));
    GridPane pane = fxmlLoader.load();

    DoctorPrincipalSceneController cvc = fxmlLoader.getController();
    cvc.setToken(parsedJWT);

    Scene scene = new Scene(pane, 1200, 800);
    scene.getStylesheets().add(Main.class.getResource("/css/application.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.setWidth(1200);
    primaryStage.setMinWidth(1200);
    primaryStage.setHeight(800);
    primaryStage.setMinHeight(800);
    primaryStage.setResizable(true);
    primaryStage.show();
  }
}
