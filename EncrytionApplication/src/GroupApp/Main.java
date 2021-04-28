package GroupApp;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application {

		private static String key;

		public static void setEncKey(String newkey) {
			key = newkey;
		}
		public static String getEncKey() {
			return key;
		}
		
		@Override
		public void start(Stage primaryStage) { 
			try {
				AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/GroupApp/HomeMenu.fxml"));
				Scene scene = new Scene(root,600,450);
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	    
		public static void main(String[] args)throws IOException { // launch app 
			launch(args);
		}
	}