package entity;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class Prescription {
  private Long id;
  private Long prescriptionNumber;
  private String hospitalType;
  private String patientType;
  private String diagnostic;
  private Date datePrescripted;
  private UserGender userGender;
  private String nationality;
  private List<PrescriptionDrug> prescriptionDrugs;

  public Prescription() {
    super();
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

  public List<PrescriptionDrug> getPrescriptionDrugs() {
    return prescriptionDrugs;
  }

  public void setPrescriptionDrugs(List<PrescriptionDrug> prescriptionDrugs) {
    this.prescriptionDrugs = prescriptionDrugs;
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

  @Override
  public String toString() {
    return "Prescription [id=" + id + ", prescriptionNumber=" + prescriptionNumber + ", hospitalType=" + hospitalType + ", patientType=" + patientType + ", diagnostic=" + diagnostic
        + ", datePrescripted=" + datePrescripted + ", userGender=" + userGender + ", nationality=" + nationality + ", prescriptionDrugs=" + prescriptionDrugs + "]";
  }

  public Prescription(Long id, Long prescriptionNumber, String hospitalType, String patientType, String diagnostic, LocalDate datePrescripted, UserGender userGender, String nationality,
      List<PrescriptionDrug> prescriptionDrugs) {
    super();
    this.id = id;
    this.prescriptionNumber = prescriptionNumber;
    this.hospitalType = hospitalType;
    this.patientType = patientType;
    this.diagnostic = diagnostic;
    this.datePrescripted = Date.from(datePrescripted.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    this.userGender = userGender;
    this.nationality = nationality;
    this.prescriptionDrugs = prescriptionDrugs;
  }
}
