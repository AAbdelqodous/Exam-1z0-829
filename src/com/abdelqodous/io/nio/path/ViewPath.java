package com.abdelqodous.io.nio.path;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ViewPath {
    public static void main(String[] args) {
        /*Path path = Paths.get("C:\\dump\\land\\hippo\\harry.happy");
        System.out.println("the path name is: " + path);
        System.out.println("_______________ getNameCount() ________________");
        for (int i = 0; i < path.getNameCount(); i++) { // root name does not include in the list
            System.out.println("   Element " + i + " is: " +path.getName(i));
        }*/

        /*System.out.println("_______________ root ________________");
        Path root = Path.of("/");
        System.out.println(root.getNameCount()); // 0
//        System.out.println(root.getName(0)); // IllegalArgumentException*/

        /*System.out.println("_______________ subpath() ________________");
        System.out.println("path.subpath(0, 4): " + path.subpath(0, 4)); //path.subpath(0, 5) - IllegalArgumentException
        System.out.println("path.subpath(1, 4): " + path.subpath(1, 4)); //path.subpath(1, 1) - IllegalArgumentException
        System.out.println("path.subpath(2, 4): " + path.subpath(2, 4));
        System.out.println("path.subpath(3, 4): " + path.subpath(3, 4));*/

        /*System.out.println("_______________ printPathInformation(path) ________________");
        printPathInformation(path);
        System.out.println("_______________ printPathInformation(zoo) ________________");
        printPathInformation(Path.of("C:\\zoo"));*/

        /*System.out.println("_______________ path1.resolve(path2) - relative ________________");
        Path path1 = Path.of("/cats/../panther");
        Path path2 = Path.of("food");
        System.out.println(path1.resolve(path2));  // result:  /cats/../panther/food
        System.out.println(path2.resolve(path1));*/

        /*System.out.println("_______________ path3.resolve(\"uri\") - absolute ________________");
        Path path3 = Path.of("/turkey/food");
        Path path4 = Path.of("/tiger/cage");
        System.out.println(path3.resolve("/tiger/cage"));  // the same as: resolve(path4);  result: /tiger/cage   */

        /*System.out.println("_______________ relativizing - relative ________________");
        var path1 = Path.of("fish.txt");
        var path2 = Path.of("friendly/birds.txt");
        System.out.println(path1.relativize(path2)); //  result:   ..\friendly\birds.txt
        System.out.println(path2.relativize(path1)); //  result:   ..\..\fish.txt*/

        /*System.out.println("_______________ relativizing - absolute ________________");
        var path3 = Path.of("C:\\habitat");
        var path4 = Path.of("C:\\sanctuary\\raven\\poe.txt");
        System.out.println(path3.relativize(path4)); //  result:   ..\sanctuary\raven\poe.txt
        System.out.println(path4.relativize(path3)); //  result:   ..\..\..\habitat*/

        /*System.out.println("_______________ normalize() ________________");
        var path5 = Path.of("./armadillo/../shells.txt");
        System.out.println(path5.normalize()); // result:   shells.txt
        var path6 = Path.of("/cats/../panther/food");
        System.out.println(path6.normalize()); //  result: \panther\food
        Path path7 = Path.of("../../fish.txt");
        System.out.println(path7.normalize()); //  result:   ..\..\fish.txt*/

        /*System.out.println("_______________ create Directory / Directories ________________");
        try {
//            Files.createDirectory( Path.of("/bison/field")); // NoSuchFileException: \bison\field
            Files.createDirectories( Path.of("bison/field/pasture/green"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        /*System.out.println("_______________ copy File / Directory ________________");
        try {
            Files.copy(Paths.get("/panda/bamboo.txt"),
                        Paths.get("/panda-save/bamboo.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        /*System.out.println("_______________ copy File / IO stream ________________");
        try(FileInputStream is = new FileInputStream("source-data.txt")){
            Files.copy(is, Paths.get("/mammals/wolf.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        var file = Paths.get("source-data.txt");
        var directory = Paths.get("/enclosure");
        try {
            Files.copy(file, directory);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printPathInformation(Path path) {
        System.out.println("_______________ path elements ________________");
        System.out.println("path.getFileName(): " + path.getFileName());
        System.out.println("path.getRoot(): " + path.getRoot());
        Path currentParent = path;
//        System.out.println("start currentParent: " + currentParent);
        while( ( currentParent = currentParent.getParent()) != null){
            System.out.println("currentParent: " +currentParent);
        }
    }
}
