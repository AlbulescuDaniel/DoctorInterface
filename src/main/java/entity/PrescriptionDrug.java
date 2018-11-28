package entity;

public class PrescriptionDrug {
  
  private Long id;
  private Boolean checked;
  private String description;
  private Integer pillsNumber;
  private String drug;
  private Integer days;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Boolean getChecked() {
    return checked;
  }

  public void setChecked(Boolean checked) {
    this.checked = checked;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getPillsNumber() {
    return pillsNumber;
  }

  public void setPillsNumber(Integer pillsNumber) {
    this.pillsNumber = pillsNumber;
  }

  public String getDrug() {
    return drug;
  }

  public void setDrug(String drug) {
    this.drug = drug;
  }

  public Integer getDays() {
    return days;
  }

  public void setDays(Integer days) {
    this.days = days;
  }

  public PrescriptionDrug() {
    super();
  }

  public PrescriptionDrug(Long id, Boolean checked, String description, Integer pillsNumber, String drug, Integer days) {
    super();
    this.id = id;
    this.checked = checked;
    this.description = description;
    this.pillsNumber = pillsNumber;
    this.drug = drug;
    this.days = days;
  }

  @Override
  public String toString() {
    return "PrescriptionDrug [id=" + id + ", checked=" + checked + ", description=" + description + ", pillsNumber=" + pillsNumber + ", drug=" + drug + ", days=" + days + "]";
  }
}
