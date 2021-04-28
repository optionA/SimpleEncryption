package GroupApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
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
    void goHome(ActionEvent event) { // Return to home window on homeButton press
    	try {

    		((Stage)(((Button)event.getSource()).getScene().getWindow())).close(); // close old window
    		// open Home window
    		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/GroupApp/HomeMenu.fxml")); 
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
    void changeKey(ActionEvent event) {
    	try {
    		if((EnterNewKey.getText().length()) != 16)
    		{
    			errorText.setText("Encryption Key must be 16 digits");
    		}
    		else 
    		{
    			Main.setEncKey(EnterNewKey.getText());
    			currentKey.setText(Main.getEncKey());
    			errorText.setText("Encryption Key Changed");
    		}
    	} 
   	catch(Exception e) {
    		e.printStackTrace();
    	} 	   	
   }
}   	 	  