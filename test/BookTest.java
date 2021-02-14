
import java.util.Vector;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 *
 *
 * @author hackme
 */
public class BookTest {

    public static void main(String args[]) {
        Book obj = new Book("dtb-array.json");
        Vector<Book> bookArr = obj.getBookArray();
        
        // Get total number of books
        assert bookArr.size() == 22 : "Wrong Total number of Books";
        System.out.println("Total number of Books: " + bookArr.size());
        
        Book book1 = bookArr.get(21);
        assert book1.getPrice() == 2134 : "Wrong Price";
        
        int i = 0;
        while (i < bookArr.size()) {
            Book book = bookArr.get(i);
            System.out.println("Book Code: " + book.getCode());
            System.out.println("Publisher: " + book.getPublisher());
            System.out.println("Book Name: " + book.getName());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Subject: " + book.getSubject());
            System.out.println("ISBN: " + book.getISBN());
            System.out.println("Price: " + book.getPrice());
            System.out.println("Path of Picture: " + book.getPicPath());
            System.out.println("Quantity: " + book.getQuantity());
            i++;
        } 
    }
}
