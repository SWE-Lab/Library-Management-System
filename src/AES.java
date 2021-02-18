
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hackme
 */
public class AES {

    private SecretKeySpec secretKey;
    private byte[] key;
    private String backupKey;

    public void genKey() {
//        String secretKey = "";
        try {
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
            keyPairGen.initialize(2048);
            KeyPair pair = keyPairGen.generateKeyPair();
            this.backupKey = pair.getPublic().toString();
            File file = new File("key.txt");
            FileWriter fw = new FileWriter(file);
            fw.write(this.backupKey);//.substring(56, 673));
            fw.flush();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
//        return secretKey;
    }

    public void setKey(String myKey) {
        MessageDigest sha = null;
        try {

            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            this.secretKey = new SecretKeySpec(key, "AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public String encrypt(String strToEncrypt) {
        try {
            this.genKey();
            setKey(this.backupKey);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    public String decrypt(String strToDecrypt) {
        try {
//            File file = new File("key.txt");
//            FileReader fw = new FileReader(file);
            String p = Files.readAllLines(Paths.get("key.txt")).get(0);
            System.out.println(p);
            setKey(p);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
//            fw.close();
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
//            fw.flush();
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }

    public static void main(String[] args) {

        AES aes = new AES();
        try {

            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader("dtb-array.json"));
            JSONArray array = new JSONArray();
            array.add(obj);
            String originalString = array.toString();
            String encryptedString = aes.encrypt(originalString);
            File file = new File("enc.txt");
            FileWriter fw = new FileWriter(file);
            fw.write(encryptedString);
            fw.flush();
            fw.close();
            System.out.println(Files.readString(Paths.get("enc.txt")));
            String decryptedString = aes.decrypt(Files.readString(Paths.get("enc.txt")));

//            System.out.println(originalString);
            System.out.println(encryptedString);
            System.out.println(decryptedString);
        } catch (Exception e) {
        }
    }
}
