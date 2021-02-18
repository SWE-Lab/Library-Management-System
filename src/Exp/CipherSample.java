/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exp;

/**
 *
 * @author hackme
 */
import java.io.FileReader;
import java.lang.reflect.Array;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import javax.crypto.Cipher;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class CipherSample {

//    private BookManager bookObj = new BookManager("dtb-array.json");
    public static void main(String args[]) throws Exception {
//        String s = "";
        JSONParser jsonParser = new JSONParser();
        try {
            Object obj = jsonParser.parse(new FileReader("dtb-array.json"));
            JSONArray array = new JSONArray();
            array.add(obj);
            //Creating a Signature object
//        Signature sign = Signature.getInstance("SHA256withRSA");
            //Creating KeyPair generator object
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");

            //Initializing the key pair generator
            keyPairGen.initialize(2048);

            //Generating the pair of keys
            KeyPair pair = keyPairGen.generateKeyPair();

            //Creating a Cipher object
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

            //Initializing a Cipher object
            cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());
//        System.out.println(pair.getPublic());
//        System.out.println(pair.getPrivate());

            //Adding data to the cipher
//        
            byte[] input = array.toJSONString().getBytes();
            cipher.update(input);

            //encrypting the data
            byte[] cipherText = cipher.doFinal();
            System.out.println(new String(cipherText, "UTF8"));

            //Initializing the same cipher for decryption
            cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());

            //Decrypting the text
            byte[] decipheredText = cipher.doFinal(cipherText);
            System.out.println(new String(decipheredText));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
