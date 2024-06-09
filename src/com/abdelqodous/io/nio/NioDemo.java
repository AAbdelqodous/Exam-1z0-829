package com.abdelqodous.io.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class NioDemo {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("C:\\files\\nio\\nioFile");

        if (Files.exists( path)){
            System.out.println( path.toAbsolutePath());
            System.out.println( Files.isDirectory( path));
            System.out.println( path.getParent());

            if (Files.isRegularFile( path)){
                System.out.println( Files.size( path));
                System.out.println( Files.getLastModifiedTime( path));
            }else {
                try( Stream<Path> pathStream = Files.list(path)) {
                    pathStream.forEach( p -> System.out.println("  " + p.getName(3)));
                }
            }
        }else {
            System.out.println("File not found!");
        }
    }
}
