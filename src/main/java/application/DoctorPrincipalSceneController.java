package application;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import entity.Address;
import entity.CreatePatientDTO;
import entity.Prescription;
import entity.PrescriptionDetails;
import entity.PrescriptionDoctorHospital;
import entity.UserGender;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import request.AutocompletePrescriptionRequest;
import request.CreatePrescriptionRequest;
import request.PrescriptionDetailsRequest;
import request.PrescriptionsTabRequest;
import request.RegisterPatientRequest;
import table.CreatePrescriptionTableControl;
import table.CreatePrescriptionTableFormat;
import table.MedicamentsTableControl;
import table.PatientPrescriptionsTableControl;
import table.PatientPrescriptionsTableFormat;
import table.PrescriptionDetailsTableControl;
import utility.DateFormatConverter;
import utility.JWTInfo;

public class DoctorPrincipalSceneController {

  @FXML
  private GridPane pane;

  @FXML
  private ColumnConstraints createPrescriptionGridColumn;

  @FXML
  private RowConstraints createPrescriptionComponentsGridRow;

  @FXML
  private GridPane createPrescriptionGridPane;

  @FXML
  private ScrollPane createPrescriptionScrollPane;

  @FXML
  private AnchorPane createPrescriptionAnchorPane;
  
  @FXML
  private AnchorPane registerPatientAnchorPane;

  @FXML
  private Button button;

  @FXML
  private Button populateTableButton;

  @FXML
  private Button populatePharmaciesTableButton;

  @FXML
  private Button registerPatientButton;

  @FXML
  private Button createPrescriptionDoctorAutocomplete;

  @FXML
  private Button addDrugButton;

  @FXML
  private Button createPrescriptionButton;

  @FXML
  private TableView<PatientPrescriptionsTableFormat> table;

  @FXML
  private TableView<CreatePrescriptionTableFormat> prescriptMedicamentTable;

  @FXML
  private TableView<CreatePrescriptionTableFormat> medicamentTable;

  // @FXML
  // private TableView<PharmacyTableCompletation> pharmaciesTable;
  //

  @FXML
  private TableColumn<CreatePrescriptionTableFormat, String> prescriptMedicamentName;

  @FXML
  private TableColumn<CreatePrescriptionTableFormat, String> createPrescriptionNumberColumn;

  @FXML
  private TableColumn<CreatePrescriptionTableFormat, String> prescriptMedicamentPrescriptedDays;

  @FXML
  private TableColumn<CreatePrescriptionTableFormat, String> prescriptMedicamentPillsPerDay;

  @FXML
  private TableColumn<CreatePrescriptionTableFormat, String> prescriptMedicamentObservations;

  @FXML
  private TableColumn<PatientPrescriptionsTableFormat, Long> prescriptionTableId;

  @FXML
  private TableColumn<PatientPrescriptionsTableFormat, String> days;

  @FXML
  private TableColumn<PatientPrescriptionsTableFormat, Date> prescriptionDate;

  @FXML
  private TableColumn<PatientPrescriptionsTableFormat, String> diagnostic;

  @FXML
  private TableColumn<CreatePrescriptionTableFormat, String> medicamentName;

  @FXML
  private TableColumn<CreatePrescriptionTableFormat, String> pills;

  @FXML
  private TableColumn<CreatePrescriptionTableFormat, String> observations;

  @FXML
  private TableColumn<CreatePrescriptionTableFormat, String> daysLabel;

  @SuppressWarnings("rawtypes")
  @FXML
  private TableColumn pharmacyName;

  @SuppressWarnings("rawtypes")
  @FXML
  private TableColumn pharmacyCity;

  @SuppressWarnings("rawtypes")
  @FXML
  private TableColumn pharmacyStreet;

  @SuppressWarnings("rawtypes")
  @FXML
  private TableColumn pharmacyStreetNumber;

  @SuppressWarnings("rawtypes")
  @FXML
  private TableColumn pharmacyPhone;

  @SuppressWarnings("rawtypes")
  @FXML
  private TableColumn medicamentPrce;

  @FXML
  private DatePicker datepickerFrom;

  @FXML
  private DatePicker datepickerTo;

  @FXML
  private DatePicker registerPatientDatePicker;

  @FXML
  private RadioButton createPrescriptionRadioButtonMale;

  @FXML
  private RadioButton createPrescriptionRadioButtonFemale;

  @FXML
  private RadioButton registerPatientRadioButtonMale;

  @FXML
  private RadioButton registerPatientRadioButtonFemale;

  @FXML
  private RadioButton createPrescriptionFamilyDoctorBox;

  @FXML
  private RadioButton createPrescriptionPoliclinicBox;

  @FXML
  private RadioButton createPrescriptionHospitalBox;

  @FXML
  private RadioButton createPrescriptionOtherInstitutionBox;

  @FXML
  private RadioButton createPrescriptionEmployeeBox;

  @FXML
  private RadioButton createPrescriptionInsuredBox;

  @FXML
  private RadioButton createPrescriptionFreelanceBox;

  @FXML
  private RadioButton createPrescriptionChildBox;

  @FXML
  private RadioButton createPrescriptionStudentBox;

  @FXML
  private RadioButton createPrescriptionPregnantBox;

  @FXML
  private RadioButton createPrescriptionRetiredBox;

  @FXML
  private RadioButton createPrescriptionVeteranBox;

  @FXML
  private RadioButton createPrescriptionHandicapBox;

  @FXML
  private RadioButton createPrescriptionSocialAidBox;

  @FXML
  private RadioButton createPrescriptionUnemployedBox;

  @FXML
  private RadioButton createPrescriptionStaffBox;

  @FXML
  private RadioButton createPrescriptionEuropeanBox;

  @FXML
  private RadioButton createPrescriptionOthersBox;

  @FXML
  private GridPane gridPanelTable;

  @FXML
  private GridPane gridPanePrescription;

  @FXML
  private TextField createPrescriptionNumber;

  @FXML
  private TextField createPrescriptionHospitalName;

  @FXML
  private TextField createPrescriptionHospitalPhone;

  @FXML
  private TextField createPrescriptionDoctorEmail;

  @FXML
  private TextField createPrescriptionFirstName;

  @FXML
  private TextField createPrescriptionLastName;

  @FXML
  private TextField createPrescriptionCNP;

  @FXML
  private TextField createPrescriptionNationalityTextField;

  @FXML
  private DatePicker createPrescriptionBirthDate;

  @FXML
  private DatePicker createPrescriptionPrescriptionDate;

  @FXML
  private Label doctorNameLabel;

  @FXML
  private Label doctorSpecialityLabel;

  @FXML
  private Label doctorEmailLabel;

  @FXML
  private Label presctiptionDateLabel;

  @FXML
  private Label hospitalNameLabel;

  @FXML
  private Label hospitalEmailLabel;

  @FXML
  private Label hospitalCityLabel;

  @FXML
  private Label diagnosticLabel;

  @FXML
  private TextField createPrescriptionURCTextField;

  @FXML
  private TextField createPrescriptionStateTextField;

  @FXML
  private TextArea createPrescriptionPatientDiagnostic;

  @FXML
  private TextField firstNameField;

  @FXML
  private TextField lastNameField;

  @FXML
  private TextField medicamentInPharmacyTab;

  @FXML
  private TextField cityInPharmacyTab;

  @FXML
  private TextField firstNameRegister;

  @FXML
  private TextField lasNameRegister;

  @FXML
  private TextField phoneRegister;

  @FXML
  private TextField postalCodeRegister;

  @FXML
  private TextField regionRegister;

  @FXML
  private TextField emailRegister;

  @FXML
  private TextField cityRegister;

  @FXML
  private TextField countryRegister;

  @FXML
  private TextField streetRegister;

  @FXML
  private TextField streetNumberRegister;

  @FXML
  private TextField persolanlIdNumberregister;
  
  @FXML
  private TextField nationalityRegister;
  
  @FXML
  private ColumnConstraints registerPatientFieldsColumn;

  private JWTInfo token;

  private ToggleGroup createPatientGender;
  private ToggleGroup createPrescriptionGender;
  private ToggleGroup createPrescriptionType;
  private ToggleGroup createPatientInstitution;

  public void setToken(JWTInfo token) {
    this.token = token;
  }

  @FXML
  private void initialize() {
    gridPanePrescription.setVisible(false);
    datepickerFrom.setValue(LocalDate.now().minusYears(1));
    datepickerTo.setValue(LocalDate.now());
    createToggleGroups();
    createPrescriptionBirthDate.setValue(LocalDate.now());
    createPrescriptionPrescriptionDate.setValue(LocalDate.now());
    DateFormatConverter.setConverter(datepickerFrom, datepickerTo, registerPatientDatePicker, createPrescriptionBirthDate, createPrescriptionPrescriptionDate);

    PatientPrescriptionsTableControl.setWidth(pane, table, diagnostic, days, prescriptionDate, prescriptionTableId);
    CreatePrescriptionTableControl.setWidth(pane, createPrescriptionGridColumn, createPrescriptionGridPane);
    PrescriptionDetailsTableControl.setWidth(pane, table, medicamentName, daysLabel, pills, observations, registerPatientAnchorPane, registerPatientFieldsColumn);
    CreatePrescriptionTableControl.setHeight(pane, createPrescriptionComponentsGridRow, createPrescriptionScrollPane, createPrescriptionGridPane, createPrescriptionAnchorPane);
    CreatePrescriptionTableControl.init(prescriptMedicamentTable, prescriptMedicamentName, createPrescriptionNumberColumn, prescriptMedicamentPrescriptedDays, prescriptMedicamentPillsPerDay,
        prescriptMedicamentObservations);
    MedicamentsTableControl.setWidth(pane, pharmacyName, pharmacyCity, pharmacyStreet, pharmacyStreetNumber, pharmacyPhone, medicamentPrce);

    button.setOnAction(event -> {
      gridPanePrescription.setVisible(false);
      gridPanelTable.setVisible(true);
    });

    populateTableButton.setOnAction(event -> {
      try {
        List<Prescription> prescriptions = PrescriptionsTabRequest.requestFillPrescriptionTable(firstNameField.getText(), lastNameField.getText(), datepickerFrom.getValue(), datepickerTo.getValue(),
            token);
        PatientPrescriptionsTableControl.initializePrescriptionTable(prescriptions, table, diagnostic, days, prescriptionDate, prescriptionTableId);
      }
      catch (IOException e) {
      }

    });

    addDrugButton.setOnAction(event -> CreatePrescriptionTableControl.addRowInCreatePrescriptionMedicamentTable(prescriptMedicamentTable));

    createPrescriptionButton.setOnAction(event -> {
      try {
        Prescription prescription = CreatePrescriptionTableControl.getPrescription(prescriptMedicamentTable, createPrescriptionNumber, createPrescriptionHospitalName, createPrescriptionStateTextField,
            createPrescriptionURCTextField, createPrescriptionHospitalPhone, createPrescriptionDoctorEmail, createPrescriptionFirstName, createPrescriptionLastName, createPrescriptionCNP,
            createPrescriptionPrescriptionDate, createPrescriptionBirthDate, createPrescriptionPatientDiagnostic, createPrescriptionNationalityTextField, createPrescriptionGender,
            createPrescriptionType, createPatientInstitution);
        CreatePrescriptionRequest.createPrescriptionRequest(createPrescriptionFirstName.getText(), createPrescriptionLastName.getText(), token, prescription);
      }
      catch (IOException e) {
      }
    });

    createPrescriptionDoctorAutocomplete.setOnAction(event -> {
      try {
        PrescriptionDoctorHospital prescriptionDoctorHospital = AutocompletePrescriptionRequest.autocompleteRequest(token);

        createPrescriptionNumber.setText(prescriptionDoctorHospital.getPrescriptionNumber().toString());
        createPrescriptionHospitalName.setText(prescriptionDoctorHospital.getHospitalName());
        createPrescriptionURCTextField.setText(prescriptionDoctorHospital.getHospitalURC());
        createPrescriptionStateTextField.setText(prescriptionDoctorHospital.getHospitalState());
        createPrescriptionHospitalPhone.setText(prescriptionDoctorHospital.getHospitalPhone());
        createPrescriptionDoctorEmail.setText(prescriptionDoctorHospital.getDoctorEmail());
      }
      catch (IOException e) {
      }
    });

    table.setRowFactory(e -> {
      TableRow<PatientPrescriptionsTableFormat> row = new TableRow<>();
      row.setOnMouseClicked(event -> {
        if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
          PatientPrescriptionsTableFormat clickedRow = row.getItem();
          Long id = clickedRow.getId();
          try {
            PrescriptionDetails prescriptionDetails = PrescriptionDetailsRequest.prescriptionDetailsRequest(id, token);
            if (prescriptionDetails != null) {
              PrescriptionDetailsTableControl.fillFields(prescriptionDetails, doctorNameLabel, doctorSpecialityLabel, doctorEmailLabel, hospitalNameLabel, hospitalCityLabel, hospitalEmailLabel,
                  diagnosticLabel, presctiptionDateLabel);
              PrescriptionDetailsTableControl.initTable(prescriptionDetails.getPrescriptionDrugDTO(), medicamentTable, medicamentName, daysLabel, pills, observations);
              gridPanePrescription.setVisible(true);
              gridPanelTable.setVisible(false);
            }
          }
          catch (IOException e1) {
          }
        }
      });
      return row;
    });

    registerPatientButton.setOnAction(event -> {
      try {
        RadioButton createPatientGenderButton = (RadioButton)createPatientGender.getSelectedToggle();
        RegisterPatientRequest.registerPatientRequest(token,
            new CreatePatientDTO(emailRegister.getText(), phoneRegister.getText(), firstNameRegister.getText(), lasNameRegister.getText(), persolanlIdNumberregister.getText(),
                registerPatientDatePicker.getValue(), createPatientGenderButton.getText().equals("M") ? UserGender.Male : UserGender.Female,
                new Address(countryRegister.getText(), postalCodeRegister.getText(), cityRegister.getText(), regionRegister.getText(), streetRegister.getText(), streetNumberRegister.getText()), nationalityRegister.getText()));
      }
      catch (IOException e) {
      }
    });

  }

  private void createToggleGroups() {
    createPatientGender = new ToggleGroup();
    registerPatientRadioButtonMale.setSelected(true);
    registerPatientRadioButtonMale.setToggleGroup(createPatientGender);
    registerPatientRadioButtonFemale.setToggleGroup(createPatientGender); // createPrescriptionRadioButtonMale

    createPrescriptionGender = new ToggleGroup();
    createPrescriptionRadioButtonMale.setSelected(true);
    createPrescriptionRadioButtonMale.setToggleGroup(createPrescriptionGender);
    createPrescriptionRadioButtonFemale.setToggleGroup(createPrescriptionGender);

    createPrescriptionType = new ToggleGroup();
    createPrescriptionEmployeeBox.setSelected(true);
    createPrescriptionFreelanceBox.setToggleGroup(createPrescriptionType);
    createPrescriptionInsuredBox.setToggleGroup(createPrescriptionType);
    createPrescriptionEmployeeBox.setToggleGroup(createPrescriptionType);
    createPrescriptionChildBox.setToggleGroup(createPrescriptionType);
    createPrescriptionStudentBox.setToggleGroup(createPrescriptionType);
    createPrescriptionPregnantBox.setToggleGroup(createPrescriptionType);
    createPrescriptionRetiredBox.setToggleGroup(createPrescriptionType);
    createPrescriptionVeteranBox.setToggleGroup(createPrescriptionType);
    createPrescriptionHandicapBox.setToggleGroup(createPrescriptionType);
    createPrescriptionSocialAidBox.setToggleGroup(createPrescriptionType);
    createPrescriptionUnemployedBox.setToggleGroup(createPrescriptionType);
    createPrescriptionStaffBox.setToggleGroup(createPrescriptionType);
    createPrescriptionEuropeanBox.setToggleGroup(createPrescriptionType);
    createPrescriptionOthersBox.setToggleGroup(createPrescriptionType);

    createPatientInstitution = new ToggleGroup();
    createPrescriptionFamilyDoctorBox.setSelected(true);
    createPrescriptionPoliclinicBox.setToggleGroup(createPatientInstitution);
    createPrescriptionFamilyDoctorBox.setToggleGroup(createPatientInstitution);
    createPrescriptionHospitalBox.setToggleGroup(createPatientInstitution);
    createPrescriptionOtherInstitutionBox.setToggleGroup(createPatientInstitution);
  }

}
