package application;

import java.io.IOException;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import request.LoginSceneRequest;
import utility.JWTInfo;

public class DoctorLoginController {

  @FXML
  private GridPane datesGrid;

  @FXML
  private Button logInButton;

  @FXML
  private TextField userNameTextField;

  @FXML
  private PasswordField passwordField;

  @FXML
  private Text errorText;
  private JWTInfo parsedJWT;

  @FXML
  private void initialize() {

    userNameTextField.setText("abc");
    passwordField.setText("1!aA1111");
    datesGrid.getStyleClass().add("dates-grid");

    logInButton.setOnAction(event -> {

      Task<JWTInfo> task = new Task<JWTInfo>() {

        @Override
        protected JWTInfo call() throws Exception {
          parsedJWT = new LoginSceneRequest().sendLogInDoctorPOST(userNameTextField.getText(), passwordField.getText());
          System.err.println("auci");
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
          }

          return null;
        }
      };
      task.run();
    });
  }
}
