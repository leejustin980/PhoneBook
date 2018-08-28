import java.util.Scanner;
public class PhoneBookAdmin extends User implements AdminAccount  { 
	
	// Create Scanner
	Scanner input = new Scanner(System.in);
	
	// Constructor to call User
	public PhoneBookAdmin() {
	}
	
	// Create Objects
	PhoneBookDirectory book = new PhoneBookDirectory();
	
	// Add an entry 
	public int addEntry() {
		System.out.println("What is the id of the person you want to add? ");
		int id = input.nextInt();
		input.nextLine();
		System.out.println("What is the first name of the person you want to add? ");
		String fname = input.nextLine();
		System.out.println("What is the last name of the person you want to add? ");
		String lname = input.nextLine();
		System.out.println("What is the email of the person you want to add? ");
		String email = input.nextLine();
		System.out.println("What is the zip code of the person you want to add? ");
		int zip = input.nextInt();
		System.out.println("What is the phone number of the person you want to add? ");
		int phoneNumber = input.nextInt();
			
		PhoneBookEntry entry = new PhoneBookEntry(id, fname, lname, email, zip, phoneNumber);
		
		//book.addEntry(entry);
		int result = book.addEntry(entry);
		return result;
	}
	
	// Edit an entry 
	public int editEntry() {
		System.out.println("Enter the first name of the person you want to edit: ");
		String editFname = input.next();
		input.nextLine();
		System.out.println("Enter the last name of the person you want to edit: ");
		String editLname = input.next();
		input.nextLine();
		
		int result = book.Edit(editFname, editLname);
		return result;
	}
	
	// Delete an entry
	public int deleteEntry() {
		System.out.println("Enter the id of the person you want to delete: ");
		int deleteId = input.nextInt();
		input.nextLine();
		return book.DeleteEntry(deleteId);
	}
	
	//Delete an entry by fname and lname
	public int delEntry() {
		System.out.println("Enter the first name of the person you want to delete: ");
		String fname = input.next();
		input.nextLine();
		System.out.println("Enter the last name of the person you want to delete: ");
		String lname = input.nextLine();
		
		return book.delEntry(fname, lname);
	}
	
	// Sort the PhoneBookDirectory
	public void sortDirectory() {
		System.out.println("Sorting Phone Book Directory");
		book.SortbyId();
	}
	
	// Search using Linear Search
	public int linearSearch() {
		System.out.println("What phone number are you looking for? ");
		int phoneNumber = input.nextInt();
		return book.LinearSearchByPhoneNumber(phoneNumber);
	}
	
	// Search using Binary Search
	public PhoneBookEntry binarySearch() {
		System.out.println("What ID are you searching for? ");
		int binaryId = input.nextInt();
		return book.SearchbyIdBinarySearch(binaryId);
	}
	
	// Override printUserInfo
	@Override
	public void printUserInfo() {
		book.printEntry();
	}
	
	// Change Password
	public void changePass(String newPass) {
		this.setPassword(newPass);
	}
	
	// Change Username
	public void changeUser(String newName) {
		this.setUsername(newName);
	}

	
	
	
	
}
