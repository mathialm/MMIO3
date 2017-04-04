package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Registration {

	Scanner scanner = new Scanner(System.in);

	public void registerUser() {
		System.out.println("Enter username: ");
		String username = scanner.next();
		System.out.println("Enter password: ");
		String password = scanner.next();

		String user = username + ", " + password + "\n";

		FileOutputStream fos = null;
		File file;
		
		try {
			file = new File("resources/users.txt");
			fos = new FileOutputStream(file, true);
			
			byte[] content = user.getBytes();
			
			fos.write(content);
			fos.flush();
			fos.close();
			
			System.out.println("Successfully registered!\n");
			goToLogin();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void goToLogin() throws FileNotFoundException {
		System.out.println("LOGIN\n");
		Login login = new Login();
		login.logIn();
	}
}
