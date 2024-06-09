package com.abdelqodous.io.serial._42;

import java.io.Serializable;

public class Car implements Serializable {
    private static long serialVersionUID = 454L;
    String name;
    public Car(String name) { this.name = name; }
}
