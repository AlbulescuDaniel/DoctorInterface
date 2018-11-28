package table;

public class PatientPrescriptionsTableFormat {
  
  private Long id;
  private String diagnostic;
  private String medication;
  private String datePrescripted;

  public PatientPrescriptionsTableFormat(Long id, String diagnostic, String medication, String datePrescripted) {
    super();
    this.id = id;
    this.diagnostic = diagnostic;
    this.medication = medication;
    this.datePrescripted = datePrescripted;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDiagnostic() {
    return diagnostic;
  }

  public void setDiagnostic(String diagnostic) {
    this.diagnostic = diagnostic;
  }

  public String getDays() {
    return medication;
  }

  public void setDays(String medication) {
    this.medication = medication;
  }

  public String getDatePrescripted() {
    return datePrescripted;
  }

  public void setDatePrescripted(String datePrescripted) {
    this.datePrescripted = datePrescripted;
  }
}
