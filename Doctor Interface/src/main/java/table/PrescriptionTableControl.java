package table;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import entity.Prescription;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import utility.GUIUtils;

public class PrescriptionTableControl {

  private PrescriptionTableControl() {
  }

  public static void setTableColumnWidth(GridPane pane, TableView<PrescriptionTableFormat> table, TableColumn<PrescriptionTableFormat, String> diagnostic,
      TableColumn<PrescriptionTableFormat, String> days, TableColumn<PrescriptionTableFormat, Date> prescriptionDate, TableColumn<PrescriptionTableFormat, Long> prescriptionTableId) {
    prescriptionTableId.setPrefWidth(0d);
    pane.widthProperty().addListener((ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) -> {
      table.setPrefWidth(newSceneWidth.doubleValue() - 40);
      diagnostic.setPrefWidth(table.getPrefWidth() * 70 / 100);
      days.setPrefWidth(table.getPrefWidth() / 10);
      prescriptionDate.setPrefWidth(table.getPrefWidth() * 20 / 100);
    });
  }

  public static void initializePrescriptionTable(List<Prescription> prescriptions, TableView<PrescriptionTableFormat> table, TableColumn<PrescriptionTableFormat, String> diagnostic,
      TableColumn<PrescriptionTableFormat, String> days, TableColumn<PrescriptionTableFormat, Date> prescriptionDate, TableColumn<PrescriptionTableFormat, Long> prescriptionTableId) {
    days.setStyle("-fx-padding: 0 0 0 10;");
    prescriptionDate.setStyle("-fx-padding: 0 0 0 10;");
    diagnostic.setStyle("-fx-padding: 0 0 0 10;");

    ObservableList<PrescriptionTableFormat> fillTablePrescriptions = FXCollections.observableArrayList();
    prescriptions.forEach(p -> {
      Calendar cal = Calendar.getInstance();
      cal.setTime(p.getDatePrescripted());
      String formatedDate = cal.get(Calendar.DATE) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.YEAR);
      fillTablePrescriptions.add(new PrescriptionTableFormat(p.getId(), p.getDiagnostic(), p.getDays(), formatedDate));
    });
    table.setItems(fillTablePrescriptions);

    days.setCellValueFactory(new PropertyValueFactory<PrescriptionTableFormat, String>("days"));
    prescriptionDate.setCellValueFactory(new PropertyValueFactory<PrescriptionTableFormat, Date>("datePrescripted"));
    diagnostic.setCellValueFactory(new PropertyValueFactory<PrescriptionTableFormat, String>("diagnostic"));
  }
  
  public static void prescriptionTableRowEvent(TableView<PrescriptionTableFormat> table) {
    table.setRowFactory(e -> {
      TableRow<PrescriptionTableFormat> row = new TableRow<>();
      row.setOnMouseClicked(event -> {
        if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
          PrescriptionTableFormat clickedRow = row.getItem();
          Long id = clickedRow.getId();
//          moveToPrescriptionGrid(prescription);
        }
      });
      return row;
    });
  }
}
