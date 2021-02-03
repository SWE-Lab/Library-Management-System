import java.io.FileReader;
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
public class Book {

    private String code;
    private long quantity;
    private String publisher;
    private String name;
    private String author;
    private String subject;
    private String isbn;
    private long price;
    private String picPath;

    public Book(String jsonPath, int index) {
        try {
            Object jo = new JSONParser().parse(new FileReader(jsonPath));
            JSONArray ja = (JSONArray) jo;
            JSONObject joi = (JSONObject) ja.get(index);
            this.publisher = (String) joi.get("Publisher");
            this.name = (String) joi.get("Name");
            this.author = (String) joi.get("Author");
            this.subject = (String) joi.get("Subject");
            this.isbn = (String) joi.get("ISBN");
            this.price = (long) joi.get("Price");
            this.picPath = (String) joi.get("PicPath");
            this.quantity = (long) joi.get("Quantity");
            this.code = this.isbn.substring(12, 15) + this.author.substring(0, 1).toUpperCase() + this.name.substring(0, 1).toUpperCase();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getPublisher() {
        return this.publisher;
    }

    public String getName() {
        return this.name;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getISBN() {
        return this.isbn;
    }

    public long getPrice() {
        return this.price;
    }

    public String getPicPath() {
        return this.picPath;
    }

    public long getQuantity() {
        return this.quantity;
    }

    public String getCode() {
        return this.code;
    }
}
