package entity;

public class DoctorProfile{
  
  private String firstName;

  private String lastName;

  private String userName;

  private String email;

  private String phoneNumber;

  private Address addressDTO;
  
  private String speciality;
  
  private String hospitalName;
  
  private String hospitalEmail;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Address getAddressDTO() {
    return addressDTO;
  }

  public void setAddressDTO(Address addressDTO) {
    this.addressDTO = addressDTO;
  }

  public String getSpeciality() {
    return speciality;
  }

  public void setSpeciality(String speciality) {
    this.speciality = speciality;
  }

  public String getHospitalName() {
    return hospitalName;
  }

  public void setHospitalName(String hospitalName) {
    this.hospitalName = hospitalName;
  }

  public String getHospitalEmail() {
    return hospitalEmail;
  }

  public void setHospitalEmail(String hospitalEmail) {
    this.hospitalEmail = hospitalEmail;
  }

  @Override
  public String toString() {
    return "DoctorProfile [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", addressDTO=" + addressDTO
        + ", speciality=" + speciality + ", hospitalName=" + hospitalName + ", hospitalEmail=" + hospitalEmail + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((addressDTO == null) ? 0 : addressDTO.hashCode());
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
    result = prime * result + ((hospitalEmail == null) ? 0 : hospitalEmail.hashCode());
    result = prime * result + ((hospitalName == null) ? 0 : hospitalName.hashCode());
    result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
    result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
    result = prime * result + ((speciality == null) ? 0 : speciality.hashCode());
    result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
    DoctorProfile other = (DoctorProfile)obj;
    if (addressDTO == null) {
      if (other.addressDTO != null)
        return false;
    }
    else if (!addressDTO.equals(other.addressDTO))
      return false;
    if (email == null) {
      if (other.email != null)
        return false;
    }
    else if (!email.equals(other.email))
      return false;
    if (firstName == null) {
      if (other.firstName != null)
        return false;
    }
    else if (!firstName.equals(other.firstName))
      return false;
    if (hospitalEmail == null) {
      if (other.hospitalEmail != null)
        return false;
    }
    else if (!hospitalEmail.equals(other.hospitalEmail))
      return false;
    if (hospitalName == null) {
      if (other.hospitalName != null)
        return false;
    }
    else if (!hospitalName.equals(other.hospitalName))
      return false;
    if (lastName == null) {
      if (other.lastName != null)
        return false;
    }
    else if (!lastName.equals(other.lastName))
      return false;
    if (phoneNumber == null) {
      if (other.phoneNumber != null)
        return false;
    }
    else if (!phoneNumber.equals(other.phoneNumber))
      return false;
    if (speciality == null) {
      if (other.speciality != null)
        return false;
    }
    else if (!speciality.equals(other.speciality))
      return false;
    if (userName == null) {
      if (other.userName != null)
        return false;
    }
    else if (!userName.equals(other.userName))
      return false;
    return true;
  }
}
