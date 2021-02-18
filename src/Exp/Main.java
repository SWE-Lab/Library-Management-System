/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exp;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author hackme
 */
public class Main {

    public static void main(String[] args) throws NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, InvalidKeySpecException, IOException {
	// write your code here

//        args[]={"exp.txt","exp2.txt","AES","123"};
        String file = args[0];
        String destFile = args[1];
        String mode = args[2];
        String password = args[3];

        byte[] fileBytes = NullbeansFileManager.readFile(file);
        byte[] resultBytes = null;

        if(mode.equalsIgnoreCase("encrypt")){
            resultBytes = AESEncryptionManager.encryptData(password, fileBytes);
        }else {
            resultBytes = AESEncryptionManager.decryptData(password, fileBytes);
        }

        NullbeansFileManager.writeFile(destFile, resultBytes);

    }

}