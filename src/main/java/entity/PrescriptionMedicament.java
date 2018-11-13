package entity;

public class PrescriptionMedicament {
    public PrescriptionMedicament() {
		super();
	}
	private int prescriptionId;
    private int medicamentId;
    private int checked;
    private String description;
    private int pillsNumber;
    public PrescriptionMedicament(int prescriptionId, int medicamentId, int checked, String description,
			int pillsNumber, Medicament medicamentByMedicamentId) {
		super();
		this.prescriptionId = prescriptionId;
		this.medicamentId = medicamentId;
		this.checked = checked;
		this.description = description;
		this.pillsNumber = pillsNumber;
		this.medicamentByMedicamentId = medicamentByMedicamentId;
	}
    
	public int getPillsNumber() {
		return pillsNumber;
	}

	public void setPillsNumber(int pillsNumber) {
		this.pillsNumber = pillsNumber;
	}

	public int getPrescriptionId() {
		return prescriptionId;
	}
	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}
	public int getMedicamentId() {
		return medicamentId;
	}
	public void setMedicamentId(int medicamentId) {
		this.medicamentId = medicamentId;
	}
	public int getChecked() {
		return checked;
	}
	public void setChecked(int checked) {
		this.checked = checked;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getNumarPastile() {
		return pillsNumber;
	}
	public void setNumarPastile(int numarPastile) {
		this.pillsNumber = numarPastile;
	}
	public Medicament getMedicamentByMedicamentId() {
		return medicamentByMedicamentId;
	}
	public void setMedicamentByMedicamentId(Medicament medicamentByMedicamentId) {
		this.medicamentByMedicamentId = medicamentByMedicamentId;
	}
	private Medicament medicamentByMedicamentId;
}
