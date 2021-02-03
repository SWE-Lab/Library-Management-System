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
        // Unit test to check write to csv
        BookManager obj = new BookManager("dtb-array.json");
        //     obj.addBook("Publisher,debanjan,author,ENGLISH,978-1-56619-909-4,2134,/home/angshuman/Pictures/Screenshot_20210104_110819.png,563");
        System.out.println(obj.getTotalBooks());
        //  obj.deleteBook(0);
        obj.updateBook(1, "Publisher", "44");
//        System.out.println(obj.searchBook("/home/hackme/Deleted_MetadataIMG_2021026_200915.jpg"));
        //obj.viewBook("wwwww");
    }
}
