package table;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

import entity.Prescription;
import entity.PrescriptionDrug;
import entity.UserGender;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import utility.CustomAlerts;

public class CreatePrescriptionTableControl {
  private CreatePrescriptionTableControl() {
  }

  public static void init(TableView<CreatePrescriptionTableFormat> prescriptMedicamentTable, TableColumn<CreatePrescriptionTableFormat, String> prescriptMedicamentName,
      TableColumn<CreatePrescriptionTableFormat, String> createPrescriptionNumberColumn, TableColumn<CreatePrescriptionTableFormat, String> prescriptMedicamentPrescriptedDays,
      TableColumn<CreatePrescriptionTableFormat, String> prescriptMedicamentPillsPerDay, TableColumn<CreatePrescriptionTableFormat, String> prescriptMedicamentObservations) {
    prescriptMedicamentTable.setEditable(true);
    prescriptMedicamentTable.getSelectionModel().cellSelectionEnabledProperty().set(true);

    prescriptMedicamentName.setCellFactory(TextFieldTableCell.forTableColumn());
    prescriptMedicamentName.setCellValueFactory(new PropertyValueFactory<>("name"));
    prescriptMedicamentName.setOnEditCommit(t -> t.getTableView().getItems().get(t.getTablePosition().getRow()).setName(t.getNewValue()));

    createPrescriptionNumberColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    createPrescriptionNumberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
    createPrescriptionNumberColumn.setOnEditCommit(t -> t.getTableView().getItems().get(t.getTablePosition().getRow()).setNumber(t.getNewValue()));

    prescriptMedicamentPrescriptedDays.setCellFactory(TextFieldTableCell.forTableColumn());
    prescriptMedicamentPrescriptedDays.setCellValueFactory(new PropertyValueFactory<>("days"));
    prescriptMedicamentPrescriptedDays.setOnEditCommit(t -> t.getTableView().getItems().get(t.getTablePosition().getRow()).setDays(t.getNewValue()));

    prescriptMedicamentPillsPerDay.setCellFactory(TextFieldTableCell.forTableColumn());
    prescriptMedicamentPillsPerDay.setCellValueFactory(new PropertyValueFactory<>("pillsPerDay"));
    prescriptMedicamentPillsPerDay.setOnEditCommit(t -> t.getTableView().getItems().get(t.getTablePosition().getRow()).setPillsPerDay(t.getNewValue()));

    prescriptMedicamentObservations.setCellFactory(TextFieldTableCell.forTableColumn());
    prescriptMedicamentObservations.setCellValueFactory(new PropertyValueFactory<>("observations"));
    prescriptMedicamentObservations.setOnEditCommit(t -> t.getTableView().getItems().get(t.getTablePosition().getRow()).setObservations(t.getNewValue()));

    prescriptMedicamentTable.setOnKeyPressed(event -> {
      if (event.getCode().isLetterKey() || event.getCode().isDigitKey()) {
      }
      else if (event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.TAB) {
        prescriptMedicamentTable.getSelectionModel().selectNext();
        event.consume();
      }
      else if (event.getCode() == KeyCode.LEFT) {
        selectPrevious(prescriptMedicamentTable);
        event.consume();
      }
    });

    prescriptMedicamentTable.setRowFactory(e -> {
      final TableRow<CreatePrescriptionTableFormat> row = new TableRow<>();

      row.hoverProperty().addListener(observable -> {
        final CreatePrescriptionTableFormat person = row.getItem();

        if (row.isHover() && person != null) {
          row.setStyle("-fx-border-color: lightgray; -fx-background-color: gray;");
        }
        if (!row.isHover()) {
          row.setStyle("-fx-background-color: linear-gradient(white 0%, white 90%, #e0e0e0 90%);");
        }
      });
      return row;
    });

  }

  @SuppressWarnings("unchecked")
  private static void selectPrevious(TableView<CreatePrescriptionTableFormat> prescriptMedicamentTable) {
    if (prescriptMedicamentTable.getSelectionModel().isCellSelectionEnabled()) {
      TablePosition<CreatePrescriptionTableFormat, ?> pos = prescriptMedicamentTable.getFocusModel().getFocusedCell();
      if (pos.getColumn() - 1 >= 0) {
        prescriptMedicamentTable.getSelectionModel().select(pos.getRow(), getTableColumn(pos.getTableColumn(), -1, prescriptMedicamentTable));
      }
      else if (pos.getRow() < prescriptMedicamentTable.getItems().size()) {
        prescriptMedicamentTable.getSelectionModel().select(pos.getRow() - 1, prescriptMedicamentTable.getVisibleLeafColumn(prescriptMedicamentTable.getVisibleLeafColumns().size() - 1));
      }
    }
    else {
      int focusIndex = prescriptMedicamentTable.getFocusModel().getFocusedIndex();
      if (focusIndex == -1) {
        prescriptMedicamentTable.getSelectionModel().select(prescriptMedicamentTable.getItems().size() - 1);
      }
      else if (focusIndex > 0) {
        prescriptMedicamentTable.getSelectionModel().select(focusIndex - 1);
      }
    }
  }

  private static TableColumn<CreatePrescriptionTableFormat, ?> getTableColumn(final TableColumn<CreatePrescriptionTableFormat, ?> column, int offset,
      TableView<CreatePrescriptionTableFormat> prescriptMedicamentTable) {
    int columnIndex = prescriptMedicamentTable.getVisibleLeafIndex(column);
    int newColumnIndex = columnIndex + offset;
    return prescriptMedicamentTable.getVisibleLeafColumn(newColumnIndex);
  }

  public static void setWidth(GridPane pane, ColumnConstraints createPrescriptionGridColumn, GridPane createPrescriptionGridPane) {

    pane.widthProperty().addListener((ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) -> {
      createPrescriptionGridColumn.setPrefWidth(newSceneWidth.doubleValue() - 500);
      createPrescriptionGridPane.setPrefWidth(newSceneWidth.doubleValue() - 20);
    });
  }

  public static void setHeight(GridPane pane, RowConstraints createPrescriptionComponentsGridRow, ScrollPane createPrescriptionScrollPane, GridPane createPrescriptionGridPane,
      AnchorPane createPrescriptionAnchorPane) {

    Double minHeight = Double.valueOf(400);
    Double prefHeight = Double.valueOf(540);

    createPrescriptionGridPane.setMinHeight(minHeight);
    createPrescriptionComponentsGridRow.setMinHeight(minHeight);
    createPrescriptionScrollPane.setMinHeight(minHeight);
    createPrescriptionAnchorPane.setMinHeight(minHeight);

    pane.heightProperty().addListener((ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) -> {
      Double newuPrefHeight = newSceneHeight.doubleValue() * Double.valueOf(54 / 100d);
      if(newuPrefHeight <= prefHeight) {
        System.err.println(newuPrefHeight);
        createPrescriptionComponentsGridRow.setMinHeight(newuPrefHeight);
        createPrescriptionScrollPane.setMinHeight(newuPrefHeight);
        createPrescriptionGridPane.setPrefHeight(newuPrefHeight);
      }
    });
  }

  public static void addRowInCreatePrescriptionMedicamentTable(TableView<CreatePrescriptionTableFormat> prescriptMedicamentTable) {
    CreatePrescriptionTableFormat createPrescriptionTableFormat = new CreatePrescriptionTableFormat();
    createPrescriptionTableFormat.setNumber(String.valueOf(prescriptMedicamentTable.getItems().size() + 1));
    prescriptMedicamentTable.getItems().add(createPrescriptionTableFormat);
  }

  public static Prescription getPrescription(TableView<CreatePrescriptionTableFormat> prescriptMedicamentTable, TextField createPrescriptionNumber, TextField createPrescriptionHospitalName,
      TextField createPrescriptionStateTextField, TextField createPrescriptionURCTextField, TextField createPrescriptionHospitalPhone, TextField createPrescriptionDoctorEmail,
      TextField createPrescriptionFirstName, TextField createPrescriptionLastName, TextField createPrescriptionCNP, DatePicker createPrescriptionPrescriptionDate,
      DatePicker createPrescriptionBirthDate, TextArea createPrescriptionPatientDiagnostic, TextField createPrescriptionNationalityTextField, ToggleGroup createPrescriptionGender,
      ToggleGroup createPrescriptionType, ToggleGroup createPatientInstitution) throws IOException {
    RadioButton button = (RadioButton)createPatientInstitution.getSelectedToggle();
    String hospitalType = button.getText();

    button = (RadioButton)createPrescriptionType.getSelectedToggle();
    String patienttype = button.getText();

    button = (RadioButton)createPrescriptionGender.getSelectedToggle();
    UserGender gender = button.getText().equals("M") ? UserGender.Male : UserGender.Female;

    if (createPrescriptionNumber.getText().equals("") || createPrescriptionPatientDiagnostic.getText().equals("") || createPrescriptionNationalityTextField.getText().equals("")
        || createPrescriptionHospitalName.getText().equals("") || createPrescriptionStateTextField.getText().equals("") || createPrescriptionURCTextField.getText().equals("")
        || createPrescriptionHospitalPhone.getText().equals("") || createPrescriptionDoctorEmail.getText().equals("") || createPrescriptionFirstName.getText().equals("")
        || createPrescriptionLastName.getText().equals("") || createPrescriptionCNP.getText().equals("")) {
      CustomAlerts.showEmptyFieldsAlert();
      throw new IOException();
    }

    Prescription prescription = new Prescription(Long.valueOf(1), Long.valueOf(createPrescriptionNumber.getText()), hospitalType, patienttype, createPrescriptionPatientDiagnostic.getText(),
        createPrescriptionPrescriptionDate.getValue(), gender, createPrescriptionNationalityTextField.getText(), new ArrayList<PrescriptionDrug>());

    ObservableList<CreatePrescriptionTableFormat> rowList = prescriptMedicamentTable.getItems();
    rowList.forEach(entity -> prescription.getPrescriptionDrugs().add(transform(entity)));

    if (createPrescriptionBirthDate.getValue().isAfter(LocalDate.now())) {
      CustomAlerts.showFutureDateAlert();
      throw new IOException();
    }

    return prescription;

  }

  private static PrescriptionDrug transform(CreatePrescriptionTableFormat tableFormat) {
    PrescriptionDrug prescriptionDrug = new PrescriptionDrug();
    prescriptionDrug.setDays(Integer.valueOf(tableFormat.getDays()));
    prescriptionDrug.setDescription(tableFormat.getObservations());
    prescriptionDrug.setDrug(tableFormat.getName());
    prescriptionDrug.setPillsNumber(Integer.valueOf(tableFormat.getNumber()));
    return prescriptionDrug;
  }
}
