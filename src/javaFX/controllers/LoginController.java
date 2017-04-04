package javaFX.controllers;

import java.io.FileNotFoundException;

import application.Login;
import application.Main;
import application.Registration;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginController {
	Main main = new Main();
	
	@FXML
	private TextField txtUsername;
	
	@FXML
	private PasswordField txtPassword;
	
	@FXML
	private Button btnLogin, btnRegister;
	
	@FXML
	private Text txtFeedback;
	
	public void logIn() {
		String username = txtUsername.getText();
		String password = txtPassword.getText();
		
		Login login = new Login();
		try {
			if(login.logIn(username, password)) {
				main.changeScene("/FXML/mainpage.fxml");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		txtFeedback.setText(Login.feedback);
	}
	
	public void goRegister() {
		Registration register = new Registration();
		register.registerUser();
	}
}
