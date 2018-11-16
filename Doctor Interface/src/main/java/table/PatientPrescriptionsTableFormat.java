package table;

public class PatientPrescriptionsTableFormat {
  
  private Long id;
  private String diagnostic;
  private Integer days;
  private String datePrescripted;

  public PatientPrescriptionsTableFormat(Long id, String diagnostic, Integer days, String datePrescripted) {
    super();
    this.id = id;
    this.diagnostic = diagnostic;
    this.days = days;
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

  public Integer getDays() {
    return days;
  }

  public void setDays(Integer days) {
    this.days = days;
  }

  public String getDatePrescripted() {
    return datePrescripted;
  }

  public void setDatePrescripted(String datePrescripted) {
    this.datePrescripted = datePrescripted;
  }
}
