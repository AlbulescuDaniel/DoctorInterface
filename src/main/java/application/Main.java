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
    Main.primaryStage.setWidth(1200);
    Main.primaryStage.setMinWidth(1200);
    Main.primaryStage.setHeight(800);
    Main.primaryStage.setMinHeight(800);
    Main.primaryStage.setResizable(true);
    showLoginView();
  }

  public static void main(String[] args) {
    launch(args);
  }

  public static void showLoginView() {
    try {
      Scene scene = new Scene(FXMLLoader.load(Main.class.getResource("/fxml/DoctorLogin.fxml")));
      scene.getStylesheets().add(Main.class.getResource("/css/application.css").toExternalForm());
      primaryStage.setScene(scene);
      primaryStage.show();
    }
    catch (IOException e) {
      e.getStackTrace();
    }
  }

  public static void showPrincipalDoctorView(JWTInfo parsedJWT) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader();
    fxmlLoader.setLocation(Main.class.getResource("/fxml/DoctorPrincipalScene.fxml"));
    
    DoctorPrincipalSceneController controller = new DoctorPrincipalSceneController();
    controller.setToken(parsedJWT);
    
    fxmlLoader.setController(controller);
    
    GridPane pane = fxmlLoader.load();

    Scene scene = new Scene(pane);
    scene.getStylesheets().add(Main.class.getResource("/css/application.css").toExternalForm());
    
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
