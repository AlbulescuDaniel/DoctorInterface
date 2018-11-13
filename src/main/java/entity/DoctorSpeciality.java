package entity;

public class DoctorSpeciality {
	private int idDoc;
    private int idSpec;
    private Speciality specialityBySpecialityId;
    
	public DoctorSpeciality(int idDoctor, int idSpeciality, Speciality specialityBySpecialityId) {
		super();
		this.idDoc = idDoctor;
		this.idSpec = idSpeciality;
		this.specialityBySpecialityId = specialityBySpecialityId;
	}
	
	
	public int getIdDoc() {
		return idDoc;
	}


	public void setIdDoc(int idDoc) {
		this.idDoc = idDoc;
	}


	public int getIdSpec() {
		return idSpec;
	}


	public void setIdSpec(int idSpec) {
		this.idSpec = idSpec;
	}


	public void setIdSpeciality(int idSpeciality) {
		this.idSpec = idSpeciality;
	}

	public DoctorSpeciality() {
		super();
	}

	public Speciality getSpecialityBySpecialityId() {
		return specialityBySpecialityId;
	}
	public void setSpecialityBySpecialityId(Speciality specialityBySpecialityId) {
		this.specialityBySpecialityId = specialityBySpecialityId;
	}
	
}
