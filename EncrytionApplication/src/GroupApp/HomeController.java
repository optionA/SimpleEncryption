package GroupApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    private Button goToChange;

    @FXML
    private Button goToDecrypt;

    @FXML
    private Button goToText;


@FXML
void toChange(ActionEvent event) { //Go to change Window
	try {
		((Stage)(((Button)event.getSource()).getScene().getWindow())).close(); // close old window
		AnchorPane root1 = (AnchorPane)FXMLLoader.load(getClass().getResource("/GroupApp/ChangeEncryption.fxml")); 
		Stage stage = new Stage();
		Scene scene2 = new Scene(root1,600,450);
		stage.setScene(scene2);
		stage.show();
	} 
	catch(Exception e) {
		e.printStackTrace();
	}
}
@FXML
void toText(ActionEvent event) {  //Go to Text Window
	try {
		((Stage)(((Button)event.getSource()).getScene().getWindow())).close(); // close old window
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/GroupApp/TextEncryption.fxml")); 
		Stage stage = new Stage();
		Scene scene2 = new Scene(root,600,450);
		stage.setScene(scene2);
		stage.show();
	} 
	catch(Exception e) {
		e.printStackTrace();
	}
}
@FXML
void toDecrypt(ActionEvent event) { //Go to Decryption Window
	try {
		((Stage)(((Button)event.getSource()).getScene().getWindow())).close(); // close old window
		AnchorPane root1 = (AnchorPane)FXMLLoader.load(getClass().getResource("/GroupApp/FileDecryption.fxml")); 
		Stage stage = new Stage();
		Scene scene2 = new Scene(root1,600,450);
		stage.setScene(scene2);
		stage.show();
	} 
	catch(Exception e) {
		e.printStackTrace();
	}
}


}