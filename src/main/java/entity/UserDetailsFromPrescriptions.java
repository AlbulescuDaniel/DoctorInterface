package entity;

import java.util.Date;

public class UserDetailsFromPrescriptions {
  String firstName;
  String lastName;
  private Date birthDate;
  private UserGender userGender;

  public UserDetailsFromPrescriptions(String firstName, String lastName, Date birthDate, UserGender userGender) {
    super();
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthDate = birthDate;
    this.userGender = userGender;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public UserGender getUserGender() {
    return userGender;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
    result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
    result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
    result = prime * result + ((userGender == null) ? 0 : userGender.hashCode());
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
    UserDetailsFromPrescriptions other = (UserDetailsFromPrescriptions)obj;
    if (birthDate == null) {
      if (other.birthDate != null)
        return false;
    }
    else if (!birthDate.equals(other.birthDate))
      return false;
    if (firstName == null) {
      if (other.firstName != null)
        return false;
    }
    else if (!firstName.equals(other.firstName))
      return false;
    if (lastName == null) {
      if (other.lastName != null)
        return false;
    }
    else if (!lastName.equals(other.lastName))
      return false;
    if (userGender != other.userGender)
      return false;
    return true;
  }
}
