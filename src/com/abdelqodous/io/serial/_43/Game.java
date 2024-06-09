package com.abdelqodous.io.serial._43;

public class Game extends Software {
    private int players;

    public Game (String title, int players) {
        super(title);
        this.players = players;
        System.out.println("Game");
    }

    public String toString() { return super.toString()+" "+players; }
}
