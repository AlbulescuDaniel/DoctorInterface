package application;

import java.util.List;

import entity.Drug;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

public class CustomAlertController {

  @FXML
  private TableView<Drug> medicationTable;

  @FXML
  TableColumn<Drug, String> medicationTableNameColumn;

  private List<Drug> drugs;
  
  private Drug resultDrug = null;
  
  public Drug getDrugResult() {
    return resultDrug;
  }

  public void setDrugs(List<Drug> drugs) {
    this.drugs = drugs;
  }

  @FXML
  private void initialize() {
    System.out.println(drugs.size());
    
    medicationTableNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

    ObservableList<Drug> fillTablePrescriptions = FXCollections.observableArrayList();
    drugs.forEach(p -> fillTablePrescriptions.add(p));
    medicationTable.setItems(fillTablePrescriptions);
    
    medicationTable.setRowFactory(e -> {
      TableRow<Drug> row = new TableRow<>();

      row.hoverProperty().addListener(observable -> {
        final Drug name = row.getItem();

        if (row.isHover() && name != null) {
          row.setStyle("-fx-border-color: lightgray; -fx-background-color: gray;");
        }
        if (!row.isHover()) {
          row.setStyle("-fx-background-color: linear-gradient(white 0%, white 90%, #e0e0e0 90%);");
        }
      });

      row.setOnMouseClicked(event -> {
        if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
          Drug clickedRow = row.getItem();
          drugs.forEach(d -> {
            if(d.getName().equals(clickedRow.getName())) {
              resultDrug = d;
            }
          });
        }
        Stage stage = (Stage) medicationTable.getScene().getWindow();
        stage.close();
      });
      return row;
    });
  }

}
