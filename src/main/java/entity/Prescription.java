package entity;

import java.util.Date;
import java.util.List;

public class Prescription{
  private Long id;

  private String diagnostic;

  private Integer days;

  private Date datePrescripted;

  private List<PrescriptionDrug> prescriptionDrugs;

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

  public Integer getDays() {
    return days;
  }

  public void setDays(Integer days) {
    this.days = days;
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

  @Override
  public String toString() {
    return "Prescription [id=" + id + ", diagnostic=" + diagnostic + ", days=" + days + ", datePrescripted=" + datePrescripted + ", prescriptionDrugs=" + prescriptionDrugs + "]";
  }
}
