package entity;

public class MedicamentInCreatePrescriptionTableCompletation {
	private String medicamentName;
	private String prescriptedDays;
	private String pillsPerDay;
	private String observations;
	public String getMedicamentName() {
		return medicamentName;
	}
	public void setMedicamentName(String medicamentName) {
		this.medicamentName = medicamentName;
	}
	public String getPrescriptedDays() {
		return prescriptedDays;
	}
	public void setPrescriptedDays(String prescriptedDays) {
		this.prescriptedDays = prescriptedDays;
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
	public MedicamentInCreatePrescriptionTableCompletation() {
		super();
	}
	@Override
	public String toString() {
		return "MedicamentInCreatePrescriptionTableCompletation [medicamentName=" + medicamentName
				+ ", prescriptedDays=" + prescriptedDays + ", pillsPerDay=" + pillsPerDay + ", observations="
				+ observations + "]";
	}
}
