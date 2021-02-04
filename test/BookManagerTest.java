
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
///**
// *
// * @author angshuman
// */
public class BookManagerTest extends BookManager {

    public BookManagerTest(String jsonPath) {
        super(jsonPath);
    }

    public static void main(String[] args) {

        // Unit test to create a book manager object and check its functions.
        BookManager obj = new BookManager("dtb-array.json");

        // Get total number of books
        assert obj.getTotalBooks() == 22 : "Wrong Total number of Books";
        System.out.println("Total number of Books: " + obj.getTotalBooks());

        // Add new Book
        int oldNo = obj.getTotalBooks();
        obj.addBook("Evening,morning,night,ENGLISH,978-1-56619-909-4,2134,/home/angshuman/Pictures/Screenshot_20210104_110819.png,563");
        assert obj.getTotalBooks() == oldNo + 1 : "Book not Added";
        assert obj.bookArr.getBook(oldNo).getPublisher().equals("Evening") : "Wrong Book added";
//        System.out.println("New Book added");

        // Delete Book
        String oldPub = obj.bookArr.getBook(7).getPublisher();
        obj.deleteBook(7);
        String newPub = obj.bookArr.getBook(7).getPublisher();
        assert obj.getTotalBooks() == oldNo : "Wrong Index";
        assert !(oldPub.equals(newPub)) : "Not Deleted Proper Book";
        
        // Update Book
        int index = 0;
        obj.updateBook(index, "Name", "fgf");
        String newName = obj.bookArr.getBook(index).getName();
        assert newName.equals("fgf") : "Wrong Instance Updated";
        
        //Search Book
        obj.searchDisplayBook("fgf");
//        assert obj.searchDisplayBook("fgf") : "Wrong Search Result";

        // Write back to json file
        obj.writeJSON();
//        System.out.println("Update Book details & Search book");
    }
}
