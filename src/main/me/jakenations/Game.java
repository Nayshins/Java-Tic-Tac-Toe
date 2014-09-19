package me.jakenations;

import java.io.IOException;

public class Game {
    private UI console;
    private Rules rules;
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }


    public Game(UI console, Rules rules, Board board, Player player1, Player player2) {
        this.console = console;
        this.rules = rules;
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
    }

    public void gameLoop() throws Exception {
        console.welcome();
        console.print(board.getBoardString());
        while (!rules.gameOver()){
            currentPlayer.selectMove();
            console.print(board.getBoardString());
            switchPlayers();
        }
        gameOverHandler();
    }

    public void gameOverHandler() {
        if (rules.isDraw()){
            console.draw();
        } else {
           switchPlayers();
           console.winner(currentPlayer.getMarker());
        }
    }


    public void switchPlayers() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean playAgain() throws IOException {
        console.playAgain();
        int input = console.getGameInput();

        if (input == 1) {
            return false;
        }

        return true;
    }
}
