package entity;

public class PrescriptionDrug {
  
  private Long id;
  private Boolean checked;
  private String description;
  private Integer pillsNumber;
  private String drug;

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
}
