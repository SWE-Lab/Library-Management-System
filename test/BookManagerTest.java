///*
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

    public static void main(String[] args) {

        // Unit test to create a book manager object and check its functions.
        BookManager obj = new BookManager("dtb-array.json");

        // Get total number of books
//        System.out.println(obj.getTotalBooks());

        // Add new Book
//        obj.addBook("Evening,morning,night,ENGLISH,978-1-56619-909-4,2134,/home/angshuman/Pictures/Screenshot_20210104_110819.png,563");
        
        // Delete Book
//        obj.deleteBook(0);
        
        // Update Book
//        obj.updateBook(0, "Publisher", "3434");
        
        //Search Book
        obj.searchBook("sher555");

        // Write back to json file
        obj.writeJSON();
    }
}
