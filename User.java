/**
This program:
uses the Vigenere Cipher to encrypt passwords. 

@author Timothy McWatters
@version 1.0

COP3022    Project 1
File Name: User.java
*/

public class User {
	private String username = "";
	private String clearPassword = "";
	private String encryptedPassword = "";
	private String key = "";
	
	/**
	 * Default Constructor for the User Class
	 */
	public User() {
		setUserName("");
		setClearPassword("");
		setEncryptedPassword("");
		setKey("");
	} // end of default constructor
	
	/**
	 * Constructor using 3 String parameters for the User Class
	 * @param username = the users username
	 * @param clearPassword = the users unencrypted password
	 * @param key = the users key to be used in the Vigenere Cipher 
	 */
	public User(String username, String clearPassword, String key) {
		setUserName(username);
		setClearPassword(clearPassword);
		setKey(key);
		encrypt();
	} // end of constructor w/ 3 String parameters

	/**
	 * returns the users username
	 * @return the username = users username
	 */
	public String getUserName() {
		return username;
	} // end of getUserName method

	/**
	 * sets the users username 
	 * @param username the username to set
	 */
	public void setUserName(String username) {
		this.username = username;
	} // end of setUserName method

	/**
	 * returns the users unencrypted password
	 * @return the clearPassword = the users unencrypted password
	 */
	public String getClearPassword() {
		return clearPassword;
	} // end of getClearPassword method

	/**
	 * sets the users unencrypted password
	 * @param clearPassword the clearPassword to set
	 */
	public void setClearPassword(String clearPassword) {
		this.clearPassword = clearPassword;
	} // end of setClearPassword method

	/**
	 * returns the users encrypted password
	 * @return the encryptedPassword
	 */
	public String getEncryptedPassword() {
		return encryptedPassword;
	} // end of getEncryptedPassword method

	/**
	 * sets the users encrypted password
	 * @param encryptedPassword the encryptedPassword to set
	 */
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	} // end of setEncryptedPassword method

	/**
	 * returns the key to be used in the Vigenere Cipher
	 * @return the key = key to be used in Vigenere Cipher
	 */
	public String getKey() {
		return key;
	} // end of getKey method

	/**
	 * sets the key to be used in the Vigenere Cipher
	 * @param key the key to set = key to be used in Vigenere Cipher
	 */
	public void setKey(String key) {
		this.key = key;
	} // end of setKey method
	
	/**
	 * uses the Vigenere Cipher, the unencrypted password (clearPassword), and the key 
	 * to encrypt the users password populating/storing the encryptedPassword instance variable
	 */
	private void encrypt() {
		int newKeyIndexNum = 0;
		String newKey = this.key; // newKey will be used to ensure the key and password are the same length
		String intermediatePassword = "";
		// This program specifically calls for a key length 5 and a password length 8, but instead of hard-coding 
		// 5 and 8, this while loop ensures that the key starts over again if the password is longer than the key
		// regardless of the actual numbers. 
		while (newKey.length() < clearPassword.length()) {
			newKey += newKey.charAt(newKeyIndexNum); 
			newKeyIndexNum++;
		}
		
		// Determines how many char's to shift the password based off the newKey found above
		// then iterates through the clearPassword and shifts each character while appending the
		// shifted character to the encryptedPassword one char at a time while keeping them between 33-122 inclusive
		for (int j = 0; j < this.clearPassword.length(); j++) {
	         int shiftedASCIICharactersNumber = (clearPassword.charAt(j) + (newKey.charAt(j) - 33));
	         if (shiftedASCIICharactersNumber < 123) {
	        	 intermediatePassword += (char)(shiftedASCIICharactersNumber);
	         
	         } 
	         else {
	        	 intermediatePassword += (char)((shiftedASCIICharactersNumber % 122) + 32);
	         }
	         setEncryptedPassword(intermediatePassword);
	      }
	} // end of encrypt method

	/* returns a nicely formatted String representing the user to include 
	 * username, encrypted password, clear password and key
	 * @return a formatted String
	 */
	public String toString() {
		return (getUserName() + "\t\t" + getClearPassword() + "\t\t" + getKey() + "\t\t" + getEncryptedPassword());
	} // end of toString method
} // end of User class
