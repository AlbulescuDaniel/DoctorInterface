package entity;

public class Address  {

  private String countryName;
  private String postalCode;
  private String city;
  private String region;
  private String street;
  private String streetNumber;

  public Address(String countryName, String postalCode, String city, String region, String street, String streetNumber) {
    super();
    this.countryName = countryName;
    this.postalCode = postalCode;
    this.city = city;
    this.region = region;
    this.street = street;
    this.streetNumber = streetNumber;
  }

  public String getCountryName() {
    return countryName;
  }

  public void setCountryName(String countryName) {
    this.countryName = countryName;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String town) {
    this.region = town;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getStreetNumber() {
    return streetNumber;
  }

  public void setStreetNumber(String streetNumber) {
    this.streetNumber = streetNumber;
  }
}
