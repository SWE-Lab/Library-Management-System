
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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

    private int code;
    private int quantity;
    private String publisher;
    private String name;
    private String author;
    private String subject;
    private String isbn;
    private int price;
    private String picPath;
    private String info[] = {"", "", "", "", "", "", "", ""};

    public Book(String line) {
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ',') {
                count++;
            }
        }
        this.info = line.trim().split(",");
        this.publisher = this.info[0];
        this.name = this.info[1];
        this.author = this.info[2];
        this.subject = this.info[3];
        this.isbn = this.info[4];
        this.code = Integer.parseInt(this.isbn.substring(0, 3));
//        for(int i=0;i<this.info.length; i++){
//        System.out.println(this.info[i]);
//        }
//        System.out.println(this.info.length);
        if (count == 7) {
            this.quantity = Integer.parseInt(this.info[7]);
        } else {
            this.quantity = 1;
        }
        //this.quantity = (this.info[7]!="") ? Integer.parseInt(this.info[7]) : 1;
        this.price = Integer.parseInt(this.info[5]);
        this.picPath = this.info[6];
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

    public int getPrice() {
        return this.price;
    }

    public String getPicPath() {
        return this.picPath;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public Integer getCode() {
        return this.code;
    }

// To read:
    // Book obj = new Book(string_to_read);
    // To write:
    // Book obj = new Book(string_to_insert);
    // obj.saveInfo(path_to_csv);
    public static void main(String a[]) {
// Unit test to check read from csv
        Book obj = new Book("Publisher,debanjan,author,ENGLISH,978-1-56619-909-4,213414,/home/angshuman/Pictures/Screenshot_20210104_110819.png,52");
        System.out.println(obj.quantity);
        try {
            String filename = "dtb.csv";
            File file = new File(filename);
            FileReader reader = new FileReader(file);
            BufferedReader infile = new BufferedReader(reader);
            String line = "";
            boolean done = false;
            while (!done) {
                line = infile.readLine();
                if (line == null) {
                    done = true;

                } else {
                    //Book obj = new Book(line);
                    //System.out.println(obj.quantity);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
