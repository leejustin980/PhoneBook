
public class User {
	// change to protected so that child classes can access?
	private String username;
	private String password;
	
	// create object
	
	// default constructor
	public User() {
		
	}
	
	// constructor
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	// getters and setters
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	// print info method
	public void printUserInfo() {
		System.out.println("Username: " + this.username);
		System.out.println("Password: " + this.password);
	}
	
	
}
