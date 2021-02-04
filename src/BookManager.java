
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 *
 *
 * @author angshuman
 */
public class BookManager {

    private BookArray bookArr;
//    private String jsonPath;

    public BookManager(String jsonPath) {
        BookArray ba = new BookArray(jsonPath);
        this.bookArr = ba;
    }

    public void writeJSON() {
        this.bookArr.saveInfo();
    }

    public int getTotalBooks() {
        return this.bookArr.getBookArraySize();
    }

    public void addBook(String inputString) {
        String arr[] = inputString.split(",");
        Book book = new Book();
        book.setPublisher(arr[0]);
        book.setName(arr[1]);
        book.setAuthor(arr[2]);
        book.setSubject(arr[3]);
        book.setISBN(arr[4]);
        book.setPrice(new Long(arr[5]));
        book.setPicPath(arr[6]);
        book.setQuantity(new Long(arr[7]));
        this.bookArr.getBookArray().add(book);
    }

    public void deleteBook(int rownumber) {
        if (rownumber < 0 || rownumber > this.getTotalBooks()) {
            System.out.println("No such instance found\nDeletion Aborted");
        } else {
            this.bookArr.getBookArray().remove(rownumber);
            System.out.println("Deleted Successfully");
        }
    }
//
    public void updateBook(int index, String key, String value) {
        if (index < 0 || index > this.getTotalBooks()) {
            System.out.println("No such instance found\nUpdate Rejected");
        } else {
            Book book = this.bookArr.getBookArray().get(index);
            switch(key){
                case "Publisher" : book.setPublisher(value); break;
            }
        }
    }
//
    public void searchBook(String bookName) {
        int i = 0;
        while (i < this.getTotalBooks()) {
            Book obj = this.bookArr.getBookArray().get(i);
            if (obj.getName().equalsIgnoreCase(bookName)) {
                break;
            }
            i++;
        }
        if (i >= this.getTotalBooks()) {
            System.out.println("No instance found.");
        } else {
            Book obj = this.bookArr.getBookArray().get(i);
            System.out.println("Match Found: ");
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
