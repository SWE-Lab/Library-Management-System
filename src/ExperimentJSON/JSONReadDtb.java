/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExperimentJSON;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author angshuman
 */
public class JSONReadDtb {

    public static void main(String[] args) throws Exception {
        
        Object jo = new JSONParser().parse(new FileReader("dtb-array.json"));
        JSONArray ja = (JSONArray) jo;
        ja.remove(0);
        
        JSONObject joi = (JSONObject)ja.get(0);
        System.out.println(joi);
        // typecasting obj to JSONObject 
//		JSONObject jo = (JSONObject) obj; 

//        Iterator itr2 = jap.iterator();
//        while (itr2.hasNext()) {
//            // getting all attributes 
//            JSONObject jo = (JSONObject) itr2.next(); 
//            String publisher = (String) jo.get("Publisher");
//            String name = (String) jo.get("Name");
//            String author = (String) jo.get("Author");
//            String isbn = (String) jo.get("ISBN");
//            String subject = (String) jo.get("Subject");
//            int price = (int) jo.get("Price");
//            String picPath = (String) jo.get("PicPath");
//
//            System.out.println(publisher);
//            System.out.println(name);
//            System.out.println(author);
//            System.out.println(isbn);
//            System.out.println(subject);
//            System.out.println(price);
//            System.out.println(picPath);
//        }
////         getting address 
//		Map address = ((Map)jo.get("address")); 
////         iterating address Map 
//		Iterator<Map.Entry> itr1 = address.entrySet().iterator(); 
//		while (itr1.hasNext()) { 
//			Map.Entry pair = itr1.next(); 
//			System.out.println(pair.getKey() + " : " + pair.getValue()); 
//		} 
////         getting phoneNumbers 
//		JSONArray ja = (JSONArray) jo.get("phoneNumbers"); 
		
		// iterating phoneNumbers 
//		Iterator itr2 = ja.iterator(); 
//		
//		while (itr2.hasNext()) 
//		{ 
//			itr1 = ((Map) itr2.next()).entrySet().iterator(); 
//			while (itr1.hasNext()) { 
//				Map.Entry pair = itr1.next(); 
//				System.out.println(pair.getKey() + " : " + pair.getValue()); 
//			} 
//		} 
    }
}
