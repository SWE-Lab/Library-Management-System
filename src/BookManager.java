
import java.util.Vector;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 * 
 *
 * @author angshuman
 */
public class BookManager {

    private Vector<Book> bookArr;
    private Book obj;

    public BookManager(String jsonPath) {
        this.obj = new Book(jsonPath);
        this.bookArr = obj.getBookArray();
    }

    public void writeJSON() {
        obj.saveInfo();
    }
    
    public void writeCSV(){
        obj.saveInfoCSV();
    }

    public int getTotalBooks() {
        return this.bookArr.size();
    }

    public Vector<Book> getBookArr() {
        return this.bookArr;
    }

    public int getIndex(String bookName) {
        int i = 0;
        while (i < this.bookArr.size()) {
            Book book = this.bookArr.get(i);
            if (book.getName().equalsIgnoreCase(bookName)) {
                break;
            }
            i++;
        }
        if (i >= this.bookArr.size()) {
            return -1;
        } else {
            return i;
        }
    }

    public void incBook(int index) {
        long no = this.bookArr.get(index).getQuantity() + 1;
        this.bookArr.get(index).setQuantity(no);
    }

    public int decBook(int index) {
        if (this.bookArr.get(index).getQuantity() != 0) {
            long no = this.bookArr.get(index).getQuantity() - 1;
            this.bookArr.get(index).setQuantity(no);
        } else {
            return -1;
        }
        return 1;
    }

    public Book getBook(int index) {
        return this.bookArr.get(index);
    }

    public void addBook(String arr[]) {
//        String arr[] = inputString.split(",");
        Book book = new Book();
        book.setPublisher(arr[0]);
        book.setName(arr[1]);
        book.setAuthor(arr[2]);
        book.setSubject(arr[3]);
        book.setISBN(arr[4]);
        book.setPrice(new Long(arr[5]));
        book.setPicPath(arr[6]);
        book.setQuantity(new Long(arr[7]));
        book.setCode();
        this.bookArr.add(book);
    }

    public void deleteBook(int rownumber) {
        if (rownumber < 0 || rownumber > this.getTotalBooks()) {
            System.out.println("No such instance found\nDeletion Aborted");
        } else {
            this.bookArr.remove(rownumber);
            System.out.println("Deleted Successfully");
        }
    }

    public void updateBook(int index, String key, String value) {
        if (index < 0 || index > this.getTotalBooks()) {
            System.out.println("No such instance found\nUpdate Rejected");
        } else {
            Book book = this.bookArr.get(index);
            switch (key) {
                case "Publisher":
                    book.setPublisher(value);
                    break;
                case "Name":
                    book.setName(value);
                    break;
                case "Author":
                    book.setAuthor(value);
                    break;
                case "Subject":
                    book.setSubject(value);
                    break;
                case "ISBN":
                    book.setISBN(value);
                    break;
                case "Price":
                    book.setPrice(new Long(value));
                    break;
                case "Pic Path":
                    book.setPicPath(value);
                    break;
                case "Quantity":
                    book.setQuantity(new Long(value));
                    break;
            }
        }
    }

    public Book searchBook(String bookName) {
        int i = 0;
        while (i < this.getTotalBooks()) {
            Book book = this.bookArr.get(i);
            if (book.getName().equalsIgnoreCase(bookName)) {
                break;
            }
            i++;
        }
        if (i >= this.getTotalBooks()) {
            Book retBook = new Book();
            return retBook;
        } else {
            Book book = this.bookArr.get(i);
//            System.out.println("Match Found: ");
//            System.out.println("Book Code: " + book.getCode());
//            System.out.println("Publisher: " + book.getPublisher());
//            System.out.println("Book Name: " + book.getName());
//            System.out.println("Author: " + book.getAuthor());
//            System.out.println("Subject: " + book.getSubject());
//            System.out.println("ISBN: " + book.getISBN());
//            System.out.println("Price: " + book.getPrice());
//            System.out.println("Path of Picture: " + book.getPicPath());
//            System.out.println("Quantity: " + book.getQuantity());
            return book;
        }
    }
}
