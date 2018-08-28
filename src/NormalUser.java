import java.util.Scanner;
public class NormalUser extends User implements NormalAccount{ // this will clear up when we include the add method
	PhoneBookDirectory book = new PhoneBookDirectory();
	// Create Scanner
	Scanner input = new Scanner(System.in);
	
	// Create object
	PhoneBookEntry info = new PhoneBookEntry();
	
	// add entry method
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
		input.nextLine();
		
		PhoneBookEntry entry = new PhoneBookEntry(id, fname, lname, email, zip, phoneNumber);
		return book.addEntry(entry);
		
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
	
	// Override printUserInfo
	@Override
	public void printUserInfo() {
		book.printEntry();
		
	}
}
