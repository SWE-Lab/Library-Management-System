/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exp;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

/**
 *
 * @author hackme
 */
public class ReadJSON {

    // Java program to read JSON from a file 

        public static void main(String[] args) throws Exception {
            // parsing file "JSONExample.json" 
            Object obj = new JSONParser().parse(new FileReader("dtb.json"));

            // typecasting obj to JSONObject 
            JSONObject jo = (JSONObject) obj;

            // getting firstName and lastName 
            String publisher = (String) jo.get("Publisher");
            String name = (String) jo.get("Name");
            String author = (String) jo.get("Author");
            String subject = (String) jo.get("Subject");
            String isbn = (String) jo.get("ISBN");
            String price = (String) jo.get("Price");
            String picPath = (String) jo.get("PicPath");

            System.out.println("Publisher: " + publisher + "\n" + "Name: " + name + "\n" + "Author: " + author + "\n" + "Subject: " + subject + "\n" + "ISBN: " + isbn + "\n" + "Price: " + price + "\n" + "Picture Path: " + picPath);

//            // getting age 
//            long age = (long) jo.get("age");
//            System.out.println(age);

            // getting address 
//            Map address = ((Map) jo.get("address"));

            // iterating address Map 
//            Iterator<Map.Entry> itr1 = address.entrySet().iterator();
//            while (itr1.hasNext()) {
//                Map.Entry pair = itr1.next();
//                System.out.println(pair.getKey() + " : " + pair.getValue());
//            }
//
//            // getting phoneNumbers 
//            JSONArray ja = (JSONArray) jo.get("phoneNumbers");
//
//            // iterating phoneNumbers 
//            Iterator itr2 = ja.iterator();

//            while (itr2.hasNext()) {
//                itr1 = ((Map) itr2.next()).entrySet().iterator();
//                while (itr1.hasNext()) {
//                    Map.Entry pair = itr1.next();
//                    System.out.println(pair.getKey() + " : " + pair.getValue());
//                }
//            }
        
    }

}
