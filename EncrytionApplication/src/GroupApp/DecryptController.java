package GroupApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;

public class DecryptController {

    @FXML
    private Button goToHome;

    @FXML
    private CheckBox burnCheck;

    @FXML
    private Label fileName;

    @FXML
    private CheckBox renameCheck;

    @FXML
    private Button decryptFile;

    @FXML
    private TextField newFileName;

    @FXML
    private Button selectFile;
    
    @FXML
    private Label enterFilePrompt;
    
    @FXML
    private Label currentKey;
    
    
    String inputFile;
    String encryptionKey;
    File selectedFile;
    
    void setInputFile(String file) {
    	this.inputFile=file;
    }

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
    void openFileChooser(ActionEvent event) 
    {
 	   try 
 	   {
 		   currentKey.setText(Main.getEncKey());
 		   FileChooser fileChooser = new FileChooser();
 		   fileChooser.setTitle("Select File to be Encrypted");
 		   Stage stage = new Stage();
 		   File selectedFile = fileChooser.showOpenDialog(stage);
 		   if (selectedFile != null) {
 		   String filePath = selectedFile.toString();
 		   setInputFile(filePath);
 		   fileName.setText(filePath);
 		   }
 	   } 
 	   catch(Exception e) 
 	   {
 		   e.printStackTrace();
 	   } 	   	
    }
    @FXML
    void renameToggle(ActionEvent event){
 	   try 
 	   {
 		   if(renameCheck.isSelected()) 
 		   {
 				newFileName.setOpacity(1.0);
 				newFileName.setDisable(false);
 				enterFilePrompt.setOpacity(1.0);
 				enterFilePrompt.setDisable(false);
 		   }
 		   else
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
    void decryptFile(ActionEvent event){
 	   try 
 	   {
 		   encryptionKey = Main.getEncKey();
 		   if((burnCheck.isSelected())&&(!renameCheck.isSelected())||(!(newFileName.getText().trim().length() > 0))) //Case 1: User burns file and doesnt rename output
 		   {
 			   File encryptionInput = new File(inputFile);
 			   File encryptionOutput = new File(inputFile);
 			   EncryptionMethods.startFileDecrypt(encryptionKey, encryptionInput, encryptionOutput);
 		   }
 		   else if((!burnCheck.isSelected())&&(!renameCheck.isSelected())||(!(newFileName.getText().trim().length() > 0))) //Case 2: User keeps file and doesnt rename output
 		   {
 			   File encryptionInput = new File(inputFile);
 			   String outputDir = selectedFile.getParent();
			   File encryptionOutput = new File(outputDir+"d");
 			   EncryptionMethods.startFileDecrypt(encryptionKey, encryptionInput, encryptionOutput);
 		   }
 		   else if((burnCheck.isSelected())&&(renameCheck.isSelected())&&(newFileName.getText().trim().length() > 0)) //Case 3: User burns file and renames output
 		   {
 			   File encryptionInput = new File(inputFile);
 			   String outputDir = selectedFile.getParent();
			   File encryptionOutput = new File(outputDir+(newFileName.getText().trim().replaceAll("[<>:\"/\\|?*]","")));
 			   EncryptionMethods.startFileDecrypt(encryptionKey, encryptionInput, encryptionOutput);
 			   encryptionInput.delete();
 		   }
 		   else if((!burnCheck.isSelected())&&(renameCheck.isSelected())&&(newFileName.getText().trim().length() > 0)) //Case 4: User keeps file and renames output
 		   {
 			   File encryptionInput = new File(inputFile);
 			   String outputDir = selectedFile.getParent();
			   File encryptionOutput = new File(outputDir+(newFileName.getText().trim().replaceAll("[<>:\"/\\|?*]","")));
 			   EncryptionMethods.startFileDecrypt(encryptionKey, encryptionInput, encryptionOutput);
 		   }
 		   
 	   }
 	   catch(Exception e) 
 	   {
 		   e.printStackTrace();
 	   }
    }
 }