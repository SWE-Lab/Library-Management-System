
import java.io.FileReader;
import java.time.LocalDate;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author angshuman
 */
public class Member {
    private String name;
    private String email;
    private long phNo;
    private String password;
    private long enrollNo;
    private String picPath;
    private double fine;
    private LocalDate date;
    
    public Member(String jsonPath, int index){
        try {
            Object jo = new JSONParser().parse(new FileReader(jsonPath));
            JSONArray ja = (JSONArray) jo;
            JSONObject joi = (JSONObject) ja.get(index);
            this.name = (String) joi.get("Name");
            this.email = (String) joi.get("Email");
            this.phNo = (long) joi.get("PhNo");
            this.password = (String) joi.get("Password");
            this.enrollNo = (long) joi.get("EnrollNo");
            this.picPath = (String) joi.get("PicPath");
            this.fine = (double) joi.get("Fine");
            this.date = (LocalDate) joi.get("EnrollDate");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getEMail(){
        return this.email;
    }
    
    public long getPhNo(){
        return this.phNo;
    }
    public String getPassword(){
        return this.password;
    }
    public long getEnrollNo(){
        return this.enrollNo;
    }
    public String getPicPath(){
        return this.picPath;
    }
    public double getFine(){
        return this.fine;
    }
    public LocalDate getDate(){
        return this.date;
    }
}
