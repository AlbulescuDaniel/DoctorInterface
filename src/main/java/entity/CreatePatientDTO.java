package entity;

import java.time.LocalDate;

public class CreatePatientDTO {

  private String email;
  private String phoneNumber;
  private String firstName;
  private String lastName;
  private String cnp;
  private String nationality;
  private LocalDate birthDate;
  private UserGender gender;
  private Address address;

  public CreatePatientDTO(String email, String phoneNumber, String firstName, String lastName, String cnp, LocalDate birthDate, UserGender gender, Address address, String nationality) {
    super();
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.firstName = firstName;
    this.lastName = lastName;
    this.cnp = cnp;
    this.birthDate = birthDate;
    this.gender = gender;
    this.address = address;
    this.nationality = nationality;
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

  public String getCnp() {
    return cnp;
  }

  public void setCnp(String cnp) {
    this.cnp = cnp;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public UserGender getGender() {
    return gender;
  }

  public void setGender(UserGender gender) {
    this.gender = gender;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }
}
