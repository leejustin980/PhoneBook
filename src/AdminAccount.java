
public interface AdminAccount {
	public int addEntry();
	public int editEntry();
	public int deleteEntry();
	public void sortDirectory();
	public int linearSearch();
	public PhoneBookEntry binarySearch();
	public void printUserInfo();
	public void changePass(String newPass);
	public void changeUser(String newName);
	
}
