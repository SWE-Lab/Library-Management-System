
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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

    private javax.swing.JFrame jf = new javax.swing.JFrame();

    private String csvPath;
//    jTable2 = new javax.swing.JTable();

    public BookManager(String csvPath) {
        this.csvPath = csvPath;
        this.jf.setVisible(false);
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
        try {
           
//            javax.swing.JTable jTable2 = new javax.swing.JTable();
//            jTable2.setBackground(new java.awt.Color(31, 36, 42));
//            jTable2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(169, 224, 49), 2, true));
//            jTable2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
//            jTable2.setForeground(new java.awt.Color(169, 224, 49));
//            DefaultTableModel csvData = new DefaultTableModel() {
//                boolean[] canEdit = new boolean[]{
//                    false, false, false, true
//                };
//
//                public boolean isCellEditable(int rowIndex, int columnIndex) {
//                    return canEdit[columnIndex];
//                }
//            };
//            String filename = "read.csv";
//            File file = new File(filename);
//            FileReader reader = null;
//            try {
//                reader = new FileReader(file);
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//                System.exit(1);
//            }
//            csvData.addColumn("Book Code");
//            csvData.addColumn("List of Book");
//            csvData.addColumn("Author Name");
//            csvData.addColumn("Quantity");
//            csvData.addColumn("1");
//            csvData.addColumn("2");
//            csvData.addColumn("3");
//            BufferedReader infile = new BufferedReader(reader);
//            String line = "";
//            try {
//                boolean done = false;
//                while (!done) {
//                    line = infile.readLine();
//                    if (line == null) {
//                        done = true;
//                    } else {
//                        String[] tokens = line.trim().split(",");
//                        csvData.addRow(tokens);
//                    }
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//                System.exit(1);
//            }
//            jTable2.setModel(csvData);
//            //jTable2.setEditingColumn(3);
//            csvData.removeRow(rowNumber);
//            this.jf.add(jTable2);
//
//            File file2 = new File(this.csvPath);
//            try {
//                FileWriter fw = new FileWriter(file2);
//                BufferedWriter bw = new BufferedWriter(fw);
//
//                for (int i = 0; i < jTable2.getRowCount(); i++) {//rows
//                    for (int j = 0; j < jTable2.getColumnCount(); j++) {//column
//                        if (j == (jTable2.getColumnCount() - 1)) {
//                            bw.write(jTable2.getValueAt(i, j).toString());
//                        } else {
//                            bw.write(jTable2.getValueAt(i, j).toString() + ",");
//                        }
//
//                    }
//                    bw.newLine();
//                }
//                bw.close();
//                fw.close();
//            } catch (IOException ex) {
////            Logger.getLogger(JTable_import_and_export_to_text_file.class.getName()).log(Level.SEVERE, null, ex);
//            }

//            File file = new File(this.csvPath);
//            FileReader reader = new FileReader(file);
//            BufferedReader infile = new BufferedReader(reader);
//            String line = "";
//            boolean done = false;
//            while (!done) {
//                line = infile.readLine();
//                if (line == null) {
//                    done = true;
//
//                } else {
//                    Book obj = new Book(line);
//                    System.out.println(obj.getAuthor());
//                     line = line.replace(obj.getAuthor() , "");
//                     
//                }
//            fr.close();
//            fw.close();
        } catch (Exception e) {
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
