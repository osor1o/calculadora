package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage stage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Index.fxml"));
		
		Scene scene = new Scene(root);
		
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
