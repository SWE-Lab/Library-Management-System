
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.Vector;
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

    private String jsonPath;
    private JSONArray jsonArray;
    private Vector<Member> memberArray = new Vector<Member>();
    private String name;
    private String email;
    private String phNo;
    private String password;
    private String enrollNo;
    private String profilePicPath;
    private long fine;
    private LocalDate date;

    public Member() {
        this.name = "";
        this.email = "";
        this.phNo = "";
        this.password = "";
        this.enrollNo = "";
        this.profilePicPath = "";
        this.fine = 0;
        this.date = LocalDate.now();
    }

    public Member(String jsonPath) {
        this.jsonPath = jsonPath;
        this.createMemberArray();
    }

    public Member(JSONArray jsonArray, int index) {
        JSONObject joi = (JSONObject) jsonArray.get(index);
        this.name = (String) joi.get("Name");
        this.email = (String) joi.get("Email");
        this.phNo = (String) joi.get("PhNo");
        this.password = (String) joi.get("Password");
        this.enrollNo = (String) joi.get("EnrollNo");
        this.profilePicPath = (String) joi.get("ProfilePicPath");
        this.fine = (long) joi.get("Fine");
        this.date = LocalDate.parse((String)joi.get("EnrollDate"));
//        this.date = LocalDate.now();
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhNo() {
        return this.phNo;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEnrollNo() {
        return this.enrollNo;
    }

    public String getPicPath() {
        return this.profilePicPath;
    }

    public double getFine() {
        return this.fine;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setName(String input) {
        this.name = input;
    }

    public void setEmail(String input) {
        this.email = input;
    }

    public void setPhNo(String input) {
        this.phNo = input;
    }

    public void setPassword(String input) {
        this.password = input;
    }

    public void setEnrollNo(String input) {
        this.enrollNo = input;
    }

    public void setProfilePicPath(String input) {
        this.profilePicPath = input;
    }

    public void setFine(long input) {
        this.fine = input;
    }
    
    public void setDate(LocalDate input) {
        this.date = input.plusYears(1);
    }

    private void createMemberArray() {
        try {
            Object jo = new JSONParser().parse(new FileReader(this.jsonPath));
            this.jsonArray = (JSONArray) jo;
            int i = 0;
            while (i < this.jsonArray.size()) {
                Member member = new Member(this.jsonArray, i);
                this.memberArray.add(member);
                i++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Vector<Member> getMemberArray() {
        return this.memberArray;
    }
    
    public void saveInfo() {
        try {
            int i = 0;
            JSONArray jaNew = new JSONArray();
            while (i < this.memberArray.size()) {
                Member member = this.memberArray.get(i);
                JSONObject obj = new JSONObject();
                obj.put("Name", member.getName());
                obj.put("Email", member.getEmail());
                obj.put("PhNo", member.getPhNo());
                obj.put("Password", member.getPassword());
                obj.put("EnrollNo", member.getEnrollNo());
                obj.put("ProfilePicPath", member.getPicPath());
                obj.put("Fine", member.getFine());
                obj.put("EnrollDate", member.getDate());
                jaNew.add(obj);
                i++;
            }
            File file = new File(this.jsonPath);
            FileWriter fw = new FileWriter(file);
            fw.write(jaNew.toJSONString());
            fw.flush();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
