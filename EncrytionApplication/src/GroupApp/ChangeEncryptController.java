package GroupApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ChangeEncryptController {

	
	@FXML
	private Button goToHome;
	
	@FXML
	private Label currentKey;
	
	@FXML
	private TextField EnterNewKey;
	
    @FXML
    private Button changeKey;
    
    @FXML
    private Label errorText;
    
    @FXML
    private Button goToDecrypt;
    
    @FXML
    private Button goToEncrypt;
    
    
    @FXML
    void goHome(ActionEvent event) { // Return to home window on homeButton press
    	try {

    		((Stage)(((Button)event.getSource()).getScene().getWindow())).close(); // close old window
    		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/GroupApp/HomeMenu.fxml")); //Load HomeMenu.fxml and open HomeMenu window
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
    void goToFileEncrypt(ActionEvent event) { // go to encrypt window on goToEncrypt press
    	try 
    	{
    		((Stage)(((Button)event.getSource()).getScene().getWindow())).close(); // close old window
    		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/GroupApp/TextEncryption.fxml")); //Load TextEncryption.fxml open Encryption window
    		Stage stage = new Stage();
    		Scene scene2 = new Scene(root,600,450);
    		stage.setScene(scene2);
    		stage.show();
    	} 
    	catch(Exception e) 
    	{
    		e.printStackTrace();
    	} 	   	
    }
    
    @FXML
    void goToFileDecrypt(ActionEvent event) { // go to decrypt window on goToDecrypt press
    	try 
    	{
    		((Stage)(((Button)event.getSource()).getScene().getWindow())).close(); // close old window
    		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/GroupApp/FileDecryption.fxml")); //Load FileDecryption.fxml open Decryption window
    		Stage stage = new Stage();
    		Scene scene2 = new Scene(root,600,450);
    		stage.setScene(scene2);
    		stage.show();
    	} 
    	catch(Exception e) 
    	{
    		e.printStackTrace();
    	} 	   	
    }
    
    
    @FXML
    void changeKey(ActionEvent event) { 	//get viable key from EnterNewKey textfield input
    	try {
    		if((EnterNewKey.getText().length()) != 16)	//determine if key is viable
    		{
    			errorText.setTextFill(Color.web("#ff4848"));
    			//printing warning and display character count
    			errorText.setText("Warning: The Encryption Key you entered is: "+EnterNewKey.getText().length()+" Characters \nThe Encryption Key must be 16 characters");
    		}
    		else 
    		{
    			Main.setEncKey(EnterNewKey.getText()); //send key variable to key mutator in main
    			currentKey.setText(Main.getEncKey());	//update textfield currentKey to display entered key
    			errorText.setTextFill(Color.WHITE);
    			errorText.setText("Encryption Key Changed!");
    		}
    	} 
   	catch(Exception e) {
    		e.printStackTrace();
    	} 	   	
   }
}   	 	  