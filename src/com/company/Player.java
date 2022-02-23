package com.company;

public class Player {
    private String name;
    private Character symbol;
    public Player(String name, Character symbol){
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public Character getSymbol() {
        return symbol;
    }

    public void introduce(){
        System.out.println("Name: " + name + " Symbol: " + symbol);
    }
    public void displayWinningMessage(){
        System.out.println("Name: " + name + " Symbol: " + symbol + " has won the game");
    }
}
