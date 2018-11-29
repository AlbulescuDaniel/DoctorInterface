package table;

import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import entity.Prescription;
import entity.PrescriptionDrug;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;

public class PatientPrescriptionsTableControl {

  private PatientPrescriptionsTableControl() {
  }

  public static void setWidth(GridPane pane, TableView<PatientPrescriptionsTableFormat> table, TableColumn<PatientPrescriptionsTableFormat, String> diagnostic,
      TableColumn<PatientPrescriptionsTableFormat, String> days, TableColumn<PatientPrescriptionsTableFormat, Date> prescriptionDate,
      TableColumn<PatientPrescriptionsTableFormat, Long> prescriptionTableId) {
    prescriptionTableId.setPrefWidth(0d);
    pane.widthProperty().addListener((ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) -> {

      table.setPrefWidth(newSceneWidth.doubleValue() - 40);
      diagnostic.setPrefWidth(table.getPrefWidth() * 70 / 100);
      days.setPrefWidth(table.getPrefWidth() / 10);
      prescriptionDate.setPrefWidth(table.getPrefWidth() * 20 / 100);
    });
  }

  public static void initializePrescriptionTable(List<Prescription> prescriptions, TableView<PatientPrescriptionsTableFormat> table, TableColumn<PatientPrescriptionsTableFormat, String> diagnostic,
      TableColumn<PatientPrescriptionsTableFormat, String> days, TableColumn<PatientPrescriptionsTableFormat, Date> prescriptionDate,
      TableColumn<PatientPrescriptionsTableFormat, Long> prescriptionTableId) {
    days.setStyle("-fx-padding: 0 0 0 10;");
    prescriptionDate.setStyle("-fx-padding: 0 0 0 10;");
    diagnostic.setStyle("-fx-padding: 0 0 0 10;");

    ObservableList<PatientPrescriptionsTableFormat> fillTablePrescriptions = FXCollections.observableArrayList();
    prescriptions.forEach(p -> {
      Calendar cal = Calendar.getInstance();
      cal.setTime(p.getDatePrescripted());
      String formatedDate = cal.get(Calendar.DATE) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.YEAR);
      fillTablePrescriptions.add(new PatientPrescriptionsTableFormat(p.getId(), p.getDiagnostic(), createMedicationString(p.getPrescriptionDrugs()), formatedDate));
    });
    table.setItems(fillTablePrescriptions);

    prescriptionTableId.setCellValueFactory(new PropertyValueFactory<PatientPrescriptionsTableFormat, Long>("id"));
    days.setCellValueFactory(new PropertyValueFactory<PatientPrescriptionsTableFormat, String>("days"));
    prescriptionDate.setCellValueFactory(new PropertyValueFactory<PatientPrescriptionsTableFormat, Date>("datePrescripted"));
    diagnostic.setCellValueFactory(new PropertyValueFactory<PatientPrescriptionsTableFormat, String>("diagnostic"));
  }

  public static void prescriptionTableRowEvent(TableView<PatientPrescriptionsTableFormat> table, GridPane gridPanePrescription, GridPane gridPanelTable) {
    table.setRowFactory(e -> {
      TableRow<PatientPrescriptionsTableFormat> row = new TableRow<>();
      row.setOnMouseClicked(event -> {
        if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
          PatientPrescriptionsTableFormat clickedRow = row.getItem();
          Long id = clickedRow.getId();
          System.err.println(id);
          gridPanePrescription.setVisible(true);
          gridPanelTable.setVisible(false);
          // moveToPrescriptionGrid(prescription);
        }
      });
      return row;
    });
  }

  private static String createMedicationString(List<PrescriptionDrug> prescriptionDrugs) {
    StringBuilder builder = new StringBuilder();
    prescriptionDrugs.forEach(pd -> builder.append(pd.getDrug() + ", "));
    return builder.toString().substring(0, builder.toString().length() - 2);
  }
}
