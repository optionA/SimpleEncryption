package GroupApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import javafx.scene.paint.Color;

public class TextEncryptController {


	//fxml objects
    @FXML
    private CheckBox burnCheck;
    @FXML
    private Label fileName;
    @FXML
    private CheckBox renameCheck;
    @FXML
    private TextArea fileDisplay;
    @FXML
    private TextField newFileName;
    @FXML
    private Label enterFilePrompt;
    @FXML
    private Button encryptFileButton;
    @FXML
    private Button selectFile;
    @FXML
    private Label currentKey;   
    @FXML
    private Button goToChangeKey;    
    @FXML
    private Button goToDecrypt;    
    @FXML
    private Label errorLabel;  
    @FXML
    private CheckBox showKeyCheck;  
    @FXML
    private Label keyInfo;   
    @FXML
    private Label currentKeyMessage;
    
    //instance variables
    String inputFile;		//inputFile will hold location of file to encrypt
    String encryptionKey;	//stores the encryption key accessed from main
    File selectedFile;		//temporary file object used in file chooser
    

 
    @FXML
    void goHome(ActionEvent event) { // Return to home window on homeButton press
    	try 
    	{
    		((Stage)(((Button)event.getSource()).getScene().getWindow())).close(); // close old window
    		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/GroupApp/HomeMenu.fxml")); //Load HomeMenu.fxml and open HomeMenu window
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
    void goToChange(ActionEvent event) { // go to change key window on goToChangeKey button press
    	try 
    	{
    		((Stage)(((Button)event.getSource()).getScene().getWindow())).close(); // close old window
    		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/GroupApp/ChangeEncryption.fxml")); // Load ChangeEncryption.fxml and open ChangeKey window
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
    void goToFileDecrypt(ActionEvent event) { // go to Decryption window on goToDecrypt button press
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
   void openFileChooser(ActionEvent event) // opens File explorer on selectFile button press and saves selected file
   {
	   try 
	   {
		   FileChooser fileChooser = new FileChooser(); // new FileChooser object
		   fileChooser.setTitle("Select File to be Encrypted"); // change file explorer title
		   Stage stage = new Stage(); // open file explorer 
		   File selectedFile = fileChooser.showOpenDialog(stage); // store selected file as object
		   if (selectedFile != null) {					// determine that a file was selected
		   String filePath = selectedFile.toString();	// save selected file path to variable
		   inputFile = filePath;						//update instance variable			
		   fileName.setText(filePath);				// show file path on a text field
		   }
	   } 
	   catch(Exception e) 
	   {
		   e.printStackTrace();
	   } 	   	
   }
   @FXML
   void showKeyToggle(ActionEvent event){		//show hide and edit ui elements based on showKey checkbox status and current encryption key
	   try 
	   {
		   if(showKeyCheck.isSelected()) 	//if selected show and enable keyInfo, currentKey, currentKeyMessage
		   {
			   	keyInfo.setOpacity(1.0);
			   	keyInfo.setDisable(false);
				currentKey.setOpacity(1.0);
				currentKey.setDisable(false);
				currentKeyMessage.setOpacity(1.0);
				currentKeyMessage.setDisable(false);
		   }
		   else							//if not selected hide and disable keyInfo, currentKey, currentKeyMessage
		   {
			   keyInfo.setOpacity(0);
			   keyInfo.setDisable(true);
			   currentKey.setOpacity(0);
			   currentKey.setDisable(true);
			   currentKeyMessage.setOpacity(0);
			   currentKeyMessage.setDisable(true);
		   }
		   if(Main.getEncKey().length() > 0)	//if the user has entered an encryption key, show it
		   {
			   currentKey.setTextFill(Color.WHITE);  //set label color to white
			   currentKey.setText(Main.getEncKey()); //display current encryption key on label
		   }
		   else									//if the user has not entered an encryption key, show warning
		   {	
			   currentKey.setTextFill(Color.web("#ff4848")); //set label color to red
			   currentKey.setText("Warning: No Encryption Key set!"); //display warning on label
		   }
	   }
	   catch(Exception e) 
	   {
		   e.printStackTrace();
	   }
   }
   @FXML
   void renameToggle(ActionEvent event){ //show and hide ui elements based on renameCheck checkbox status
	   try 
	   {
		   if(renameCheck.isSelected()) //if selected show and enable newFileName and enterFilePrompt
		   {
				newFileName.setOpacity(1.0);
				newFileName.setDisable(false);
				enterFilePrompt.setOpacity(1.0);
				enterFilePrompt.setDisable(false);
		   }
		   else							//if not selected hide and disable newFileName and enterFilePrompt
		   {
			   newFileName.setOpacity(0);
			   newFileName.setDisable(true);
			   enterFilePrompt.setOpacity(0);
			   enterFilePrompt.setDisable(true);
		   }
	   }
	   catch(Exception e) 
	   {
		   e.printStackTrace();
	   }
   }
   @FXML
   void encryptFile(ActionEvent event){		//collect user inputs and determine encryption operation
	   try 
	   {
		   encryptionKey = Main.getEncKey();		//get encryption key from main
		   if(!(Main.getEncKey().length() == 16)) 	//make sure key is valid
		   {
			   errorLabel.setTextFill(Color.web("#ff4848"));		//set label color to red
			   errorLabel.setText("File not encrypted: invalid or missing key");	//show warning on label
		   }
		   else
		   {
			   if(fileName.getText().length() <= 0)		//make sure input file isnt empty
			   {
				   errorLabel.setTextFill(Color.web("#ff4848"));	//set label color to red
				   errorLabel.setText("An input file is required: please select a file"); //show warning on label
			   }
			   else
			   {
		   		if((burnCheck.isSelected())&&((!renameCheck.isSelected())||!(newFileName.getText().trim().length() > 0))) //Case 1: User burns file and doesnt rename output
		   		{
		   			File encryptionInput = new File(inputFile);			//make file object for input file
		   			File encryptionOutput = new File(inputFile);		//make file object for output file(identical to overwrite original)
		   			EncryptionMethods.startFileEncrypt(encryptionKey, encryptionInput, encryptionOutput); //send variables to encryption
		   			errorLabel.setTextFill(Color.WHITE);	//set label color to white
		   			errorLabel.setText("File encrypted!");	//display confirmation message
		   		}
		   		else if((!(burnCheck.isSelected()))&&((!(renameCheck.isSelected()))||((newFileName.getText().trim().length() == 0)))) //Case 2: User keeps file and doesnt rename output
		   		{
		   			File encryptionInput = new File(inputFile); //make file object for input file
		   			int dot = inputFile.lastIndexOf('.');	//get index of the last . in the file
		   			String outfile = inputFile.substring(0,dot)+'1'+inputFile.substring(dot);	//place a 1 in front of the . to save the original file
		   			File encryptionOutput = new File(outfile);	//place string into file object for output
		   			EncryptionMethods.startFileEncrypt(encryptionKey, encryptionInput, encryptionOutput); //send variables to encryption
		   			errorLabel.setTextFill(Color.WHITE);	//set label color to white
		   			errorLabel.setText("File encrypted!");	//display confirmation message
		   		}
		   		else if((burnCheck.isSelected())&&(renameCheck.isSelected())&&(newFileName.getText().trim().length() > 0)) //Case 3: User burns file and renames output
		   		{
		   			File encryptionInput = new File(inputFile); //make file object for input file
		   			int index = inputFile.lastIndexOf('\\'); //get index of the last \ in the file
		   			String outputDir = inputFile.substring(0,index+1); //remove everything after the last \ to get file path
		   			File encryptionOutput = new File(outputDir+newFileName.getText()); //remove everything after the last \ to get file path
		   			EncryptionMethods.startFileEncrypt(encryptionKey, encryptionInput, encryptionOutput); //send variables to encryption
		   			encryptionInput.delete();	//delete original input file
		   			errorLabel.setTextFill(Color.WHITE);	//set label color to white
		   			errorLabel.setText("File encrypted!");	//display confirmation message
		   		}
		   		else if((!burnCheck.isSelected())&&(renameCheck.isSelected())&&(newFileName.getText().trim().length() > 0)) //Case 4: User keeps file and renames output
		   		{
		   			File encryptionInput = new File(inputFile);
		   			int index = inputFile.lastIndexOf('\\'); //get index of the last \ in the file
		   			String outputDir = inputFile.substring(0,index+1); //remove everything after the last \ to get file path
		   			File encryptionOutput = new File(outputDir+newFileName.getText()); //remove everything after the last \ to get file path
		   			EncryptionMethods.startFileEncrypt(encryptionKey, encryptionInput, encryptionOutput); //send variables to encryption
		   			errorLabel.setTextFill(Color.WHITE);	//set label color to white
		   			errorLabel.setText("File encrypted!");	//display confirmation message
		   		}
			   }
		   }
	   }
	   catch(Exception e) 
	   {
		   e.printStackTrace();
	   }
	   fileName.setText(""); //clear filename space
	   newFileName.clear();	//clear newfilename space
   }

}