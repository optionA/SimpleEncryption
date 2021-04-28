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
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";
 
    public static void startFileEncrypt(String key, File inputFile, File outputFile)
            throws EncryptException {
    	encryptionMain(Cipher.ENCRYPT_MODE, key, inputFile, outputFile);
    }
 
    public static void startFileDecrypt(String key, File inputFile, File outputFile)
            throws EncryptException {
    	encryptionMain(Cipher.DECRYPT_MODE, key, inputFile, outputFile);
    }
 
    private static void encryptionMain(int cipherMode, String key, File inputFile, File outputFile) throws EncryptException {
        try {
            Key userKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(cipherMode, userKey);
            FileInputStream streamInput = new FileInputStream(inputFile);
            byte[] iByteData = new byte[(int) inputFile.length()];
            streamInput.read(iByteData);
            byte[] oByteData = cipher.doFinal(iByteData);
            FileOutputStream streamOutput = new FileOutputStream(outputFile);
            streamOutput.write(oByteData);
            streamInput.close();
            streamOutput.close();
             
        } catch (NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | BadPaddingException
                | IllegalBlockSizeException | IOException ex) {
            throw new EncryptException("Error encrypting/decrypting file", ex);
        }
    }
}