package com.company;

public class Board {
    private final int SIZE = 3;
    private final int MAX_MOVES = 6;
    private int movesLeft;
    private static Character board[][];
    private Player player1;
    private Player player2;
    private Player lastPlayer;
    public Board(String name1, String name2) {
        board = new Character[SIZE][SIZE];
        player1 = new Player(name1,'X');
        player2 = new Player(name2,'Y');
        startNewGame();
    }
    public Board(){
        this("Default0","Default1");
    }
    private void greet(){
        System.out.println("---------Tick-Tac-Toe-------");
        System.out.println("Player 1");
        player1.introduce();
        System.out.println("Player 2");
        player2.introduce();
    }
    private void startNewGame(){
        lastPlayer = null;
        movesLeft = MAX_MOVES;
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                board[i][j] = Character.MIN_VALUE;
            }
        }
        greet();
        printBoard();
    }
    private boolean row(int r){
        return check(r,0,0,1);
    }
    private boolean col(int c){
        return check(0,c,1,0);
    }
    private boolean diag(int d){
        if(d == 0) return check(0,0,1,1);
        return check(0,2,1,-1);
    }

    private boolean check(int r, int c, int dr, int dc) {
        return board[r][c] != Character.MIN_VALUE &&
                board[r + dr][c + dc] == board[r][c] &&
                board[r + dr + dr][c+dc+dc] ==board[r][c];
    }

    private boolean GameOver(){
        if(row(0) || row(1) || row(2)) return true;
        if(col(0) || col(1) || col(2)) return true;
        if(diag(0)|| diag(2)) return true;
        return false;
    }
    public void Restart(){
        startNewGame();
    }
    private boolean ValidMove(int x, int y){
        return x >= 0 && x < SIZE && y >= 0 && y < SIZE && board[x][y] == Character.MIN_VALUE;
    }
    private boolean YourTurn(Player player){
        return player != lastPlayer;
    }
    private void PlayerMove(Player player, int x, int y){
        if(movesLeft <= 0) System.out.println("Game is already Over!!");
        if(!ValidMove(x,y)) {
            System.out.println("This is not a valid move for " + player.getName());
            return;
        }
        if(!YourTurn(player)){
            System.out.println("This is not a valid turn for " + player.getName());
            return;
        }
        movesLeft--;
        lastPlayer = player;
        board[x][y] = player.getSymbol();
        System.out.println(player.getName() + " made " + player.getSymbol() + " at (" + x + "," + y + ")");
        if(GameOver()){
            printBoard();
            player.displayWinningMessage();
            startNewGame();
            return;
        }
        if(movesLeft == 0){
            System.out.println("Game is Draw!!");
            startNewGame();
            return;
        }
        printBoard();
    }
    public void Player1Move(int x, int y){
        PlayerMove(player1,x,y);
    }
    public void Player2Move(int x, int y){
        PlayerMove(player2,x,y);
    }
    public void printBoard(){
        System.out.println("-----------");
        for(int i = 0; i < SIZE;i++){
            for(int j = 0; j < SIZE; j++){
                if(board[i][j] == Character.MIN_VALUE){
                    System.out.print("[ ]");
                }else{
                    System.out.print("["+ board[i][j]+"]");
                }
            }
            System.out.println();
        }
        System.out.println("-----------");
    }
}
