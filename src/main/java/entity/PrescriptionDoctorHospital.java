package entity;

public class PrescriptionDoctorHospital {

  private Long prescriptionNumber;
  private String hospitalName;
  private String hospitalURC;
  private String hospitalState;
  private String hospitalPhone;
  private String doctorEmail;

  public Long getPrescriptionNumber() {
    return prescriptionNumber;
  }

  public void setPrescriptionNumber(Long prescriptionNumber) {
    this.prescriptionNumber = prescriptionNumber;
  }

  public String getHospitalName() {
    return hospitalName;
  }

  public void setHospitalName(String hospitalName) {
    this.hospitalName = hospitalName;
  }

  public String getHospitalURC() {
    return hospitalURC;
  }

  public void setHospitalURC(String hospitalURC) {
    this.hospitalURC = hospitalURC;
  }

  public String getHospitalState() {
    return hospitalState;
  }

  public void setHospitalState(String hospitalState) {
    this.hospitalState = hospitalState;
  }

  public String getHospitalPhone() {
    return hospitalPhone;
  }

  public void setHospitalPhone(String hospitalPhone) {
    this.hospitalPhone = hospitalPhone;
  }

  public String getDoctorEmail() {
    return doctorEmail;
  }

  public void setDoctorEmail(String doctorEmail) {
    this.doctorEmail = doctorEmail;
  }

  @Override
  public String toString() {
    return "PrescriptionDoctorHospital [prescriptionNumber=" + prescriptionNumber + ", hospitalName=" + hospitalName + ", hospitalURC=" + hospitalURC + ", hospitalState=" + hospitalState
        + ", hospitalPhone=" + hospitalPhone + ", doctorEmail=" + doctorEmail + "]";
  }
}
