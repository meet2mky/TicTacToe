package com.company;

public class Main {

    public static void main(String[] args) {
            Board board = new Board("Me", "You");
            board.Player1Move(0,0);
            board.Player2Move(1,0);
            board.Player1Move(0,1);
            board.Player2Move(1,1);
            board.Player1Move(0,2);
            board.Player2Move(1,2);
            board.Player1Move(0,2);
    }
}
