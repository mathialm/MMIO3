package application.login;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Login {
	
	private Scanner scanner = new Scanner(System.in);
	private Boolean notFound = true;
	public static String feedback = null;
	
	public boolean logIn(String username, String password) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("resources/users.txt"));
		
		while(scan.hasNextLine() && notFound) {
			String search = scan.nextLine();
			String[] credentials = search.split(", ");
			String scannedUsername = credentials[0];
			String scannedPassword = credentials[1];

			if(username.equals(scannedUsername)) {
				if(password.equals(scannedPassword)) {
					feedback = "Successfully logged in!";
					User.setUsername(username);
					notFound = false;
					return true;
				} else {
					feedback = "Wrong password.";
					notFound = false;
					return false;
				}
			}
		}
		
		if (notFound) {
			feedback = "User does not exist.";
		}
		
		return false;
	}
}
