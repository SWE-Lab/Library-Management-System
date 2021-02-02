
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
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

    private String csvPath;

    public BookManager(String csvPath) {
        this.csvPath = csvPath;
    }

    public int getTotalBooks() {
        int count = 0;
        try {
            File file = new File(this.csvPath);
            FileReader reader = new FileReader(file);
            BufferedReader infile = new BufferedReader(reader);
            boolean done = false;
            String line = "";
            while (!done) {
                line = infile.readLine();
                if (line == null) {
                    done = true;
                } else {
                    count++;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return count;
    }

    public void deleteBook(int rowNumber) {
        try{
        CSVReader reader2 = new CSVReader(new FileReader(this.csvPath));
        System.out.println(reader2);
//        List<String[]>allElements = reader2.readAll();
//        allElements.remove(rowNumber);
//        FileWriter sw = new FileWriter(this.csvPath);
//        CSVWriter writer = new CSVWriter(sw);
//        writer.writeAll(allElements);
//        writer.close();
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }

    public void saveInfo(String inputString) {
        try {
            FileWriter fw = new FileWriter(this.csvPath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            Book obj = new Book(inputString);
            String toSave = "";
            toSave = obj.getPublisher() + ',' + obj.getName() + ',' + obj.getAuthor() + ',' + obj.getSubject() + ',' + obj.getISBN() + ',' + obj.getPrice() + ',' + obj.getPicPath() + ',' + obj.getQuantity();
            pw.println(toSave);
            pw.flush();
            pw.close();
        } catch (Exception E) {
            System.out.println("Error: " + E);
        }
    }

}
