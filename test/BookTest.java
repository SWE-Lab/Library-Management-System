
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hackme
 */
public class BookTest {

    public static void main(String a[]) {
// Unit test to check read from csv
//        Book obj = new Book("Publisher,debanjan,author,ENGLISH,978-1-56619-909-4,213414,/home/angshuman/Pictures/Screenshot_20210104_110819.png,52");
//        System.out.println(obj.getQuantity());
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
                    Book obj = new Book(line);
                    System.out.println(obj.getAuthor());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
