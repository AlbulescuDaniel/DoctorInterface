package entity;

public class PrescriptionsTableFormat {
	private String doctorName;
	private String doctorSpeciality;
	private String prescriptionDate; 
	private String diagnostic;
	public PrescriptionsTableFormat(String doctorName, String doctorSpeciality, String string, String diagnostic) {
		super();
		this.doctorName = doctorName;
		this.doctorSpeciality = doctorSpeciality;
		this.prescriptionDate = string;
		this.diagnostic = diagnostic;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDoctorSpeciality() {
		return doctorSpeciality;
	}
	public void setDoctorSpeciality(String doctorSpeciality) {
		this.doctorSpeciality = doctorSpeciality;
	}
	public String getPrescriptionDate() {
		return prescriptionDate;
	}
	public void setPrescriptionDate(String prescriptionDate) {
		this.prescriptionDate = prescriptionDate;
	}
	public String getDiagnostic() {
		return diagnostic;
	}
	public void setDiagnostic(String diagnostic) {
		this.diagnostic = diagnostic;
	}
}