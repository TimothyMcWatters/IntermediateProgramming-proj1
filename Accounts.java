/**
This program:
uses the Vigenere Cipher to encrypt passwords. 

@author Timothy McWatters
@version 1.0

COP3022    Project 1
File Name: Accounts.java
*/

public class Accounts {
	//constants
	public static final int NOTFOUND = -1;
	public static final int PARTIALLY_FILLED_ARRAY_SIZE = 10;
	
	//instance variables
	private String companyName = "";
	private String companyAddress = "";
	private int numOfElements = 0;
	private User[] users = null;
	
	/**
	 * Default constructor for the Accounts class
	 */
	public Accounts() {
		setCompanyName("");
		setCompanyAddress("");
		this.users = new User[PARTIALLY_FILLED_ARRAY_SIZE];
	} // end of default constructor
	
	/**
	 * Constructor using 2 String parameters and 1 int parameter for the Accounts class
	 * @param companyName = the Accounts company name
	 * @param companyAddress = the Accounts company address
	 * @param arraySize = the size of the partially filled array
	 */
	public Accounts(String companyName, String companyAddress, int arraySize) {
		setCompanyName(companyName);
		setCompanyAddress(companyAddress);
		this.users = new User[arraySize];
	} //end of Accounts constructor w/ 2 String and 1 int parameter

	/**
	 * returns the Accounts company name
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	} // end of getCompanyName method

	/**
	 * sets the Accounts company name
	 * @param companyName = the company's name to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	} // end of setCompanyName method

	/**
	 * returns the Accounts company address
	 * @return the companyAddress
	 */
	public String getCompanyAddress() {
		return companyAddress;
	} // end of getCompanyAddress method

	/**
	 * sets the Accounts company address
	 * @param companyAddress = the company's address to set
	 */
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	} // end of setCompanyAddress method 

	/**
	 * adds a user to the Accounts users array and increments the numOfElements instance variable by 1
	 * @param user = a User to add
	 */
	public void addUser(User user) {
		users[numOfElements++] = user;
	} // end of addUser method
	
	/**
	 * uses the findUser() method to search for an return the User object associated with the parameter, or returns null if that userName is not found
	 * @param userName = the user name of User object to get
	 * @return User = the User object or null if the user is not found
	 */
	public User getUser(String userName) {
		int findUserResult = findUser(userName);
		if (findUserResult != -1) {
			return users[findUserResult];
		}
		System.out.printf("%s does not exist.\n", userName);
		return null;
	} // end of getUser method

	/**
	 * uses findUser() method to find and delete a user
	 * this method also re-organizes the users array to get rid of null or empty objects in the middle of the array (typically this would be done with another method and just 
	 * called in this method, but the program requirements deemed it should be done in this method)
	 * @param userName = the name of User to delete
	 * @return boolean = true if user was found and deleted, or false if not
	 */
	public boolean deleteUser(String userName) {
		int findUserResult = findUser(userName);
		int j = 0;
		if (findUserResult >= 0) {
			users[findUserResult] = null;
			for (int i = 0; i < users.length; i++) {
				if ((users[i] != null) && (users[i].getUserName() != "")) {
					users[j] = users[i];
					j++;
				}
			}
			numOfElements = j;
			for (int k = j; k < users.length; k++) {
				users[k] = null;
			}
			return true;
		}
		return false;
	} // end of deleteUser method
	
	/**
	 * attempts to find a user name in the Accounts user array, returns NOTFOUND constant if not found
	 * @param userName = the user name of User to find
	 * @return int = the array index number that was found, or NOTFOUND constant if the user name was not found
	 */
	private int findUser(String userName) {
		
		for (int indexNumber = 0; indexNumber < users.length; indexNumber++) {
			if (users[indexNumber] == null) {
				continue;
			}
			else if (users[indexNumber].getUserName().equals(userName)) {
				return indexNumber;
			}
			else { 
				continue;
			}
		}
		return NOTFOUND;
	} // end of findUser method

	/* returns a nicely formatted String representing the user to include username, encrypted password, clear password and key
	 * @return a formatted String
	 */
	public String toString() {
		String completeString = ("\n" + getCompanyName() + "\t" + getCompanyAddress() + "\n" +
								"Username		 	ClearPass	Key		EncryPass\n");
			for (int l = 0; l < this.numOfElements; l++) {
				completeString += users[l].toString() + "\n";
			} 
			return completeString;
	} // end of toString method
}  // end of Accounts class
