
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
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
public class Book {

    private String jsonPath;
    private Vector<Book> bookArray = new Vector<Book>();
    private JSONArray jsonArray;
    private String code;
    private long quantity;
    private String publisher;
    private String name;
    private String author;
    private String subject;
    private String isbn;
    private long price;
    private String picPath;

    public Book() {
        this.publisher = "";
        this.name = "";
        this.author = "";
        this.subject = "";
        this.isbn = "";
        this.price = 0;
        this.picPath = "";
        this.quantity = 0;
        this.code = "";
    }

    public Book(String jsonPath) {
        this.jsonPath = jsonPath;
        this.createBookArray();
    }

    public Book(JSONArray jsonArray, int index) {
        JSONObject joi = (JSONObject) jsonArray.get(index);
        this.publisher = (String) joi.get("Publisher");
        this.name = (String) joi.get("Name");
        this.author = (String) joi.get("Author");
        this.subject = (String) joi.get("Subject");
        this.isbn = (String) joi.get("ISBN");
        this.price = (long) joi.get("Price");
        this.picPath = (String) joi.get("PicPath");
        this.quantity = (long) joi.get("Quantity");
        this.code = this.isbn.substring(12, 15) + this.author.substring(0, 1).toUpperCase() + this.name.substring(0, 1).toUpperCase();
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


    public void setPublisher(String input) {
        this.publisher = input;
    }

    public void setName(String input) {
        this.name = input;
    }

    public void setAuthor(String input) {
        this.author = input;
    }

    public void setSubject(String input) {
        this.subject = input;
    }

    public void setISBN(String input) {
        this.isbn = input;
    }

    public void setPrice(long input) {
        this.price = input;
    }

    public void setPicPath(String input) {
        this.picPath = input;
    }

    public void setQuantity(long input) {
        this.quantity = input;
    }

    public void setCode(){
        this.code = this.isbn.substring(12, 15) + this.author.substring(0, 1).toUpperCase() + this.name.substring(0, 1).toUpperCase();
    }
    // For Creating and accessing book array
    private void createBookArray() {
        try {
            Object jo = new JSONParser().parse(new FileReader(this.jsonPath));
            this.jsonArray = (JSONArray) jo;
            int i = 0;
            while (i < this.jsonArray.size()) {
                Book book = new Book(this.jsonArray, i);
                this.bookArray.add(book);
                i++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Vector<Book> getBookArray() {
        return this.bookArray;
    }

    public void saveInfo() {
        try {
            int i = 0;
            JSONArray jaNew = new JSONArray();
            while (i < this.bookArray.size()) {
                Book book = this.bookArray.get(i);
                JSONObject obj = new JSONObject();
                obj.put("Publisher", book.getPublisher());
                obj.put("Name", book.getName());
                obj.put("Author", book.getAuthor());
                obj.put("Subject", book.getSubject());
                obj.put("ISBN", book.getISBN());
                obj.put("Price", book.getPrice());
                obj.put("PicPath", book.getPicPath());
                obj.put("Quantity", book.getQuantity());
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
    
    public void saveInfoCSV(){
        String tempFile = "data.csv";
        Vector<Book> vb = this.bookArray;
        File f = new File(tempFile);
        if (f.exists()) {
            f.delete();
        }
        File newFile = new File(tempFile);
        try {
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            int i = 0;
            pw.println("BookCode" + "," + "Publisher" + "," + "Name" + "," + "Author" + "," + "Subject" + "," + "ISBN" + "," + "Price" + "," + "PicPath" + "," + "Quantity");
            while (this.bookArray.size() > i) {
                Book book = vb.get(i);
                pw.println(book.getCode() + "," + book.getPublisher() + "," + book.getName() + "," + book.getAuthor() + "," + book.getSubject() + "," + book.getISBN() + "," + book.getPrice() + "," + book.getPicPath() + "," + book.getQuantity());
                i++;
            }
            pw.flush();
            pw.close();
            File dump = new File(tempFile);
            newFile.renameTo(dump);
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }
}
