/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exp;

/**
 *
 * @author hackme
 */
import java.io.*;

/**
 * example filereader/writer for nullbeans.com
 */
public class NullbeansFileManager {


    /**
     * Reads the file in the given path into a byte array
     * @param path: Path to the file, including the file name. For example: "C:/myfolder/myfile.txt"
     * @return byte array of the file data
     * @throws IOException
     */
    public static byte[] readFile(String path) throws IOException {

        File file = new File(path);

        byte [] fileData = new byte[(int) file.length()];

        try(FileInputStream fileInputStream = new FileInputStream(file)) {
            fileInputStream.read(fileData);
        }

        return fileData;
    }

    /**
     * Writes a file with the given data into a file with the given path
     * @param path: Path to the file to be created, including the file name. For example: "C:/myfolder/myfile.txt"
     * @param data: byte array of the data to be written
     * @throws IOException
     */
    public static void writeFile(String path, byte [] data) throws IOException {

        try(FileOutputStream fileOutputStream = new FileOutputStream(path)) {
            fileOutputStream.write(data);
        }

    }

}