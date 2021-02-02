
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

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

    private String publisher;
    private String name;
    private String author;
    private String subject;
    private String isbn;
    private int price;
    private String picPath;
    private String info[] = {"", "", "", "", "", "", ""};

    public Book(String line) {
        this.info = line.trim().split(",");
        this.publisher = this.info[0];
        this.name = this.info[1];
        this.author = this.info[2];
        this.subject = this.info[3];
        this.isbn = this.info[4];
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

    public void saveInfo(String filepath) {
        try {
            FileWriter fw = new FileWriter(filepath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            String toSave = "";
            toSave = this.publisher + ',' + this.name + ',' + this.author + ',' + this.subject + ',' + this.isbn + ',' + this.price + ',' + this.picPath;
            pw.println(toSave);
            pw.flush();
            pw.close();
        } catch (Exception E) {
            System.out.println("Error");
        }
    }

    // To read:
    // Book obj = new Book(string_to_read);
    // To write:
    // Book obj = new Book(string_to_insert);
    // obj.saveInfo(path_to_csv);
    public static void main(String a[]) {
        // Unit test to check write to csv
//        Book obj = new Book("Publisher,debanjan,author,ENGLISH,978-1-56619-909-4,213414,/home/angshuman/Pictures/Screenshot_20210104_110819.png");
//        obj.saveInfo("dtb.csv");
// Unit test to check read from csv
//            try {
//            String filename = "dtb.csv";
//            File file = new File(filename);
//            FileReader reader = new FileReader(file);
//            BufferedReader infile = new BufferedReader(reader);
//            String line = "";
//            boolean done = false;
//            while (!done) {
//                line = infile.readLine();
//                Book obj = new Book(line);
//                if (line == null) {
//                    done = true;
//                } else {
//                    System.out.println(obj.name);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.exit(1);
//        }
    }
}
