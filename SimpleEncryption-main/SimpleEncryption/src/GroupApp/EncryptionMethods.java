package GroupApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionMethods {
    private static final String ALGOR = "AES";		//instance variable for AES encryption algorithm
    private static final String TRANSFORM = "AES";	//instance variable for AES encryption transformation
 
    public static void startFileEncrypt(String key, File inputFile, File outputFile) //gets key, input file, and output file, then starts encryption 
            throws EncryptException {
    	encryptionMain(Cipher.ENCRYPT_MODE, key, inputFile, outputFile);	//sends cipher, key, input file, and output file to  be encrypted
    }
 
    public static void startFileDecrypt(String key, File inputFile, File outputFile) //gets key, input file, and output file, then starts decryption 
            throws EncryptException {
    	encryptionMain(Cipher.DECRYPT_MODE, key, inputFile, outputFile);	//sends cipher, key, input file, and output file to  be decrypted
    }
 
    private static void encryptionMain(int cipherMode, String key, File inputFile, File outputFile) throws EncryptException {
        try {
            Key userKey = new SecretKeySpec(key.getBytes(), ALGOR);	//creates AES algorithm using key
            Cipher cipher = Cipher.getInstance(TRANSFORM);	//creates AES cipher
            cipher.init(cipherMode, userKey);	//initializes cipher with encryption key
            FileInputStream streamInput = new FileInputStream(inputFile); //open file object
            byte[] iByteData = new byte[(int) inputFile.length()];	//generate byte array
            streamInput.read(iByteData);	//read from input byte data
            byte[] oByteData = cipher.doFinal(iByteData);	//conclusion of encryption/decryption process
            FileOutputStream streamOutput = new FileOutputStream(outputFile);
            streamOutput.write(oByteData);	//write to output file
            streamInput.close();		//close input
            streamOutput.close();		//close output
             
        } catch (NoSuchPaddingException | NoSuchAlgorithmException	//exception handling
                | InvalidKeyException | BadPaddingException
                | IllegalBlockSizeException | IOException ex) {
            throw new EncryptException("Error encrypting/decrypting file", ex);
        }
    }
}