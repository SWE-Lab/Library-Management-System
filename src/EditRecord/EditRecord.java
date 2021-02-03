/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EditRecord;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author hackme
 */
public class EditRecord {

    private static Scanner x;

    public static void main(String[] args) {
        String filepath = "records.csv";
//        String editTerm = "Publisher";
    int rownumber = 1;
        editRecord(filepath, rownumber);
    }

    public static void editRecord(String filepath, int rownumber) {
        String tempFile = "temp.csv";
        File oldFile = new File(filepath);
        File newFile = new File(tempFile);
        String publisher = "";
        String name = "";
        String author = "";
        String subject = "";
        String isbn = "";
        String price = "";
        String picPath = "";
        try {
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");
            int i = 0;
            while (x.hasNext()) {

                publisher = x.next();
                name = x.next();
                author = x.next();
                subject = x.next();
                isbn = x.next();
                price = x.next();
                picPath = x.next();
                if (i != rownumber) {
                    pw.println(publisher + "," + name + "," + author + "," + subject + "," + isbn + "," + price + "," + picPath);
                }
//             else {
//                    pw.println(publisher + "," + name + "," + author+","+subject+","+isbn+","+price+","+picPath);
//                }
                i++;
            }
            x.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File(filepath);
            newFile.renameTo(dump);
        } catch (Exception e) {
            System.out.println("Error " + e);
        }

    }
}
