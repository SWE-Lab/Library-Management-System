
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Vector;
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
public class BookArray {

    private Vector<Book> bookArray = new Vector<Book>();
    private JSONArray jsonArray;
    private String jsonPath;

    BookArray(String jsonPath) {
        this.jsonPath = jsonPath;
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

    public int getBookArraySize() {
        return this.bookArray.size();
    }

    public Book getBook(int index) {
        return this.bookArray.get(index);
    }

    public void saveInfo() {
        try {
            int i = 0;
            JSONArray jaNew = new JSONArray();
            while (i < this.getBookArraySize()) {
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
}
