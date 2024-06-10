package com.abdelqodous.io.nio._17;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferDemo {
    public static void main(String[] args) throws IOException {
        char[] buffer = new char[8];
        int count = 0;
        try(FileReader in = new FileReader("C:\\dump\\in.txt");
            FileWriter out = new FileWriter("C:\\dump\\out.txt")) {
            while((count = in.read(buffer)) != -1) {
//                System.out.println(count);
                out.write(buffer);
            }
        }
    }
}
