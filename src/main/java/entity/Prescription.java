package entity;

import java.util.Date;
import java.util.List;

public class Prescription {
    private int idDoctor;
    private int idPatient;
    private String diagnostic;
    private int days;
    private Date datePrescripted;
    private List<PrescriptionMedicament> prescriptionMedicamentsByIdPrescription;
    private Doctor doctorByIdDoctor;
    
	public Prescription() {
		super();
	}
	public Prescription(int idDoctor, int idPatient, String diagnostic, int days, Date datePrescripted,
			List<PrescriptionMedicament> prescriptionMedicaments, Doctor doctorByIdDoctor) {
		super();
		this.idDoctor = idDoctor;
		this.idPatient = idPatient;
		this.diagnostic = diagnostic;
		this.days = days;
		this.datePrescripted = datePrescripted;
		this.prescriptionMedicamentsByIdPrescription = prescriptionMedicaments;
		this.doctorByIdDoctor = doctorByIdDoctor;
	}
	
	public List<PrescriptionMedicament> getPrescriptionMedicamentsByIdPrescription() {
		return prescriptionMedicamentsByIdPrescription;
	}
	public void setPrescriptionMedicamentsByIdPrescription(
			List<PrescriptionMedicament> prescriptionMedicamentsByIdPrescription) {
		this.prescriptionMedicamentsByIdPrescription = prescriptionMedicamentsByIdPrescription;
	}
	public Doctor getDoctorByIdDoctor() {
		return doctorByIdDoctor;
	}
	public void setDoctorByIdDoctor(Doctor doctorByIdDoctor) {
		this.doctorByIdDoctor = doctorByIdDoctor;
	}
	public int getIdDoctor() {
		return idDoctor;
	}
	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
	}
	public int getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}
	public String getDiagnostic() {
		return diagnostic;
	}
	public void setDiagnostic(String diagnostic) {
		this.diagnostic = diagnostic;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public Date getDatePrescripted() {
		return datePrescripted;
	}
	public void setDatePrescripted(Date datePrescripted) {
		this.datePrescripted = datePrescripted;
	}
	@Override
	public String toString() {
		return "Prescription [idDoctor=" + idDoctor + ", idPatient=" + idPatient + ", diagnostic=" + diagnostic
				+ ", days=" + days + ", datePrescripted=" + datePrescripted + ", prescriptionMedicaments="
				+ prescriptionMedicamentsByIdPrescription + ", doctorByIdDoctor=" + doctorByIdDoctor + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datePrescripted == null) ? 0 : datePrescripted.hashCode());
		result = prime * result + days;
		result = prime * result + ((diagnostic == null) ? 0 : diagnostic.hashCode());
		result = prime * result + ((doctorByIdDoctor == null) ? 0 : doctorByIdDoctor.hashCode());
		result = prime * result + idDoctor;
		result = prime * result + idPatient;
		result = prime * result + ((prescriptionMedicamentsByIdPrescription == null) ? 0 : prescriptionMedicamentsByIdPrescription.hashCode());
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
		Prescription other = (Prescription) obj;
		if (datePrescripted == null) {
			if (other.datePrescripted != null)
				return false;
		} else if (!datePrescripted.equals(other.datePrescripted))
			return false;
		if (days != other.days)
			return false;
		if (diagnostic == null) {
			if (other.diagnostic != null)
				return false;
		} else if (!diagnostic.equals(other.diagnostic))
			return false;
		if (doctorByIdDoctor == null) {
			if (other.doctorByIdDoctor != null)
				return false;
		} else if (!doctorByIdDoctor.equals(other.doctorByIdDoctor))
			return false;
		if (idDoctor != other.idDoctor)
			return false;
		if (idPatient != other.idPatient)
			return false;
		if (prescriptionMedicamentsByIdPrescription == null) {
			if (other.prescriptionMedicamentsByIdPrescription != null)
				return false;
		} else if (!prescriptionMedicamentsByIdPrescription.equals(other.prescriptionMedicamentsByIdPrescription))
			return false;
		return true;
	}
}
