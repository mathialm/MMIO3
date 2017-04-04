package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
	public static Stage stage;

	@Override
	public void start(Stage primaryStage) {
		stage = primaryStage;
		try {
			Pane root = FXMLLoader.load(getClass().getResource("/FXML/login.fxml"));
			Scene scene = new Scene(root, 320, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void changeScene(String url) {
		try {
			Pane root = FXMLLoader.load(getClass().getResource(url));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println("REGISTER USER");
		Registration register = new Registration();
		register.registerUser();
		
		launch(args);
	}
}
