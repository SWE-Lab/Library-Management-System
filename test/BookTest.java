
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hackme
 */
public class BookTest {

    public static void main(String args[]) {
        Book obj = new Book("dtb-array.json",7);
        System.out.println("Book Code: " + obj.getCode());
        System.out.println("Publisher: " + obj.getPublisher());
        System.out.println("Book Name: " + obj.getName());
        System.out.println("Author: " + obj.getAuthor());
        System.out.println("Subject: " + obj.getSubject()); 
        System.out.println("ISBN: " + obj.getISBN());
        System.out.println("Price: " + obj.getPrice());
        System.out.println("Path of Picture: " + obj.getPicPath());
        System.out.println("Quantity: " + obj.getQuantity());
    }
}
