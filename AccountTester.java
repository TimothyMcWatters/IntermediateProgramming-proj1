/**
This program:
uses the Vigenere Cipher to encrypt passwords. 

@author Timothy McWatters
@version 1.0

COP3022    Project 1
File Name: AccountTester.java
*/

public class AccountTester {
	public static void main(String[] args) {
		
	     //creates an 6 instances of the User Class (tests both default User and User constructor w/ parameters, setUserName(), 
		 //setClearPassword(), setKey(), encrypt() and setEncryptedPassword())
	     User user1 = new User("Tim McWatters", "password", "house");
	     User user2 = new User("Bob Builder", "Hammer!1", "build");
	     User user3 = new User("Pink Floyd", "Another@", "Brick");
	     User user4 = new User("Donald Trump", "the-CINC", "POTUS");
	     User user5 = new User("Pennywise Clown", "Kings-IT", "scary");
	     User user6 = new User();
	     User user7 = new User("mjones   ", "abcd1234", "argos");
	     User user8 = new User();
	     
	     //creates an instance of the Accounts Class (tests both Accounts constructors)
	     Accounts acct1 = new Accounts("Cool Guy Construction", "2779 Grand Bay Court, Navarre Florida", 10);
	     Accounts acct2 = new Accounts();
	     
	     //completes Account info for acct2 (tests setCompanyName(), and setCompanyAddress())
	     acct2.setCompanyName("Horrible Guy Company");
	     acct2.setCompanyAddress("432 Failure Lane, Pensacola Florida");
	     
	     //Adds the 6 users to the accounts (tests addUser())
	     acct1.addUser(user1);
	     acct1.addUser(user2);
	     acct1.addUser(user3);
	     acct1.addUser(user4);
	     acct2.addUser(user5);
	     acct1.addUser(user6);
	     acct1.addUser(user7);
	     acct2.addUser(user8);
	     
	     //Prints the accounts toString() (tests both toString(), getCompanyAddress(), getCompanyName())
	     System.out.println(acct1.toString());
	     System.out.println(acct2.toString());
	     
	     //searches the account for usernames and prints their info, including one that isn't found (tests Accounts.getUser() method)
	     System.out.println(acct1.getUser("Tim McWatters"));
	     System.out.println(acct1.getUser("mjones   "));
	     System.out.println(acct1.getUser("Bob The Builder")); // printing null confirms that getUser() did indeed return null instead of an object
	     
	     //delete a user account (tests deleteUser(), findUser())
	     acct1.deleteUser("Pink Floyd");
	     
	     //Prints the accounts toString() again
	     System.out.println(acct1.toString());
	}
}
