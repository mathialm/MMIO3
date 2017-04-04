package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Login {
	
	Scanner scanner = new Scanner(System.in);
	Boolean notFound = true;
	
	public void logIn() throws FileNotFoundException {
		Scanner scan = new Scanner(new File("resources/users.txt"));
		
		System.out.println("Enter username: ");
		String username = scanner.next();
		System.out.println("Enter password: ");
		String password = scanner.next();
		
		while(scan.hasNextLine() && notFound) {
			String search = scan.nextLine();
			String[] credentials = search.split(", ");
			String scannedUsername = credentials[0];
			String scannedPassword = credentials[1];

			if(username.equals(scannedUsername)) {
				if(password.equals(scannedPassword)) {
					System.out.println("Successfully logged in!");
					notFound = false;
					break;
				} else {
					System.out.println("Wrong password.");
					notFound = false;
					break;
				}
			}
		}
		
		if (notFound) {
			System.out.println("User does not exist.");
		}
	}
}
