package entity;

import java.util.List;

public class Pharmacy {
    private String pharmacyName;
    private String leadPharmacist;
    private String street;
    private String city;
    private String state;
    private String streetNumber;
    private String zipCode;
    private String phone;
    private String email;
    private List<PharmacyStock> pharmacyStocksByIdPharmacy;
    
	public List<PharmacyStock> getPharmacyStocksByIdPharmacy() {
		return pharmacyStocksByIdPharmacy;
	}
	public void setPharmacyStocksByIdPharmacy(List<PharmacyStock> pharmacyStocksByIdPharmacy) {
		this.pharmacyStocksByIdPharmacy = pharmacyStocksByIdPharmacy;
	}
	public String getPharmacyName() {
		return pharmacyName;
	}
	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}
	public String getLeadPharmacist() {
		return leadPharmacist;
	}
	public void setLeadPharmacist(String leadPharmacist) {
		this.leadPharmacist = leadPharmacist;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Pharmacy() {
		super();
	}
	
	public String getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	public Pharmacy(String pharmacyName, String leadPharmacist, String street, String city, String state,
			String streetNumber, String zipCode, String phone, String email,
			List<PharmacyStock> pharmacyStocksByIdPharmacy) {
		super();
		this.pharmacyName = pharmacyName;
		this.leadPharmacist = leadPharmacist;
		this.street = street;
		this.city = city;
		this.state = state;
		this.streetNumber = streetNumber;
		this.zipCode = zipCode;
		this.phone = phone;
		this.email = email;
		this.pharmacyStocksByIdPharmacy = pharmacyStocksByIdPharmacy;
	}
	@Override
	public String toString() {
		return "Pharmacy [pharmacyName=" + pharmacyName + ", leadPharmacist=" + leadPharmacist + ", street=" + street
				+ ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + ", phone=" + phone + ", email="
				+ email + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((leadPharmacist == null) ? 0 : leadPharmacist.hashCode());
		result = prime * result + ((pharmacyName == null) ? 0 : pharmacyName.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
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
		Pharmacy other = (Pharmacy) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (leadPharmacist == null) {
			if (other.leadPharmacist != null)
				return false;
		} else if (!leadPharmacist.equals(other.leadPharmacist))
			return false;
		if (pharmacyName == null) {
			if (other.pharmacyName != null)
				return false;
		} else if (!pharmacyName.equals(other.pharmacyName))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}
    
}
