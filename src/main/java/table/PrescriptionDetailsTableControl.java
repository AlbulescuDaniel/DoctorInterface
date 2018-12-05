package table;

import java.time.ZoneId;
import java.util.List;

import entity.PrescriptionDetails;
import entity.PrescriptionDrug;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class PrescriptionDetailsTableControl {

  private PrescriptionDetailsTableControl() {
  }

  public static void fillFields(PrescriptionDetails prescriptionDetails, Label doctorNameLabel, Label doctorSpecialityLabel, Label doctorEmailLabel, Label hospitalNameLabel, Label hospitalCityLabel,
      Label hospitalEmailLabel, Label diagnosticLabel, Label presctiptionDateLabel) {
    doctorNameLabel.setText(prescriptionDetails.getDoctorName());
    doctorSpecialityLabel.setText(prescriptionDetails.getDoctorSpeciality());
    doctorEmailLabel.setText(prescriptionDetails.getDoctorEmail());
    hospitalNameLabel.setText(prescriptionDetails.getHospitalName());
    hospitalCityLabel.setText(prescriptionDetails.getHospitalCity());
    hospitalEmailLabel.setText(prescriptionDetails.getHospitalEmail());
    diagnosticLabel.setText(prescriptionDetails.getDiagnostic());
    presctiptionDateLabel.setText(prescriptionDetails.getPrescriptionDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString());

    doctorNameLabel.setStyle("-fx-border-color: lightgray; -fx-padding: 0 0 0 10;");
    doctorSpecialityLabel.setStyle("-fx-border-color: lightgray; -fx-padding: 0 0 0 10;");
    doctorEmailLabel.setStyle("-fx-border-color: lightgray; -fx-padding: 0 0 0 10;");
    hospitalNameLabel.setStyle("-fx-border-color: lightgray; -fx-padding: 0 0 0 10;");
    hospitalCityLabel.setStyle("-fx-border-color: lightgray; -fx-padding: 0 0 0 10;");
    hospitalEmailLabel.setStyle("-fx-border-color: lightgray; -fx-padding: 0 0 0 10;");
  }

  public static void initTable(List<PrescriptionDrug> list, TableView<CreatePrescriptionTableFormat> table, TableColumn<CreatePrescriptionTableFormat, String> medicamentName,
      TableColumn<CreatePrescriptionTableFormat, String> daysLabel, TableColumn<CreatePrescriptionTableFormat, String> pills, TableColumn<CreatePrescriptionTableFormat, String> observations) {
    medicamentName.setCellValueFactory(new PropertyValueFactory<>("name"));
    daysLabel.setCellValueFactory(new PropertyValueFactory<>("days"));
    pills.setCellValueFactory(new PropertyValueFactory<>("pillsPerDay"));
    observations.setCellValueFactory(new PropertyValueFactory<>("observations"));

    ObservableList<CreatePrescriptionTableFormat> fillTablePrescriptions = FXCollections.observableArrayList();
    list.forEach(p -> fillTablePrescriptions.add(new CreatePrescriptionTableFormat("", p.getDrug(), p.getDays().toString(), p.getPillsNumber().toString(), p.getDescription())));
    table.setItems(fillTablePrescriptions);
  }

  public static void setWidth(GridPane pane, TableView<PatientPrescriptionsTableFormat> table, TableColumn<CreatePrescriptionTableFormat, String> medicamentName,
      TableColumn<CreatePrescriptionTableFormat, String> daysLabel, TableColumn<CreatePrescriptionTableFormat, String> pills, TableColumn<CreatePrescriptionTableFormat, String> observations,
      AnchorPane registerPatientAnchorPane, ColumnConstraints registerPatientFieldsColumn) {

    medicamentName.setStyle("-fx-padding: 0 0 0 10;");
    daysLabel.setStyle("-fx-padding: 0 0 0 10;");
    pills.setStyle("-fx-padding: 0 0 0 10;");
    observations.setStyle("-fx-padding: 0 0 0 10;");

    pane.widthProperty().addListener((ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) -> {
      registerPatientAnchorPane.setPrefWidth(newSceneWidth.doubleValue());
      medicamentName.setPrefWidth(newSceneWidth.doubleValue() * 30 / 100);
      daysLabel.setPrefWidth(table.getPrefWidth() * 10 / 100);
      pills.setPrefWidth(table.getPrefWidth() * 10 / 100);
      observations.setPrefWidth(table.getPrefWidth() * 50 / 100);

      registerPatientFieldsColumn.setPrefWidth(table.getPrefWidth() * 30 / 100);
      registerPatientFieldsColumn.setMaxWidth(table.getPrefWidth() * 30 / 100);
    });
  }
}
