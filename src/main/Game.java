package main;

import java.io.IOException;

/**
 * Created by Nayshins on 9/9/14.
 */
public class Game {
    private ConsoleUi console;
    private Rules rules;
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }


    public Game(ConsoleUi console, Rules rules, Board board, Player player1, Player player2) {
        this.console = console;
        this.rules = rules;
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
    }

    public void gameLoop() throws Exception {
        console.welcome();
        console.printBoard();
        while (!rules.gameOver(board)){
            if (currentPlayer instanceof HumanPlayer){
                currentPlayer.selectMove();
            } else if(currentPlayer instanceof ComputerPlayer) {
                currentPlayer.makeMove(currentPlayer.unbeatableComputer());
            }
            console.printBoard();
            switchPlayers();
        }
        switchPlayers();

    }


    public void switchPlayers() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}
