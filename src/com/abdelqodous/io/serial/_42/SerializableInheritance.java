package com.abdelqodous.io.serial._42;

import java.io.*;

public class SerializableInheritance {
    public static void main(String[] args) throws IOException, ClassNotFoundException { // line n2
        Car b= new LuxuryCar ("Wagon", 200);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("car.ser"));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("car.ser"));) {
            oos.writeObject(b);
            System.out.println((Car) (ois.readObject()));
        }
    }
}
