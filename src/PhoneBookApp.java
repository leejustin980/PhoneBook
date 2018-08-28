import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
public class PhoneBookApp {
	
	public static void main(String[] args) {
		// Create Scanner
		Scanner input = new Scanner(System.in);
		
		// Create admin and norm user
		PhoneBookAdmin admin = new PhoneBookAdmin();
		NormalUser user = new NormalUser();
		PhoneBookDirectory e = new PhoneBookDirectory();
		
		
		// Admin or User
		System.out.println("Welcome to the phonebook! ");
		System.out.println("Are you an admin or user? ");
		
		String response = input.nextLine();
		
		// ADMIN MENU
		if (response.equals("admin")) {
			// Get filename from user
			System.out.println("What is the filename you want to write into? ");
			File fileName = new File(input.nextLine());

			// reference one line at a time
			String line = null;

			// try and catch exceptions
			try {
				// create filereader and bufferedreader to read text files
				FileReader fileReader = new FileReader(fileName);

				// wrap filereader in bufferedreader
				BufferedReader bufferedReader = new BufferedReader(fileReader);

				// go through and print each line that is not empty
				String data = "";
				while ((line = bufferedReader.readLine()) != null) {
					data += (line);
				}
				// "a,b,c"
				String[] fields = data.split(",");
				// {"a","b","c"}

				// Display file content
				// System.out.println(Arrays.toString(fields));
				System.out.println("The Username is " + fields[0]);
				System.out.println("The Password is " + fields[1]);
				System.out.println("The Email address is " + fields[2]);

				// check if they are user or admin
				System.out.println("Please enter your username: ");
				String username = input.nextLine();
				admin.setUsername(username);
				System.out.println("Please enter your password: ");
				String password = input.nextLine();
				admin.setPassword(password);

				while (true) {
					if (username.equals(fields[0]) && password.equals(fields[1])) {
						System.out.println("Welcome!");
						System.out.println("What would you like to do? ");
						System.out.println("1. Add a phone entry");
						System.out.println("2. Print all phonebook entries");
						System.out.println("3. Search for an entry by phone number");
						System.out.println("4. Search for an entry by id");
						System.out.println("5. Sort phone book entries by id");
						System.out.println("6. Edit an entry");
						System.out.println("7. Change Username ");
						System.out.println("8. Change Password ");
						System.out.println("9. Delete an entry by ID");
						System.out.println("10. Delete an entry by first name and last name");
						System.out.println("11. Exit");

						int answer = input.nextInt();

						if (answer == 1) {
							int result = admin.addEntry();
							System.out.println(result);
						}

						if (answer == 2) {
							admin.printUserInfo();
						}

						if (answer == 3) {
							int result = admin.linearSearch();
							System.out.println(result);
						}

						if (answer == 4) {
							PhoneBookEntry result = admin.binarySearch();
							System.out.println(result.getFname() + " " + result.getLname());
							System.out.println("ID: " + result.getId());
							System.out.println("Phone Number: " + result.getPhoneNumber());
							System.out.println("Email: " + result.getEmail());
							System.out.println("Zip Code: " + result.getZip());
							System.out.println();
						}

						if (answer == 5) {
							admin.sortDirectory();
						}

						if (answer == 6) {
							int result = admin.editEntry();
							System.out.println(result);
						}
						
						if (answer == 7 ) {
							System.out.println("What is the new username: ");
							String newName = input.next();
							input.nextLine();
							admin.changeUser(newName);
						}
						
						if (answer == 8){
							System.out.println("What is the new password: ");
							String newPass = input.next();
							input.nextLine();
							admin.changePass(newPass);
						}

						if (answer == 9) {
							int result = admin.deleteEntry();
							System.out.println(result);
						}
						
						if (answer == 10) {
							int result = admin.delEntry();
						}

						if (answer == 11) {
							System.out.println("Exiting...");
							break;
						}
					}

				}
				
				// writing to the file
				File file = new File("admin.txt");
				FileWriter writer = new FileWriter("admin.txt");
				writer.write(admin.getUsername());
				writer.write(",");
				writer.write(admin.getPassword());
				writer.write(",");
				writer.write("adminEmail");
				writer.close();
				
				// close file
				bufferedReader.close();
			} catch (IOException ex) { // exception
				System.out.println("Error reading file '" + fileName + "'");
			}
		}

		
		// User Menu 
		if (response.equals("user")) {
			// Get filename from user
			System.out.println("What is the filename you want to write into? ");
			File fileName = new File(input.nextLine());
			
			// reference one line at a time
			String line = null;
			
			// try and catch exceptions
			try {
				// create filereader and bufferedreader to read text files
				FileReader fileReader = new FileReader(fileName);
				
				// wrap filereader in bufferedreader
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				
				// go through and print each line that is not empty
				String data = "";
				while((line = bufferedReader.readLine()) != null) {
					data+=(line);
				}
				//"a,b,c"
				String[] fields = data.split(",");
				//{"a","b","c"}
				
				// Display file content
				//System.out.println(Arrays.toString(fields));
				System.out.println("The Username is " + fields[0]);
				System.out.println("The Password is " + fields[1]);
				System.out.println("The Email address is " + fields [2]);
				
				// check if they are user or admin
				System.out.println("Please enter your username: ");
				String username = input.nextLine();
				admin.setUsername(username);
				System.out.println("Please enter your password: ");
				String password = input.nextLine();
				admin.setPassword(password);
				
				while (true) {
					if (username.equals(fields[0]) && password.equals(fields[1])) {
						System.out.println("Welcome!");
						System.out.println("What would you like to do? ");
						System.out.println("1. Add a phone entry");
						System.out.println("2. Print all phonebook entries");
						System.out.println("3. Search for an entry by phone number (Linear Search) ");
						System.out.println("4. Edit an entry");
						System.out.println("5. Exit");
						
						int answer = input.nextInt();
						
						if (answer == 1) {
							int result = user.addEntry();
							System.out.println(result);
						}
						
						if (answer == 2) {
							user.printUserInfo();
						}
						
						if (answer == 3) {
							int result = user.linearSearch();
							System.out.println(result);
						}
						
						if (answer == 4) {
							int result = user.editEntry();
							System.out.println(result);		
						}
						
						if (answer == 5) {
							System.out.println("Exiting...");
							
							break;
						}
					}
					
				}
				
				
				// close file
				bufferedReader.close();
			}
			catch (IOException ex) { // exception
				System.out.println("Error reading file '" + fileName + "'");
			}
		}
	}

}
