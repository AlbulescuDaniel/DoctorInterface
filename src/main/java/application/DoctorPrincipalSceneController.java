package application;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import entity.Prescription;
import entity.PrescriptionDoctorHospital;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import request.AutocompletePrescriptionRequest;
import request.CreatePrescriptionRequest;
import request.PrescriptionsTabRequest;
import table.CreatePrescriptionTableControl;
import table.CreatePrescriptionTableFormat;
import table.MedicamentsTableControl;
import table.PatientPrescriptionsTableControl;
import table.PatientPrescriptionsTableFormat;
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
  private AnchorPane CreatePrescriptionAnchorPane;

  @FXML
  private Button button;

  @FXML
  private Button populateTableButton;

  @FXML
  private Button populatePharmaciesTableButton;

  @FXML
  private Button patientRegisterButton;

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

  // @FXML
  // private TableView<MedicamentTableCompletation> medicamentTable;
  //
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

  @SuppressWarnings("rawtypes")
  @FXML
  private TableColumn checked;

  @SuppressWarnings("rawtypes")
  @FXML
  private TableColumn medicamentName;

  @SuppressWarnings("rawtypes")
  @FXML
  private TableColumn pills;

  @SuppressWarnings("rawtypes")
  @FXML
  private TableColumn observations;

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
  private Label daysLabel;

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
  private TextField emailRegister;

  @FXML
  private TextField cityRegister;

  @FXML
  private TextField countryRegister;

  @FXML
  private TextField persolanlIdNumberregister;

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
    gridPanePrescription.setVisible(true);
    datepickerFrom.setValue(LocalDate.now().minusYears(1));
    datepickerTo.setValue(LocalDate.now());
    createToggleGroups();
    DateFormatConverter.setConverter(datepickerFrom, datepickerTo, registerPatientDatePicker);

    PatientPrescriptionsTableControl.setWidth(pane, table, diagnostic, days, prescriptionDate, prescriptionTableId);
    PatientPrescriptionsTableControl.prescriptionTableRowEvent(table, gridPanePrescription, gridPanelTable);
    CreatePrescriptionTableControl.setWidth(pane, createPrescriptionGridColumn, createPrescriptionGridPane);
    CreatePrescriptionTableControl.setHeight(pane, createPrescriptionComponentsGridRow, createPrescriptionScrollPane, createPrescriptionGridPane, CreatePrescriptionAnchorPane);
    CreatePrescriptionTableControl.init(prescriptMedicamentTable, prescriptMedicamentName, createPrescriptionNumberColumn, prescriptMedicamentPrescriptedDays, prescriptMedicamentPillsPerDay,
        prescriptMedicamentObservations);
    MedicamentsTableControl.setWidth(pane, pharmacyName, pharmacyCity, pharmacyStreet, pharmacyStreetNumber, pharmacyPhone, medicamentPrce);

    button.setOnAction(event -> {
      gridPanePrescription.setVisible(false);
      gridPanelTable.setVisible(true);
    });

    populateTableButton.setOnAction(event -> {
      try {
        List<Prescription> prescriptions = PrescriptionsTabRequest.requestFillPrescriptionTable(firstNameField.getText(), lastNameField.getText(), datepickerFrom.getValue(), datepickerTo.getValue());
        PatientPrescriptionsTableControl.initializePrescriptionTable(prescriptions, table, diagnostic, days, prescriptionDate, prescriptionTableId);
      }
      catch (IOException e) {
      }
    });

    addDrugButton.setOnAction(event -> {
      CreatePrescriptionTableControl.addRowInCreatePrescriptionMedicamentTable(prescriptMedicamentTable);
    });

    createPrescriptionButton.setOnAction(event -> {
      Prescription prescription = CreatePrescriptionTableControl.getPrescription(prescriptMedicamentTable, createPrescriptionNumber, createPrescriptionHospitalName, createPrescriptionStateTextField,
          createPrescriptionURCTextField, createPrescriptionHospitalPhone, createPrescriptionDoctorEmail, createPrescriptionFirstName, createPrescriptionLastName, createPrescriptionCNP,
          createPrescriptionBirthDate, createPrescriptionPatientDiagnostic, createPrescriptionNationalityTextField, createPrescriptionGender, createPrescriptionType, createPatientInstitution);
      System.err.println(prescription);
      try {
        CreatePrescriptionRequest.createPrescriptionRequest(createPrescriptionFirstName.getText(), createPrescriptionLastName.getText(), token, prescription);
      }
      catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
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
    //
    // populatePharmaciesTableButton.setOnAction(new EventHandler<ActionEvent>() {
    // @Override
    // public void handle(ActionEvent event) {
    // try {
    // PharmaciesTabRequest fill = new PharmaciesTabRequest();
    // String response = null;
    // List<Pharmacy> pharmacies = new ArrayList<>();
    //
    // int count = 0;
    // if (medicamentInPharmacyTab.getText().compareTo("") == 0) {
    // medicamentInPharmacyTab.setStyle("-fx-border-color: red; -fx-border-width: 1.5px ;");
    // count++;
    // }
    // else
    // medicamentInPharmacyTab.setStyle("-fx-border-color: gray; -fx-border-width: 0px ;");
    // if (cityInPharmacyTab.getText().compareTo("") == 0) {
    // cityInPharmacyTab.setStyle("-fx-border-color: red; -fx-border-width: 1.5px ;");
    // count++;
    // }
    // else
    // cityInPharmacyTab.setStyle("-fx-border-color: gray; -fx-border-width: 0px ;");
    //
    // if (count == 0) {
    // response = fill.getPharmaciesByMedicamentRequest(medicamentInPharmacyTab.getText().toLowerCase().toString(),
    // cityInPharmacyTab.getText().substring(0, 1).toUpperCase() + cityInPharmacyTab.getText().substring(1).toLowerCase());
    // ObjectMapper mapper = new ObjectMapper();
    //
    // JsonNode rootNode = null;
    // Alert alert = null;
    // switch (response) {
    // case "400":
    // alert = new Alert(AlertType.INFORMATION);
    // alert.setTitle("Patient information");
    // alert.setContentText("This medicament does not exist or pharmacies do not have it in stock");
    // alert.showAndWait();
    // break;
    // case Consts.SERVER_CLOSED:
    // alert = new Alert(AlertType.ERROR);
    // alert.setTitle("Error");
    // alert.setHeaderText("Server Error");
    // alert.setContentText(response);
    // alert.showAndWait();
    // default:
    // rootNode = mapper.readTree(response);
    // if (rootNode.isArray()) {
    // for (final JsonNode objNode : rootNode) {
    // pharmacies.add(mapper.readValue(objNode, Pharmacy.class));
    // }
    // }
    // ObservableList<PharmacyTableCompletation> fillTablePharmacies = FXCollections.observableArrayList();
    //
    // pharmacies.forEach(p -> fillTablePharmacies
    // .add(new PharmacyTableCompletation(p.getPharmacyName(), p.getStreet(), p.getCity(), p.getStreetNumber(), p.getPhone(), p.getPharmacyStocksByIdPharmacy().get(0).getPrice())));
    //
    // initializePharmaciesTable();
    // pharmaciesTable.setItems(fillTablePharmacies);
    // }
    // }
    // }
    // catch (Exception e) {
    // e.printStackTrace();
    // }
    // }
    // });
    //
    // patientRegisterButton.setOnAction(new EventHandler<ActionEvent>() {
    // @Override
    // public void handle(ActionEvent event) {
    // JSONObject jsonResponse = new JSONObject();
    // try {
    // jsonResponse.put("firstName", firstNameRegister.getText());
    // jsonResponse.put("lastName", lasNameRegister.getText());
    // jsonResponse.put("age", ageRegister.getText());
    // jsonResponse.put("phone", phoneRegister.getText());
    // jsonResponse.put("city", cityRegister.getText());
    // jsonResponse.put("country", countryRegister.getText());
    // jsonResponse.put("addressLine", addressLineRegister.getText());
    // jsonResponse.put("postalCode", postalCodeRegister.getText());
    // jsonResponse.put("email", emailRegister.getText());
    // jsonResponse.put("cnp", CNPRegister.getText());
    // jsonResponse.put("birthDate", registerPatientDatePicker.getValue());
    //
    // if (registerPatientRadioButtonMale.isSelected())
    // jsonResponse.put("gender", "male");
    // else
    // jsonResponse.put("gender", "female");
    //
    // firstNameRegister.getStyleClass().add("text-input-error");
    // int count = 0;
    // if (firstNameRegister.getText().compareTo("") == 0) {
    // firstNameRegister.setStyle("-fx-border-color: red; -fx-border-width: 1.5px ;");
    // count++;
    // }
    // else
    // firstNameRegister.setStyle("-fx-border-color: gray; -fx-border-width: 0px ;");
    // if (lasNameRegister.getText().compareTo("") == 0) {
    // lasNameRegister.setStyle("-fx-border-color: red; -fx-border-width: 1.5px ;");
    // count++;
    // }
    // else
    // lasNameRegister.setStyle("-fx-border-color: gray; -fx-border-width: 0px ;");
    // if (ageRegister.getText().compareTo("") == 0 || !isInteger(ageRegister.getText())) {
    // ageRegister.setStyle("-fx-border-color: red; -fx-border-width: 1.5px ;");
    // count++;
    // }
    // else
    // ageRegister.setStyle("-fx-border-color: gray; -fx-border-width: 0px ;");
    // if (phoneRegister.getText().compareTo("") == 0) {
    // phoneRegister.setStyle("-fx-border-color: red; -fx-border-width: 1.5px ;");
    // count++;
    // }
    // else
    // phoneRegister.setStyle("-fx-border-color: gray; -fx-border-width: 0px ;");
    // if (cityRegister.getText().compareTo("") == 0) {
    // cityRegister.setStyle("-fx-border-color: red; -fx-border-width: 1.5px ;");
    // count++;
    // }
    // else
    // cityRegister.setStyle("-fx-border-color: gray; -fx-border-width: 0px ;");
    // if (countryRegister.getText().compareTo("") == 0) {
    // countryRegister.setStyle("-fx-border-color: red; -fx-border-width: 1.5px ;");
    // count++;
    // }
    // else
    // countryRegister.setStyle("-fx-border-color: gray; -fx-border-width: 0px ;");
    // if (addressLineRegister.getText().compareTo("") == 0) {
    // addressLineRegister.setStyle("-fx-border-color: red; -fx-border-width: 1.5px ;");
    // count++;
    // }
    // else
    // addressLineRegister.setStyle("-fx-border-color: gray; -fx-border-width: 0px ;");
    // if (postalCodeRegister.getText().compareTo("") == 0) {
    // postalCodeRegister.setStyle("-fx-border-color: red; -fx-border-width: 1.5px ;");
    // count++;
    // }
    // else
    // postalCodeRegister.setStyle("-fx-border-color: gray; -fx-border-width: 0px ;");
    // if (emailRegister.getText().compareTo("") == 0) {
    // emailRegister.setStyle("-fx-border-color: red; -fx-border-width: 1.5px ;");
    // count++;
    // }
    // else
    // emailRegister.setStyle("-fx-border-color: gray; -fx-border-width: 0px ;");
    // if (CNPRegister.getText().compareTo("") == 0) {
    // CNPRegister.setStyle("-fx-border-color: red; -fx-border-width: 1.5px ;");
    // count++;
    // }
    // else
    // CNPRegister.setStyle("-fx-border-color: gray; -fx-border-width: 0px ;");
    // if (registerPatientDatePicker.getValue() == null) {
    // registerPatientDatePicker.setStyle("-fx-border-color: red; -fx-border-width: 1.5px ;");
    // count++;
    // }
    // else {
    // registerPatientDatePicker.setStyle("-fx-border-color: gray; -fx-border-width: 0px ;");
    //
    // }
    // if (count == 0) {
    // RegisterPatientTabRequest register = new RegisterPatientTabRequest();
    // String response = register.sendRegisterPatientPOST(jsonResponse);
    // if (response.compareTo(Consts.TRUE_VALUE) == 0) {
    // Alert alert = new Alert(AlertType.CONFIRMATION);
    // alert.setTitle("Patient registered");
    // alert.setHeaderText("Success:");
    // alert.setContentText("Patient registered successfully");
    // alert.showAndWait();
    // }
    // else {
    // Alert alert = new Alert(AlertType.ERROR);
    // alert.setTitle("Registration eror");
    // alert.setHeaderText("Error:");
    // alert.setContentText("Patient is already registred or this E-mail is already in use");
    // alert.showAndWait();
    // }
    // }
    // }
    // catch (JSONException e) {
    // e.printStackTrace();
    // }
    // catch (IOException e) {
    // e.printStackTrace();
    // }
    // }
    // });
    //
    // createPrescriptionDoctorAutocomplete.setOnAction(new EventHandler<ActionEvent>() {
    // @Override
    // public void handle(ActionEvent arg0) {
    //
    // CreatePrescriptionTabRequest fill = new CreatePrescriptionTabRequest();
    // String response = null;
    // Doctor doctor = new Doctor();
    // ObjectMapper mapper = new ObjectMapper();
    //
    // try {
    // response = fill.autocompleteDoctor(email);
    // JsonNode rootNode = null;
    // Alert alert = null;
    // switch (response) {
    // case "400":
    // alert = new Alert(AlertType.INFORMATION);
    // alert.setTitle("Doctor information");
    // alert.setContentText("This doctor does not exist");
    // alert.showAndWait();
    // break;
    // case Consts.SERVER_CLOSED:
    // alert = new Alert(AlertType.ERROR);
    // alert.setTitle("Error");
    // alert.setHeaderText("Server Error");
    // alert.setContentText(response);
    // alert.showAndWait();
    // default:
    // rootNode = mapper.readTree(response);
    // doctor = (mapper.readValue(rootNode, Doctor.class));
    // createPrescriptionDoctorFirstName.setText(doctor.getFirstName());
    // createPrescriptionDoctorLastName.setText(doctor.getLastName());
    //
    // List<DoctorSpeciality> ds = doctor.getDoctorSpecialitiesById();
    // String specialty = "";
    // for (DoctorSpeciality d : ds) {
    // specialty += d.getSpecialityBySpecialityId().getName();
    // }
    //
    // createPrescriptionDoctorSoeciality.setText(specialty);
    // createPrescriptionDoctorPhone.setText(doctor.getPhone());
    // createPrescriptionDoctorEmail.setText(doctor.getEmail());
    // createPrescriptionHospitalName.setText(doctor.getHospital().getHospitalName());
    // createPrescriptionHospitalFullAddress.setText("county " + doctor.getHospital().getState() + ", city " + doctor.getHospital().getCity() + ", street " + doctor.getHospital().getStreet()
    // + ", number " + doctor.getHospital().getStreetNumber());
    // createPrescriptionPrescriptionDate.setValue(newLocalDate());
    // }
    // }
    // catch (Exception e) {
    // e.printStackTrace();
    // }
    // }
    // });
    //
    // createPrescriptionPatientAutocomplete.setOnAction(new EventHandler<ActionEvent>() {
    // @Override
    // public void handle(ActionEvent arg0) {
    //
    // CreatePrescriptionTabRequest fill = new CreatePrescriptionTabRequest();
    // String response = null;
    // Patient patient = new Patient();
    // ObjectMapper mapper = new ObjectMapper();
    //
    // int count = 0;
    // if (createPrescriptionPatientFirstName.getText().compareTo("") == 0) {
    // createPrescriptionPatientFirstName.setStyle("-fx-border-color: red; -fx-border-width: 1.5px ;");
    // count++;
    // }
    // else
    // createPrescriptionPatientFirstName.setStyle("-fx-border-color: gray; -fx-border-width: 0px ;");
    // if (createPrescriptionPatientLastName.getText().compareTo("") == 0) {
    // createPrescriptionPatientLastName.setStyle("-fx-border-color: red; -fx-border-width: 1.5px ;");
    // count++;
    // }
    // else
    // createPrescriptionPatientLastName.setStyle("-fx-border-color: gray; -fx-border-width: 0px ;");
    //
    // if (count == 0) {
    // try {
    // String firstName, lastName;
    // firstName = createPrescriptionPatientFirstName.getText();
    // lastName = createPrescriptionPatientLastName.getText();
    //
    // response = fill.autocompletePatient(firstName, lastName);
    // System.out.println(response + " <--- response");
    // JsonNode rootNode = null;
    // Alert alert = null;
    // switch (response) {
    // case "400":
    // alert = new Alert(AlertType.INFORMATION);
    // alert.setTitle("Patient information");
    // alert.setContentText("This patient does not exist");
    // alert.showAndWait();
    // break;
    // case "404":
    // alert = new Alert(AlertType.INFORMATION);
    // alert.setTitle("Patient information");
    // alert.setContentText("This patient does not exist");
    // alert.showAndWait();
    // break;
    // case Consts.SERVER_CLOSED:
    // alert = new Alert(AlertType.ERROR);
    // alert.setTitle("Error");
    // alert.setHeaderText("Server Error");
    // alert.setContentText(response);
    // alert.showAndWait();
    // default:
    // rootNode = mapper.readTree(response);
    // patient = (mapper.readValue(rootNode, Patient.class));
    //
    // createPrescriptionPatientCnp.setText(patient.getCnp());
    // createPrescriptionBirthDate.setValue(formatedDate(patient.getBirthDate()));
    //
    // System.out.println(patient);
    // }
    // }
    // catch (Exception e) {
    // e.printStackTrace();
    // }
    // }
    // }
    // });
    // prescriptMedicamentTable.setEditable(true);
    // ObservableList<MedicamentInCreatePrescriptionTableCompletation> fillTableMedicaments = FXCollections.observableArrayList();
    // prescriptMedicamentName.setCellValueFactory(new PropertyValueFactory<MedicamentInCreatePrescriptionTableCompletation, String>("medicamentName"));
    // prescriptMedicamentPrescriptedDays.setCellValueFactory(new PropertyValueFactory<MedicamentInCreatePrescriptionTableCompletation, String>("prescriptedDays"));
    // prescriptMedicamentPillsPerDay.setCellValueFactory(new PropertyValueFactory<MedicamentInCreatePrescriptionTableCompletation, String>("pillsPerDay"));
    // prescriptMedicamentObservations.setCellValueFactory(new PropertyValueFactory<MedicamentInCreatePrescriptionTableCompletation, String>("observations"));
    //
    // prescriptMedicamentName.setCellFactory(TextFieldTableCell.forTableColumn());
    // prescriptMedicamentName.setOnEditCommit(new EventHandler<CellEditEvent<MedicamentInCreatePrescriptionTableCompletation, String>>() {
    // public void handle(CellEditEvent<MedicamentInCreatePrescriptionTableCompletation, String> t) {
    // ((MedicamentInCreatePrescriptionTableCompletation)t.getTableView().getItems().get(t.getTablePosition().getRow())).setMedicamentName(t.getNewValue());
    // }
    // });
    //
    // prescriptMedicamentPrescriptedDays.setCellFactory(TextFieldTableCell.forTableColumn());
    // prescriptMedicamentPrescriptedDays.setOnEditCommit(new EventHandler<CellEditEvent<MedicamentInCreatePrescriptionTableCompletation, String>>() {
    // public void handle(CellEditEvent<MedicamentInCreatePrescriptionTableCompletation, String> t) {
    // ((MedicamentInCreatePrescriptionTableCompletation)t.getTableView().getItems().get(t.getTablePosition().getRow())).setPrescriptedDays(t.getNewValue());
    // }
    // });
    //
    // prescriptMedicamentPillsPerDay.setCellFactory(TextFieldTableCell.forTableColumn());
    // prescriptMedicamentPillsPerDay.setOnEditCommit(new EventHandler<CellEditEvent<MedicamentInCreatePrescriptionTableCompletation, String>>() {
    // public void handle(CellEditEvent<MedicamentInCreatePrescriptionTableCompletation, String> t) {
    // ((MedicamentInCreatePrescriptionTableCompletation)t.getTableView().getItems().get(t.getTablePosition().getRow())).setPillsPerDay(t.getNewValue());
    // }
    // });
    //
    // prescriptMedicamentObservations.setCellFactory(TextFieldTableCell.forTableColumn());
    // prescriptMedicamentObservations.setOnEditCommit(new EventHandler<CellEditEvent<MedicamentInCreatePrescriptionTableCompletation, String>>() {
    // public void handle(CellEditEvent<MedicamentInCreatePrescriptionTableCompletation, String> t) {
    // ((MedicamentInCreatePrescriptionTableCompletation)t.getTableView().getItems().get(t.getTablePosition().getRow())).setObservations(t.getNewValue());
    // }
    // });
    // prescriptMedicamentTable.setStyle("-fx-background-color: white;");
    // createPrescriptionAddMedicament.setOnAction(new EventHandler<ActionEvent>() {
    // @Override
    // public void handle(ActionEvent arg0) {
    // fillTableMedicaments.add(new MedicamentInCreatePrescriptionTableCompletation());
    // prescriptMedicamentTable.setItems(fillTableMedicaments);
    // }
    // });
    //
    // createPrescriptionSend.setOnAction(new EventHandler<ActionEvent>() {
    // @Override
    // public void handle(ActionEvent arg0) {
    //
    // }
    // });
  }

  // private String concatenateSpecialities(List<DoctorSpeciality> doctorSpecialities) {
  // String specialities = "";
  //
  // for (DoctorSpeciality ds : doctorSpecialities) {
  // if (specialities.compareTo("") == 0)
  // specialities += ds.getSpecialityBySpecialityId().getName();
  // else
  // specialities += ", " + ds.getSpecialityBySpecialityId().getName();
  // }
  // return specialities;
  // }
  //
  //
  // private LocalDate formatedDate(Date date) {
  // Instant instant = date.toInstant();
  // LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
  // return localDate;
  // }

  //
  // private void moveToPrescriptionGrid(PatientPrescriptionsTableFormat prescription) {
  // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
  //
  // gridPanelTable.setVisible(false);
  // gridPanePrescription.setVisible(true);
  //
  // doctorNameLabel.setText(prescription.getDoctorByIdDoctor().getFirstName() + " " + prescription.getDoctorByIdDoctor().getLastName());
  // doctorSpecialityLabel.setText(concatenateSpecialities(prescription.getDoctorByIdDoctor().getDoctorSpecialitiesById()));
  // doctorEmailLabel.setText(prescription.getDoctorByIdDoctor().getEmail());
  // presctiptionDateLabel.setText(formatedDate(prescription.getDatePrescripted()).format(formatter));
  // daysLabel.setText(((Integer)prescription.getDays()).toString());
  // diagnosticLabel.setText(prescription.getDiagnostic());
  //
  // checked.setStyle("-fx-alignment: CENTER;");
  // medicamentName.setStyle("-fx-padding: 0 0 0 10;");
  // pills.setStyle("-fx-padding: 0 0 0 10;");
  // observations.setStyle("-fx-padding: 0 0 0 10;");
  //
  // checked.setCellValueFactory(new PropertyValueFactory<MedicamentTableCompletation, Image>("checkedImage"));
  // medicamentName.setCellValueFactory(new PropertyValueFactory<MedicamentTableCompletation, String>("medicamentName"));
  // pills.setCellValueFactory(new PropertyValueFactory<MedicamentTableCompletation, Integer>("pills"));
  // observations.setCellValueFactory(new PropertyValueFactory<MedicamentTableCompletation, String>("observations"));
  //
  // GUIUtils.autoFitTable(medicamentTable);
  //
  // ObservableList<MedicamentTableCompletation> fillTableMedicaments = FXCollections.observableArrayList();
  //
  // prescription.getPrescriptionMedicamentsByIdPrescription()
  // .forEach(p -> fillTableMedicaments.add(new MedicamentTableCompletation(selectImage(p.getChecked()), p.getMedicamentByMedicamentId().getName(), p.getPillsNumber(), p.getDescription())));
  //
  // medicamentTable.setItems(fillTableMedicaments);
  //
  // }
  //
  // @SuppressWarnings("unchecked")
  // private void initializePharmaciesTable() {
  // pharmacyName.setStyle("-fx-padding: 0 0 0 10;");
  // pharmacyCity.setStyle("-fx-padding: 0 0 0 10;");
  // pharmacyStreet.setStyle("-fx-padding: 0 0 0 10;");
  // pharmacyStreetNumber.setStyle("-fx-padding: 0 0 0 10;");
  // pharmacyPhone.setStyle("-fx-padding: 0 0 0 10;");
  // medicamentPrce.setStyle("-fx-padding: 0 0 0 10;");
  //
  // pharmacyName.setCellValueFactory(new PropertyValueFactory<PharmacyTableCompletation, String>("pharmacyName"));
  // pharmacyCity.setCellValueFactory(new PropertyValueFactory<PharmacyTableCompletation, String>("city"));
  // pharmacyStreet.setCellValueFactory(new PropertyValueFactory<PharmacyTableCompletation, String>("street"));
  // pharmacyStreetNumber.setCellValueFactory(new PropertyValueFactory<PharmacyTableCompletation, String>("streetNumber"));
  // pharmacyPhone.setCellValueFactory(new PropertyValueFactory<PharmacyTableCompletation, String>("phone"));
  // medicamentPrce.setCellValueFactory(new PropertyValueFactory<PharmacyTableCompletation, Double>("price"));
  // }
  //
  // public CheckBox selectImage(int i) {
  // CheckBox checkBox = new CheckBox();
  // if (i == 1)
  // checkBox.setSelected(true);
  // checkBox.setDisable(true);
  // checkBox.setAlignment(Pos.CENTER_RIGHT);
  // return checkBox;
  // }
  //
  // public static boolean isInteger(String s) {
  // try {
  // Integer.parseInt(s);
  // }
  // catch (NumberFormatException e) {
  // return false;
  // }
  // catch (NullPointerException e) {
  // return false;
  // }
  // return true;
  // }

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
    createPrescriptionPoliclinicBox.setToggleGroup(createPatientInstitution);
    createPrescriptionFamilyDoctorBox.setToggleGroup(createPatientInstitution);
    createPrescriptionHospitalBox.setToggleGroup(createPatientInstitution);
    createPrescriptionOtherInstitutionBox.setToggleGroup(createPatientInstitution);
  }

}
