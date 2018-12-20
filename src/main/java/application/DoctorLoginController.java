package application;

import java.io.IOException;

import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import request.LoginSceneRequest;
import utility.JWTInfo;

public class DoctorLoginController {

  @FXML
  private GridPane datesGrid;
  
  @FXML
  private AnchorPane pane;

  @FXML
  private Button logInButton;

  @FXML
  private TextField userNameTextField;

  @FXML
  private PasswordField passwordField;

  @FXML
  private Text errorText;
  
  @FXML
  private ImageView imageViewBackground;
  
  private JWTInfo parsedJWT;

  @FXML
  private void initialize() {

    userNameTextField.setText("Doctor.Name");
    passwordField.setText("aA1!aaaa");
    datesGrid.getStyleClass().add("dates-grid");

    logInButton.setOnAction(event -> {

      Task<JWTInfo> task = new Task<JWTInfo>() {

        @Override
        protected JWTInfo call() throws Exception {
          parsedJWT = new LoginSceneRequest().sendLogInDoctorPOST(userNameTextField.getText(), passwordField.getText());
          try {
            if (parsedJWT != null) {
              Main.showPrincipalDoctorView(parsedJWT);
              errorText.setText("");
            }
            else {
              errorText.setText("Wrong username or password");
            }
          }
          catch (IOException e) {
            e.printStackTrace();
          }

          return null;
        }
      };
      task.run();
    });
    
    pane.widthProperty().addListener((ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) -> {
      imageViewBackground.setFitWidth(newSceneWidth.doubleValue());
    });
    
    pane.heightProperty().addListener((ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) -> {
      imageViewBackground.setFitHeight(newSceneHeight.doubleValue());
    });
  }
}
