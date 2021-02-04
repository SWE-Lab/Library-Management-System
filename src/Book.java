

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author angshuman
 */
public class Book {

    private int code;
    private long quantity;
    private String publisher;
    private String name;
    private String author;
    private String subject;
    private String isbn;
    private int price;
    private String picPath;
    private String info[] = {"", "", "", "", "", "", "", ""};

    public Book(String line) {
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ',') {
                count++;
            }
        }
        this.info = line.trim().split(",");
        this.publisher = this.info[0];
        this.name = this.info[1];
        this.author = this.info[2];
        this.subject = this.info[3];
        this.isbn = this.info[4];
        this.code = Integer.parseInt(this.isbn.substring(0, 3));
        if (count == 7) {
            this.quantity = Integer.parseInt(this.info[7]);
        } else {
            this.quantity = 1;
        }
        this.price = Integer.parseInt(this.info[5]);
        this.picPath = this.info[6];
    }
    public String getPublisher() {
        return this.publisher;
    }
    public String getName() {
        return this.name;
    }
    public String getAuthor() {
        return this.author;
    }
    public String getSubject() {
        return this.subject;
    }
    public String getISBN() {
        return this.isbn;
    }
    public int getPrice() {
        return this.price;
    }
    public String getPicPath() {
        return this.picPath;
    }
    public long getQuantity() {
        return this.quantity;
    }
    public Integer getCode() {
        return this.code;
    }
}