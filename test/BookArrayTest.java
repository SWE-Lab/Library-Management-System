
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 *
 *
 * @author hackme
 */
public class BookArrayTest {

    public static void main(String args[]) {
        BookArray obj = new BookArray("dtb-array.json");
        int i = 0;
        long a = 0;
        Book book1 = obj.getBook(21);
        assert book1.getPrice() == 213414 : "Wrong Price";
        while (i < obj.getBookArraySize()) {
            Book book = obj.getBook(i);
            System.out.println("Book Code: " + book.getCode());
            System.out.println("Publisher: " + book.getPublisher());
            System.out.println("Book Name: " + book.getName());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Subject: " + book.getSubject());
            System.out.println("ISBN: " + book.getISBN());
            System.out.println("Price: " + book.getPrice());
            System.out.println("Path of Picture: " + book.getPicPath());
            System.out.println("Quantity: " + book.getQuantity());
            a = book.getPrice();
            i++;
        } 
    }
}
