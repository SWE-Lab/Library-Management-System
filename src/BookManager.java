
import java.io.BufferedWriter;
import java.io.FileWriter;
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
public class BookManager {
    private int noOfBooks;
    private int noOf;
    
    public BookManager(String csvPath){
        
    }
    public void saveInfo(String filepath) {
        try {
            FileWriter fw = new FileWriter(filepath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            String toSave = "";
            toSave = Book.getPublisher() + ',' + this.name + ',' + this.author + ',' + this.subject + ',' + this.isbn + ',' + this.price + ',' + this.picPath;
            pw.println(toSave);
            pw.flush();
            pw.close();
        }
        catch (Exception E) {
            System.out.println("Error");
        }
    }
//    public static void main(String[] args){
//        // Unit test to check write to csv
//        BookManager obj = new BookManager("Publisher,debanjan,author,ENGLISH,978-1-56619-909-4,213414,/home/angshuman/Pictures/Screenshot_20210104_110819.png");
//        obj.saveInfo("dtb.csv");
//    }
}
