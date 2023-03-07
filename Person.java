
public class Person {

    private String firstName;
	private String lastName;
	private String emailAddress;
	private String SSN;
	private int id;
	
	//Constructors
	public Person(int id, String firstName, String lastName, String SSN) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.SSN=SSN;
		this.id=id;
	}

	//Methods

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setSSN(String SSN) {
		this.SSN = SSN;
	}

	public void setID(int id) {
		this.id = id;
	}

	public  String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public String getSSN() {
		return SSN;
	}

	@Override
	public String toString() {
		return id +":"+firstName+":"+lastName+":"+SSN;
	}

}