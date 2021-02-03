
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.PrintWriter;
//import java.util.Scanner;
//
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

    private String jsonPath;

    public BookManager(String jsonPath) {
        this.jsonPath = jsonPath;
    }

    public int getTotalBooks() {
        try {
            Object jo = new JSONParser().parse(new FileReader(this.jsonPath));
            JSONArray ja = (JSONArray) jo;
            return ja.size();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return -1;
    }

    public void deleteBook(int rownumber) {
        try {
            Object jo = new JSONParser().parse(new FileReader(this.jsonPath));
            JSONArray ja = (JSONArray) jo;
            ja.remove(rownumber);
            File oldFile = new File(this.jsonPath);
            FileWriter fw = new FileWriter(oldFile);
            fw.write(ja.toJSONString());
            fw.flush();
            fw.close();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

    public void updateBook(int index, String key, String value) {

        try {
            Object jo = new JSONParser().parse(new FileReader(this.jsonPath));
            JSONArray ja = (JSONArray) jo;
            for (int i = 0; i < ja.size(); i++) {
                JSONObject joi = (JSONObject) ja.get(i);
                if (i == index) {
                    joi.put(key, value);
                }
            }
            File oldFile = new File(this.jsonPath);
            FileWriter fw = new FileWriter(oldFile);
            fw.write(ja.toJSONString());
            fw.flush();
            fw.close();
        } catch (Exception E) {
            System.out.println("Error: " + E);
        }
    }
//    public boolean searchBook(String bookName) {
//        File oldFile = new File(this.csvPath);
//        String publisher = "", name = "", author = "", subject = "", isbn = "", price = "", picPath = "";
//        try {
//            Scanner x = new Scanner(new File(this.csvPath));
//            x.useDelimiter("[,\n]");
//            while (x.hasNext()) {
//                publisher = x.next();
//                name = x.next();
//                author = x.next();
//                subject = x.next();
//                isbn = x.next();
//                price = x.next();
//                picPath = x.next();
//                if (name.equals(bookName)) {
//                    return true;
//                }
//            }
//            x.close();
//        } catch (Exception e) {
//            System.out.println("Error " + e);
//        }
//        return false;
//    }
//

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
            Object jo = new JSONParser().parse(new FileReader(this.jsonPath));
            JSONArray ja = (JSONArray) jo;
            ja.add(obj);
            File oldFile = new File(this.jsonPath);
            FileWriter fw = new FileWriter(oldFile);
            fw.write(ja.toJSONString());
            fw.flush();
            fw.close();
        } catch (Exception E) {
            System.out.println("Error: " + E);
        }
    }

    
//
//    public void viewBook(String bookName) {
//        if (this.searchBook(bookName)) {
////            String arr[] = info.split(",");
////            String tempFile = "temp.csv";
//            File oldFile = new File(this.csvPath);
////            File newFile = new File(tempFile);
//            String publisher = "", name = "", author = "", subject = "", isbn = "", price = "", picPath = "";
//            try {
////                FileWriter fw = new FileWriter(tempFile, true);
////                BufferedWriter bw = new BufferedWriter(fw);
////                PrintWriter pw = new PrintWriter(bw);
//                Scanner x = new Scanner(new File(this.csvPath));
//                x.useDelimiter("[,\n]");
//                while (x.hasNext()) {
//                    publisher = x.next();
//                    name = x.next();
//                    author = x.next();
//                    subject = x.next();
//                    isbn = x.next();
//                    price = x.next();
//                    picPath = x.next();
//                    if (bookName.equalsIgnoreCase(name)) {
//                        System.out.println("Publisher: " + publisher + "\n" + "Name: " + name + "\n" + "Authir: " + author + "\n" + "Subject: " + subject + "\n" + "ISBN: " + isbn + "\n" + "Price: " + price + "\n" + "Picture Path: " + picPath);
//                        break;
//                    }
//                }
//                x.close();
//            } catch (Exception e) {
//                System.out.println("Error " + e);
//            }
//        }
//    }
//
}
