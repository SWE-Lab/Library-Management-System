//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.PrintWriter;
//import java.util.Scanner;
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
///**
// *
// * @author angshuman
// */
//public class BookManager {
//
//    private String csvPath;
//
//    public BookManager(String csvPath) {
//        this.csvPath = csvPath;
//    }
//
//    public int getTotalBooks() {
//        int count = 0;
//        try {
//            File file = new File(this.csvPath);
//            FileReader reader = new FileReader(file);
//            BufferedReader infile = new BufferedReader(reader);
//            boolean done = false;
//            String line = "";
//            while (!done) {
//                line = infile.readLine();
//                if (line == null) {
//                    done = true;
//                } else {
//                    count++;
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("Error: " + e);
//        }
//        return count;
//    }
//
//    public void deleteBook(int rownumber) {
//        String tempFile = "temp.csv";
//        File oldFile = new File(this.csvPath);
//        File newFile = new File(tempFile);
//        String publisher = "", name = "", author = "", subject = "", isbn = "", price = "", picPath = "";
//        try {
//            FileWriter fw = new FileWriter(tempFile, true);
//            BufferedWriter bw = new BufferedWriter(fw);
//            PrintWriter pw = new PrintWriter(bw);
//            Scanner x = new Scanner(new File(this.csvPath));
//            x.useDelimiter("[,\n]");
//            int i = 0;
//            while (x.hasNext()) {
//                publisher = x.next();
//                name = x.next();
//                author = x.next();
//                subject = x.next();
//                isbn = x.next();
//                price = x.next();
//                picPath = x.next();
//                if (i != rownumber) {
//                    pw.println(publisher + "," + name + "," + author + "," + subject + "," + isbn + "," + price + "," + picPath);
//                }
//                i++;
//            }
//            x.close();
//            pw.flush();
//            pw.close();
//            oldFile.delete();
//            File dump = new File(this.csvPath);
//            newFile.renameTo(dump);
//        } catch (Exception e) {
//            System.out.println("Error " + e);
//        }
//
//    }
//
//    public void updateBook(int row, String info) {
//        String arr[] = info.split(",");
//        String tempFile = "temp.csv";
//        File oldFile = new File(this.csvPath);
//        File newFile = new File(tempFile);
//        String publisher = "", name = "", author = "", subject = "", isbn = "", price = "", picPath = "";
//        try {
//            FileWriter fw = new FileWriter(tempFile, true);
//            BufferedWriter bw = new BufferedWriter(fw);
//            PrintWriter pw = new PrintWriter(bw);
//            Scanner x = new Scanner(new File(this.csvPath));
//            x.useDelimiter("[,\n]");
//            int i = 0;
//            while (x.hasNext()) {
//                publisher = x.next();
//                name = x.next();
//                author = x.next();
//                subject = x.next();
//                isbn = x.next();
//                price = x.next();
//                picPath = x.next();
//                if (i != row) {
//                    pw.println(publisher + "," + name + "," + author + "," + subject + "," + isbn + "," + price + "," + picPath);
//                } else {
//                    pw.println(arr[0] + "," + arr[1] + "," + arr[2] + "," + arr[3] + "," + arr[4] + "," + arr[5] + "," + arr[6]);
//                }
//                i++;
//            }
//            x.close();
//            pw.flush();
//            pw.close();
//            oldFile.delete();
//            File dump = new File(this.csvPath);
//            newFile.renameTo(dump);
//        } catch (Exception e) {
//            System.out.println("Error " + e);
//        }
//
//    }
//
//    public boolean searchBook(String bookName) {
//        File oldFile = new File(this.csvPath);
//        String publisher = "", name = "", author = "", subject = "", isbn = "", price = "", picPath = "";
//        try {
//            Scanner x = new Scanner(new File(this.csvPath));
//            x.useDelimiter("[,\n]");
//            while (x.hasNext()) {
//                publisher = x.next();
//                name = x.next();
//                author = x.next();
//                subject = x.next();
//                isbn = x.next();
//                price = x.next();
//                picPath = x.next();
//                if (name.equals(bookName)) {
//                    return true;
//                }
//            }
//            x.close();
//        } catch (Exception e) {
//            System.out.println("Error " + e);
//        }
//        return false;
//    }
//
//    public void addBook(String inputString) {
//        try {
//            FileWriter fw = new FileWriter(this.csvPath, true);
//            BufferedWriter bw = new BufferedWriter(fw);
//            PrintWriter pw = new PrintWriter(bw);
//            Book obj = new Book(inputString);
//            String toSave = "";
//            toSave = obj.getPublisher() + ',' + obj.getName() + ',' + obj.getAuthor() + ',' + obj.getSubject() + ',' + obj.getISBN() + ',' + obj.getPrice() + ',' + obj.getPicPath() + ',' + obj.getQuantity();
//            pw.println(toSave);
//            pw.flush();
//            pw.close();
//        } catch (Exception E) {
//            System.out.println("Error: " + E);
//        }
//    }
//
//    public void viewBook(String bookName) {
//        if (this.searchBook(bookName)) {
////            String arr[] = info.split(",");
////            String tempFile = "temp.csv";
//            File oldFile = new File(this.csvPath);
////            File newFile = new File(tempFile);
//            String publisher = "", name = "", author = "", subject = "", isbn = "", price = "", picPath = "";
//            try {
////                FileWriter fw = new FileWriter(tempFile, true);
////                BufferedWriter bw = new BufferedWriter(fw);
////                PrintWriter pw = new PrintWriter(bw);
//                Scanner x = new Scanner(new File(this.csvPath));
//                x.useDelimiter("[,\n]");
//                while (x.hasNext()) {
//                    publisher = x.next();
//                    name = x.next();
//                    author = x.next();
//                    subject = x.next();
//                    isbn = x.next();
//                    price = x.next();
//                    picPath = x.next();
//                    if (bookName.equalsIgnoreCase(name)) {
//                        System.out.println("Publisher: " + publisher + "\n" + "Name: " + name + "\n" + "Authir: " + author + "\n" + "Subject: " + subject + "\n" + "ISBN: " + isbn + "\n" + "Price: " + price + "\n" + "Picture Path: " + picPath);
//                        break;
//                    }
//                }
//                x.close();
//            } catch (Exception e) {
//                System.out.println("Error " + e);
//            }
//        }
//    }
//
//}
