package application;
	
import java.io.BufferedReader;
import java.io.InputStreamReader;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Library;

public class Main extends Application {

	static Library lib;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void initializeModel(int x) {
		String route="";
		if(x>0) {
			route="src/test cases/BasicInput.txt";
		}else {
			route="src/test cases/RandomInput.txt";
		}
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		}catch(Exception e) {
			
		}
	}
	
	public static Library getLib() {
		return lib;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
