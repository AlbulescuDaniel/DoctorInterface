package constant;

public class Consts {

  private Consts() {
    throw new AssertionError();
  }

  public static final Boolean LOCAL_SERVER = true;

  public static final String LOGIN_URL = "http://localhost:8080/login";
  public static final String OPENSHIFT_LOGIN_URL = "http://licenta-licenta.193b.starter-ca-central-1.openshiftapps.com/login";

  public static final String FILL_PRESCRIPTION_TABLE_URL = "http://localhost:8080/prescriptions/patient";
  public static final String OPENSHIFT_FILL_PRESCRIPTION_TABLE_URL = "http://licenta-licenta.193b.starter-ca-central-1.openshiftapps.com/prescriptions/patient";

  public static final String AUTOFILL_PRESCRIPTION_URL = "http://localhost:8080/doctors/prescriptionInfo";
  public static final String OPENSHIFT_AUTOFILL_PRESCRIPTION_URL = "http://licenta-licenta.193b.starter-ca-central-1.openshiftapps.com/doctors/prescriptionInfo";

  public static final String CREATE_PRESCRIPTION_URL = "http://localhost:8080/prescriptions";
  public static final String OPENSHIFT_CREATE_PRESCRIPTION_URL = "http://licenta-licenta.193b.starter-ca-central-1.openshiftapps.com/prescriptions";
  
  public static final String PRESCRIPTION_DETAILS_URL = "http://localhost:8080/prescriptions/details";
  public static final String OPENSHIFT_PRESCRIPTION_DETAILS_URL_URL = "http://licenta-licenta.193b.starter-ca-central-1.openshiftapps.com/prescriptions/details";
  
  public static final String PREGISTER_PATIENT_URL = "http://localhost:8080/patients";
  public static final String OPENSHIFT_PREGISTER_PATIENT_URL = "http://licenta-licenta.193b.starter-ca-central-1.openshiftapps.com/patients";

}