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
void toChange(ActionEvent event) { // go to change key window on goToChangeKey press
	try {
		((Stage)(((Button)event.getSource()).getScene().getWindow())).close(); // close old window
		AnchorPane root1 = (AnchorPane)FXMLLoader.load(getClass().getResource("/GroupApp/ChangeEncryption.fxml")); // Load ChangeEncryption.fxml and open ChangeKey window
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
void toText(ActionEvent event) {  // go to encrypt window on goToEncrypt press
	try {
		((Stage)(((Button)event.getSource()).getScene().getWindow())).close(); // close old window
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/GroupApp/TextEncryption.fxml")); //Load TextEncryption.fxml open Encryption window
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
void toDecrypt(ActionEvent event) { /// go to Decryption window on goToDecrypt button press
	try {
		((Stage)(((Button)event.getSource()).getScene().getWindow())).close(); // close old window
		AnchorPane root1 = (AnchorPane)FXMLLoader.load(getClass().getResource("/GroupApp/FileDecryption.fxml")); //Load FileDecryption.fxml open Decryption window
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