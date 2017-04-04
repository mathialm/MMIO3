package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CompetitionsController {

	Scanner scanner = new Scanner(System.in);
	Boolean notFound = true;
	@FXML VBox vbox;

	public void getCompetitionsFromFile() throws FileNotFoundException {

		Scanner scan = new Scanner(new File("resources/competitions.txt"));
		

		while(scan.hasNextLine()){
			String line = scan.nextLine();
			String[] ccdd = line.split(";");		// Input: cityFrom;cityTo;dateFrom;dateTo


			for(Node hbox : vbox.getChildren()){
				((HBox) hbox).getChildren().addAll(new Label(ccdd[0]), new Label(ccdd[1]), new Label(ccdd[2]), new Label(ccdd[3]));
			}
		}
		scan.close();
	}
}
