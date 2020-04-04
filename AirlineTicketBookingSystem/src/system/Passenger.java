package system;

public class Passenger {
	private String firstName;
	private String lastName;
	private int gender=0; //1 male 2 female
	private String passportNumber;
	private String expirationDate;
	private String email;
	private String birthday;
	
	public Passenger(String firstName, String lastName, int gender, String passportNumber, String expirationDate,
			String email, String birthday) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.passportNumber = passportNumber;
		this.expirationDate = expirationDate;
		this.email = email;
		this.birthday = birthday;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getGender() {
		return gender;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public String getEmail() {
		return email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

}
