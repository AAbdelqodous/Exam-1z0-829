package com.abdelqodous.io.legacyio;

import java.io.File;

public class FileDemo {
    public static void main(String[] args) {
        File file = new File("C:\\files\\legacy\\myFile.txt");

        if ( file.exists()){
            System.out.println( file.getAbsolutePath());
            System.out.println( file.isDirectory());
            System.out.println( file.getParent());

            if ( file.isFile()){
                System.out.println( file.length());
                System.out.println( file.lastModified());
            }else {
                for (File subFile : file.listFiles()){
                    System.out.println( subFile.getName());
                }
            }
        }else {
            System.out.println("File not found!");
        }
    }
}
