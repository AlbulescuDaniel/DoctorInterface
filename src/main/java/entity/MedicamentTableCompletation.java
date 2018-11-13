package entity;

import javafx.scene.control.CheckBox;

public class MedicamentTableCompletation {
	private CheckBox checkedImage;
	private String medicamentName; 
	private int pills;
	private String observations;
	
	
	public CheckBox getCheckedImage() {
		return checkedImage;
	}
	public void setCheckedImage(CheckBox checkedImage) {
		this.checkedImage = checkedImage;
	}
	public String getMedicamentName() {
		return medicamentName;
	}
	public void setMedicamentName(String medicamentName) {
		this.medicamentName = medicamentName;
	}
	public int getPills() {
		return pills;
	}
	public void setPills(int pills) {
		this.pills = pills;
	}
	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((medicamentName == null) ? 0 : medicamentName.hashCode());
		result = prime * result + ((observations == null) ? 0 : observations.hashCode());
		result = prime * result + pills;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MedicamentTableCompletation other = (MedicamentTableCompletation) obj;
		if (medicamentName == null) {
			if (other.medicamentName != null)
				return false;
		} else if (!medicamentName.equals(other.medicamentName))
			return false;
		if (observations == null) {
			if (other.observations != null)
				return false;
		} else if (!observations.equals(other.observations))
			return false;
		if (pills != other.pills)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MedicamentTableCompletation [medicamentName=" + medicamentName
				+ ", pills=" + pills + ", observations=" + observations + "]";
	}
	public MedicamentTableCompletation(CheckBox checkedImage, String medicamentName, int pills, String observations) {
		super();
		this.checkedImage = checkedImage;
		this.medicamentName = medicamentName;
		this.pills = pills;
		this.observations = observations;
	}
	
}
