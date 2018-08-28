import java.util.Scanner;
public class PhoneBook {
	
	public static void main(String[] args) {
		// Create Scanner
		Scanner input = new Scanner(System.in);
		
		// Instantiate 3 objects of PhoneBookEntry
		PhoneBookEntry first = new PhoneBookEntry();
		PhoneBookEntry second = new PhoneBookEntry();
		PhoneBookEntry third = new PhoneBookEntry();
		
		// Get information for first person
		
		// ID
		System.out.println("What is the ID of the first person? ");
		int Id = input.nextInt();
		input.nextLine();
		first.setId(Id);
		
		// First Name
		System.out.println("What is the first name of the first person? ");
		String fname = input.nextLine();
		first.setFname(fname);
		
		// Last Name
		System.out.println("What is the last name of the first person? ");
		String lname = input.nextLine();
		first.setFname(lname);
		
		// Email
		System.out.println("What is the email of the first person? ");
		String email = input.nextLine();
		first.setFname(email);
		// Zip Code
		System.out.println("What is the zip code of the first person? ");
		int zip = input.nextInt();
		input.nextLine();
		first.setZip(zip);
		// Phone Number
		System.out.println("What is the phone number of the first person? ");
		int phoneNumber = input.nextInt();
		input.nextLine();
		first.setPhoneNumber(phoneNumber);
		
		// Get information for second person
		// First Name
		System.out.println("What is the second person's first name? ");
		String fname2 = input.nextLine();
		second.setFname(fname2);
		// Phone Number
		System.out.println("What is the second person's phone number? ");
		int phoneNumber2 = input.nextInt();
		input.nextLine();
		second.setPhoneNumber(phoneNumber2);
		
		// Get information for third person
		// First Name
		System.out.println("What is the third person's first name? ");
		String fname3 = input.nextLine();
		third.setFname(fname3);
		
		
		// Using getters and setters to change attributes of objects
		// Change phone number of John Smith to 202555555
		first.setPhoneNumber(202555555);
		
		// Print attributes of John Smith using PrintBookEntry()
		first.printBookEntry();
		
		// Assign zip code of John Smith to James'
		third.setZip(first.getZip());

		// Create Entries
		PhoneBookEntry Justin = new PhoneBookEntry("Justin", 424241679);
		PhoneBookEntry John = new PhoneBookEntry(1, "John", "Smith", "jsmith@nyu.edu", 90275, 310650771);
		
		// Change Last name of Justin
		Justin.setLname("Lee");
		
		// Change First name of John
		John.setFname("Jake");
		
		// Display results
		System.out.println("Justin's last name is " + Justin.getLname());
		System.out.println("Jake's first name is " + John.getFname());
	}
	
}
