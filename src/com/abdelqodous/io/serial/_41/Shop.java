package com.abdelqodous.io.serial._41;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static java.lang.System.out;

public class Shop {
    public static void main(String[] args) {

    Product p = new Product("Cookie", 3.99f);
    try {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("p.ser"))) {
            out.writeObject(p);
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("p.ser"))) {
            p = (Product)in.readObject();
        }
    } catch (Exception e) { e.printStackTrace(); }
        out.println(p);
    }
}
