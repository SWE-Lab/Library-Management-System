
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

//    public Book addBook(String inputString) {
//        String arr[] = inputString.split(",");
//        JSONObject obj = new JSONObject();
//        obj.put("Publisher", arr[0]);
//        obj.put("Name", arr[1]);
//        obj.put("Author", arr[2]);
//        obj.put("Subject", arr[3]);
//        obj.put("ISBN", arr[4]);
//        obj.put("Price", new Long(arr[5]));
//        obj.put("PicPath", arr[6]);
//        obj.put("Quantity", new Long(arr[7]));
//        this.jsonArray.add(obj);
//        Book book = new Book(this.jsonArray, this.jsonArray.size() - 1);
//        return book;
//    }
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

    public static void main(String a[]) {
        BookArray ba = new BookArray("dtb-array.json");
        System.out.println(ba.getBookArraySize());
    }
}
