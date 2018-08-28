
public class PhoneBookEntry {
	
	// set variables to default values
	private int Id=-1;
	private String fname="Default";
	private String lname="Name";
	private String email="default email";
	private int zip=0;
	private int phoneNumber=0;
	
	// default constructor
	public PhoneBookEntry() {
	}
	
	// constructor for all variables
	public PhoneBookEntry(int Id, String fname, String lname, String email, int zip, int phoneNumber) {
		this.Id = Id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
	}
	
	// constructor for first name and phone number
	public PhoneBookEntry(String fname, int phoneNumber) {
		this.fname = fname;
		this.phoneNumber = phoneNumber;
	}
	
	// getters and setters
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void printBookEntry() {
		System.out.println("The ID is " + Id);
		System.out.println("The first name is " + fname);
		System.out.println("The last name is " + lname);
		System.out.println("The email is " + email);
		System.out.println("The zip code is " + zip);
		System.out.println("The phone number is " + phoneNumber);
	}
	
	public int compareTo(PhoneBookEntry e) {
		if (this.Id < e.getId()) {
			return -1;
		}
		else if (this.Id == e.getId()) {
			return 0;
		}
		else if (this.Id > e.getId()) {
			return 1;
		}
		return 2;
	}
	
}
