package com.abdelqodous.io.serial._42;

public class LuxuryCar extends Car{
    int flag_HHC;
    public LuxuryCar (String name, int flag_HHC) {
        super(name);
        this.flag_HHC = flag_HHC;
    }
    public String toString() {
        return name + ": + flag_HHC";
    }
}
