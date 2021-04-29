package GroupApp;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application {

		private static String key = ""; // encryption key instance variable 

		public static void setEncKey(String newkey) { // mutator for the encryption key
			key = newkey;
		}
		public static String getEncKey() { // accessors for the encryption key
			return key;
		}
		
		@Override
		public void start(Stage primaryStage) { // Loads HomeMenu.fxml and opens to menu
			try {
				AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/GroupApp/HomeMenu.fxml")); 
				Scene scene = new Scene(root,600,450);
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	    
		public static void main(String[] args)throws IOException { // launches app 
			launch(args);
		}
	}