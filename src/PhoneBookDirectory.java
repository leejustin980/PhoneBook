
import java.util.Scanner;
public class PhoneBookDirectory {
	
	// Create Scanner
	Scanner input = new Scanner(System.in);
	
	// PhoneBookEntry array
	public PhoneBookEntry[] entryBook;
	
	// Admin object
	public PhoneBookAdmin admin;
	
	// User object
	public User person;
	
	// count 
	private int count = 0;

	public PhoneBookDirectory() {
		entryBook = new PhoneBookEntry[6];
		// creating all 6 entrybooks in the beginning
		for (int i=0; i<6; i++) {
			entryBook[i] = new PhoneBookEntry();
		}
		count = 0;
	}
	
	// Add entry
	public int addEntry(PhoneBookEntry entry) {
		if (count == 6) {
			return 0;
		}
		entryBook[count] = entry;
		count++;
		return 1;
	}
	

	// Print phonebook 
	public void printEntry() {
		for (int i=0; i<count; i++) {
			//entryBook[i].printBookEntry();
			System.out.println((i+1) + ". " + entryBook[i].getFname() + " " + entryBook[i].getLname());
			System.out.println("ID: " + entryBook[i].getId());
			System.out.println("Phone Number: " + entryBook[i].getPhoneNumber());
			System.out.println("Email: " + entryBook[i].getEmail());
			System.out.println("Zip Code: " + entryBook[i].getZip());
			System.out.println();
		}
	}
	
	// Linear Search by phone number
	public int LinearSearchByPhoneNumber(int PhoneNumber) {
		for (int z=0;z<entryBook.length;z++) {
			if (PhoneNumber == entryBook[z].getPhoneNumber()) {
				System.out.println("The Phone number belongs to " + entryBook[z].getFname() + " " + entryBook[z].getLname());
				return 1;
			}
		}
		return 0;
	}
	
	// Search by Id Binary Search -
	public PhoneBookEntry SearchbyIdBinarySearch(int id) {
		// sort
		SortbyId();
		// binary search method
		int answer = id;
		int low = 0;
		int high = count-1; // what do we use here; entryBook.length - 1, count, count-1
		while (high >= low) {
			int mid = (low + high)/2;
			if (answer < entryBook[mid].getId()) {
				high = mid -1;
			} else if (answer == entryBook[mid].getId()) {
				return entryBook[mid];
			}else {
				low = mid + 1;
			}
		}
		return new PhoneBookEntry();
	}
	
	// Selection Sort by ID
	public void SortbyId(){
		for (int i=0;i<count-1;i++) {
			int minIndex = i;
			for (int z=i+1;z<count;z++) {
				if (entryBook[z].compareTo(entryBook[i]) == -1) {
					minIndex = z;
				}
			}
			PhoneBookEntry temp = entryBook[minIndex];
			entryBook[minIndex] = entryBook[i];
			entryBook[i] = temp;
		}
	}

	// Edit an Entry - need to adjust #s because if we change the print method then we will need to adjust this to +1 to i as well
	public int Edit(String firstName, String lastName) {
		for (int i=0; i<count; i++) {
			if (entryBook[i].getFname().equals(firstName) && entryBook[i].getLname().equals(lastName)) {
				System.out.println("What do you want to change? ");
				System.out.println("1. ID");
				System.out.println("2. first name");
				System.out.println("3. last name");
				System.out.println("4. email");
				System.out.println("5. zip");
				System.out.println("6. phone number");
				int answer = input.nextInt();
				input.nextLine();
				
				if (answer == 1) {
					System.out.println("What do you want to change the ID to? ");
					int new_ID = input.nextInt();
					input.nextLine();
					entryBook[i].setId(new_ID);
				}
				
				if (answer == 2) {
					System.out.println("What do you want to change the first name to? ");
					String new_fname = input.next();
					input.nextLine();
					entryBook[i].setFname(new_fname);
				}
				
				if (answer == 3) {
					System.out.println("What do you want to change the last name to? ");
					String new_lname = input.next();
					input.nextLine();
					entryBook[i].setLname(new_lname);
				}
				
				if (answer == 4) {
					System.out.println("What do you want to change the email to? ");
					String new_email = input.next();
					input.nextLine();
					entryBook[i].setEmail(new_email);
				}
				
				if (answer == 5) {
					System.out.println("What do you want to change the zip code to? ");
					int new_zip = input.nextInt();
					input.nextLine();
					entryBook[i].setZip(new_zip);
				}
				
				if (answer == 6) {
					System.out.println("What do you want to change the phone number to? ");
					int new_PhoneNumber = input.nextInt();
					input.nextLine();
					entryBook[i].setPhoneNumber(new_PhoneNumber);
				}

				return 1;
			}
		}
		return 0;
	}
	
	// Delete an Entry by ID
	// [a, c ,b ] -> [b, c, b] -> [b,c] counter -=1
	// [a,c,b,d] -> [d,c,b,d] -> [d,c,b]
	public int DeleteEntry(int id) {
		SortbyId();
		for (int i=0; i<entryBook.length; i++) {
			if (entryBook[i].getId() == id) {
				entryBook[i] = entryBook[count-1];
				entryBook[count-1] = new PhoneBookEntry();
				count -= 1;
				SortbyId();
				return 1;
			}
		}
		return 0;
	}
	
	// Delete an Entry by First name and last name
	public int delEntry(String fname, String lname) {
		SortbyId();
		for (int i=0; i<entryBook.length; i++) {
			if (entryBook[i].getFname().equals(fname) && entryBook[i].getLname().equals(lname)) {
				entryBook[i] = entryBook[count];
				entryBook[count] = new PhoneBookEntry();
				count -= 1;
				SortbyId();
				return 1;
			}
		}
		return 0;
	}
	
}
