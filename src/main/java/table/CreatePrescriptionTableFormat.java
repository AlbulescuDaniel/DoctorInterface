package table;

public class CreatePrescriptionTableFormat {
  private String number;
  private String name;
  private String days;
  private String pillsPerDay;
  private String observations;

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDays() {
    return days;
  }

  public void setDays(String days) {
    this.days = days;
  }

  public String getPillsPerDay() {
    return pillsPerDay;
  }

  public void setPillsPerDay(String pillsPerDay) {
    this.pillsPerDay = pillsPerDay;
  }

  public String getObservations() {
    return observations;
  }

  public void setObservations(String observations) {
    this.observations = observations;
  }

  public CreatePrescriptionTableFormat(String number, String name, String days, String pillsPerDay, String observations) {
    super();
    this.number = number;
    this.name = name;
    this.days = days;
    this.pillsPerDay = pillsPerDay;
    this.observations = observations;
  }

  public CreatePrescriptionTableFormat() {
    super();
  }
}
