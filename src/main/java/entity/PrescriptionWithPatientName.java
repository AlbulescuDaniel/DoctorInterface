package entity;

import java.util.Date;
import java.util.List;

public class PrescriptionWithPatientName {
  
  private Long id;
  private Long prescriptionNumber;
  private String hospitalType;
  private String patientType;
  private String diagnostic;
  private Date datePrescripted;
  private Date birthDate;
  private UserGender userGender;
  private String nationality;
  private String patientFirstName;
  private String patientLastName;
  private List<PrescriptionDrug> prescriptionDrugs;

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public UserGender getUserGender() {
    return userGender;
  }

  public void setUserGender(UserGender userGender) {
    this.userGender = userGender;
  }

  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long idPrescription) {
    this.id = idPrescription;
  }

  public String getDiagnostic() {
    return diagnostic;
  }

  public void setDiagnostic(String diagnostic) {
    this.diagnostic = diagnostic;
  }

  public Date getDatePrescripted() {
    return datePrescripted;
  }

  public void setDatePrescripted(Date datePrescripted) {
    this.datePrescripted = datePrescripted;
  }

  public Long getPrescriptionNumber() {
    return prescriptionNumber;
  }

  public void setPrescriptionNumber(Long prescriptionNumber) {
    this.prescriptionNumber = prescriptionNumber;
  }

  public String getHospitalType() {
    return hospitalType;
  }

  public void setHospitalType(String hospitalType) {
    this.hospitalType = hospitalType;
  }

  public String getPatientType() {
    return patientType;
  }

  public void setPatientType(String patientType) {
    this.patientType = patientType;
  }

  public String getPatientFirstName() {
    return patientFirstName;
  }

  public void setPatientFirstName(String patientFirstName) {
    this.patientFirstName = patientFirstName;
  }

  public String getPatientLastName() {
    return patientLastName;
  }

  public void setPatientLastName(String patientLastName) {
    this.patientLastName = patientLastName;
  }

  public List<PrescriptionDrug> getPrescriptionDrugs() {
    return prescriptionDrugs;
  }

  public void setPrescriptionDrugs(List<PrescriptionDrug> prescriptionDrugs) {
    this.prescriptionDrugs = prescriptionDrugs;
  }

  @Override
  public String toString() {
    return "PrescriptionWithPatientName [id=" + id + ", prescriptionNumber=" + prescriptionNumber + ", hospitalType=" + hospitalType + ", patientType=" + patientType + ", diagnostic=" + diagnostic
        + ", datePrescripted=" + datePrescripted + ", birthDate=" + birthDate + ", userGender=" + userGender + ", nationality=" + nationality + ", patientFirstName=" + patientFirstName
        + ", patientLastName=" + patientLastName + ", prescriptionDrugs=" + prescriptionDrugs + "]";
  }

}
