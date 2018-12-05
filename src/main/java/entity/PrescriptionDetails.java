package entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class PrescriptionDetails {
  private String doctorName;
  private String doctorSpeciality;
  private String doctorEmail;
  private String hospitalName;
  private String hospitalCity;
  private String hospitalEmail;
  private String diagnostic;
  private Date prescriptionDate;
  private List<PrescriptionDrug> prescriptionDrugDTO;

  public PrescriptionDetails() {
    super();
  }

  public PrescriptionDetails(String doctorName, String doctorSpeciality, String doctorEmail, String hospitalName, String hospitalCity, String hospitalEmail, String diagnostic,
      Date prescriptionDate, List<PrescriptionDrug> prescriptionDrugDTO) {
    super();
    this.doctorName = doctorName;
    this.doctorSpeciality = doctorSpeciality;
    this.doctorEmail = doctorEmail;
    this.hospitalName = hospitalName;
    this.hospitalCity = hospitalCity;
    this.hospitalEmail = hospitalEmail;
    this.diagnostic = diagnostic;
    this.prescriptionDate = prescriptionDate;
    this.prescriptionDrugDTO = prescriptionDrugDTO;
  }

  public String getDoctorName() {
    return doctorName;
  }

  public void setDoctorName(String doctorName) {
    this.doctorName = doctorName;
  }

  public String getDoctorSpeciality() {
    return doctorSpeciality;
  }

  public void setDoctorSpeciality(String doctorSpeciality) {
    this.doctorSpeciality = doctorSpeciality;
  }

  public String getDoctorEmail() {
    return doctorEmail;
  }

  public void setDoctorEmail(String doctorEmail) {
    this.doctorEmail = doctorEmail;
  }

  public String getHospitalName() {
    return hospitalName;
  }

  public void setHospitalName(String hospitalName) {
    this.hospitalName = hospitalName;
  }

  public String getHospitalCity() {
    return hospitalCity;
  }

  public void setHospitalCity(String hospitalCity) {
    this.hospitalCity = hospitalCity;
  }

  public String getHospitalEmail() {
    return hospitalEmail;
  }

  public void setHospitalEmail(String hospitalEmail) {
    this.hospitalEmail = hospitalEmail;
  }

  public String getDiagnostic() {
    return diagnostic;
  }

  public void setDiagnostic(String diagnostic) {
    this.diagnostic = diagnostic;
  }

  public Date getPrescriptionDate() {
    return prescriptionDate;
  }

  public void setPrescriptionDate(Date prescriptionDate) {
    this.prescriptionDate = prescriptionDate;
  }

  public List<PrescriptionDrug> getPrescriptionDrugDTO() {
    return prescriptionDrugDTO;
  }

  public void setPrescriptionDrugDTO(List<PrescriptionDrug> prescriptionDrugDTO) {
    this.prescriptionDrugDTO = prescriptionDrugDTO;
  }

  @Override
  public String toString() {
    return "PrescriptionDetails [doctorName=" + doctorName + ", doctorSpeciality=" + doctorSpeciality + ", doctorEmail=" + doctorEmail + ", hospitalName=" + hospitalName + ", hospitalCity="
        + hospitalCity + ", hospitalEmail=" + hospitalEmail + ", diagnostic=" + diagnostic + ", prescriptionDate=" + prescriptionDate + ", prescriptionDrugDTO=" + prescriptionDrugDTO + "]";
  }
}