
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
///**
// *
// * @author angshuman
// */
public class BookManager {

    private JSONArray jsonArray;
    private String jsonPath;

    public BookManager(String jsonPath) {
        this.jsonPath = jsonPath;
        try {
            Object jo = new JSONParser().parse(new FileReader(jsonPath));
            this.jsonArray = (JSONArray) jo;
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public int getTotalBooks() {
        return this.jsonArray.size();
    }
    
    public void addBook(String inputString) {
        try {
            String arr[] = inputString.split(",");
            JSONObject obj = new JSONObject();
            obj.put("Publisher", arr[0]);
            obj.put("Name", arr[1]);
            obj.put("Author", arr[2]);
            obj.put("Subject", arr[3]);
            obj.put("ISBN", arr[4]);
            obj.put("Price", new Long(arr[5]));
            obj.put("PicPath", arr[6]);
            obj.put("Quantity", new Long(arr[7]));
            this.jsonArray.add(obj);
            File oldFile = new File(this.jsonPath);
            FileWriter fw = new FileWriter(oldFile);
            fw.write(this.jsonArray.toJSONString());
            fw.flush();
            fw.close();
        } catch (Exception E) {
            System.out.println("Error: " + E);
        }
    }

    public void deleteBook(int rownumber) {
        try {
            this.jsonArray.remove(rownumber);
            File oldFile = new File(this.jsonPath);
            FileWriter fw = new FileWriter(oldFile);
            fw.write(this.jsonArray.toJSONString());
            fw.flush();
            fw.close();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

    public void updateBook(int index, String key, String value) {

        try {
            for (int i = 0; i < this.jsonArray.size(); i++) {
                JSONObject joi = (JSONObject) this.jsonArray.get(i);
                if (i == index) {
                    joi.put(key, value);
                }
            }
            File oldFile = new File(this.jsonPath);
            FileWriter fw = new FileWriter(oldFile);
            fw.write(this.jsonArray.toJSONString());
            fw.flush();
            fw.close();
        } catch (Exception E) {
            System.out.println("Error: " + E);
        }
    }
    
    public void searchBook(String bookName) {
        int i = 0;
        while(i<this.getTotalBooks()){
            Book obj = new Book(this.jsonPath, i);
            if(obj.getName().equalsIgnoreCase(bookName)) break;
            i++;
        }
        if (i >= this.getTotalBooks()) {
            System.out.println("No instance found.");
        } else {
            System.out.println("Match Found: ");
            Book obj = new Book(this.jsonPath, i);
            System.out.println("Book Code: " + obj.getCode());
            System.out.println("Publisher: " + obj.getPublisher());
            System.out.println("Book Name: " + obj.getName());
            System.out.println("Author: " + obj.getAuthor());
            System.out.println("Subject: " + obj.getSubject());
            System.out.println("ISBN: " + obj.getISBN());
            System.out.println("Price: " + obj.getPrice());
            System.out.println("Path of Picture: " + obj.getPicPath());
            System.out.println("Quantity: " + obj.getQuantity());
        }
    }
}