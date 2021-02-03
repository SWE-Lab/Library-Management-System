/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExperimentJSON;

/**
 *
 * @author angshuman
 */
class Book {

    private String publisher;
    private String name;
    private String author;
    private String subject;
    private String isbn;
    private String price;
    private String picPath;
//    private long year;
//    private String[] authors;

    public Book() {
    }

    public Book(String publisher, String name, String author, String subject, String isbn, String price, String picPath) {
        this.publisher = publisher;
        this.name = name;
        this.author = author;
        this.subject = subject;
        this.isbn = isbn;
        this.price = price;
        this.picPath = picPath;
    }
}
