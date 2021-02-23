package LMS_Test;


import LMS.Book;
import LMS.BookManager;


// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
///**
// *
// * @author angshuman
// */
public class BookManagerTest {

//    public BookManagerTest(String jsonPath) {
//        super(jsonPath);
//    }
    public static void main(String[] args) {

        // Unit test to create a book manager object and check its functions.
        BookManager obj = new BookManager("dtb-array.json");

        // Get total number of books
        System.out.println(obj.getTotalBooks());
        assert obj.getTotalBooks() == 22 : "Wrong Total number of Books";
        System.out.println("Total number of Books: " + obj.getTotalBooks());

        // Add new Book
        int oldNo = obj.getTotalBooks();
//        obj.addBook("Evening,morning,night,ENGLISH,978-1-56619-909-4,2134,/home/angshuman/Pictures/Screenshot_20210104_110819.png,563");
        assert obj.getTotalBooks() == oldNo + 1 : "Book not Added";
        assert obj.getBook(oldNo).getPublisher().equals("Evening") : "Wrong Book added";
//        System.out.println("New Book added");

        // Delete Book
        String oldPub = obj.getBook(7).getPublisher();
        obj.deleteBook(7);
        String newPub = obj.getBook(7).getPublisher();
        assert obj.getTotalBooks() == oldNo : "Wrong Index";
        assert !(oldPub.equals(newPub)) : "Not Deleted Proper Book";

        // Update Book
        int index = 0;
        obj.updateBook(index, "Name", "fsgf");
        String newName = obj.getBook(index).getName();
        assert newName.equals("fsgf") : "Wrong Instance Updated";

        //Search Book
        Book book = obj.searchBook("fsgf");
        assert book.getAuthor().equals("fsgs") : "Wrong Search Result";
        System.out.println("Book Code: " + book.getCode());
        System.out.println("Publisher: " + book.getPublisher());
        System.out.println("Book Name: " + book.getName());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Subject: " + book.getSubject());
        System.out.println("ISBN: " + book.getISBN());
        System.out.println("Price: " + book.getPrice());
        System.out.println("Path of Picture: " + book.getPicPath());
        System.out.println("Quantity: " + book.getQuantity());

        // Write back to json file
        obj.writeJSON();
//        System.out.println("Update Book details & Search book");
    }
}
