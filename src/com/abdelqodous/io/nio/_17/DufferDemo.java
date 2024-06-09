package com.abdelqodous.io.nio._17;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DufferDemo {
    public static void main(String[] args) throws IOException {
        char[] buffer = new char[8];
        int count = 0;
        try(FileReader in = new FileReader("C:\\exam\\in.txt");
            FileWriter out = new FileWriter("C:\\exam\\out.txt")) {
            while((count = in.read(buffer)) != -1) {
//                System.out.println(count);
                out.write(buffer);
            }
        }
    }
}
