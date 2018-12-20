package application;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import application.MultiplePatientsAlertController.UserDetailsFromPrescriptionsTransform;
import entity.PrescriptionWithPatientName;
import entity.UserDetailsFromPrescriptions;
import entity.UserGender;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

public class MultiplePatientsAlertController {

  @FXML
  private TableView<UserDetailsFromPrescriptionsTransform> medicationTable;

  @FXML
  TableColumn<UserDetailsFromPrescriptionsTransform, String> firstNameColumn;

  @FXML
  TableColumn<UserDetailsFromPrescriptionsTransform, String> lastNameColumn;

  @FXML
  TableColumn<UserDetailsFromPrescriptionsTransform, LocalDate> birthDateColumn;

  @FXML
  TableColumn<UserDetailsFromPrescriptionsTransform, String> genderColumn;

  private Set<UserDetailsFromPrescriptions> userDetailsFromPrescriptions;

  private List<PrescriptionWithPatientName> prescriptions;

  private List<PrescriptionWithPatientName> result = new ArrayList<>();

  public void setUserDetailsFromPrescriptions(Set<UserDetailsFromPrescriptions> userDetailsFromPrescriptions) {
    this.userDetailsFromPrescriptions = userDetailsFromPrescriptions;
  }

  public void setPrescriptions(List<PrescriptionWithPatientName> prescriptions) {
    this.prescriptions = prescriptions;
  }

  public List<PrescriptionWithPatientName> getResult() {
    return result;
  }

  @FXML
  private void initialize() {

    firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
    lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
    birthDateColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
    genderColumn.setCellValueFactory(new PropertyValueFactory<>("userGender"));

    ObservableList<UserDetailsFromPrescriptionsTransform> fillTablePrescriptions = FXCollections.observableArrayList();
    userDetailsFromPrescriptions.forEach(p -> fillTablePrescriptions.add(new UserDetailsFromPrescriptionsTransform(p)));

    medicationTable.setItems(fillTablePrescriptions);

    medicationTable.setRowFactory(e -> {
      TableRow<UserDetailsFromPrescriptionsTransform> row = new TableRow<>();

      row.hoverProperty().addListener(observable -> {
        final UserDetailsFromPrescriptionsTransform name = row.getItem();

        if (row.isHover() && name != null) {
          row.setStyle("-fx-border-color: lightgray; -fx-background-color: gray;");
        }
        if (!row.isHover()) {
          row.setStyle("-fx-background-color: linear-gradient(white 0%, white 90%, #e0e0e0 90%);");
        }
      });

      row.setOnMouseClicked(event -> {
        if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
          UserDetailsFromPrescriptionsTransform clickedRow = row.getItem();
          prescriptions.forEach(prescription -> {
            if (prescription.getPatientFirstName().equals(clickedRow.firstName) && prescription.getPatientLastName().equals(clickedRow.getLastName())
                && Instant.ofEpochMilli(prescription.getBirthDate().getTime()).atZone(ZoneId.systemDefault()).toLocalDate().equals(clickedRow.getBirthDate())
                && prescription.getUserGender().equals(clickedRow.getUserGender())) {
              result.add(prescription);
            }
          });
          Stage stage = (Stage)medicationTable.getScene().getWindow();
          stage.close();
        }
      });
      return row;
    });
  }

  public static class UserDetailsFromPrescriptionsTransform {
    String firstName;
    String lastName;
    private LocalDate birthDate;
    private UserGender userGender;

    public UserDetailsFromPrescriptionsTransform(UserDetailsFromPrescriptions users) {
      super();
      this.firstName = users.getFirstName();
      this.lastName = users.getLastName();
      this.birthDate = Instant.ofEpochMilli(users.getBirthDate().getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
      this.userGender = users.getUserGender();
    }

    public String getFirstName() {
      return firstName;
    }

    public String getLastName() {
      return lastName;
    }

    public LocalDate getBirthDate() {
      return birthDate;
    }

    public UserGender getUserGender() {
      return userGender;
    }
  }
}
