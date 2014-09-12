package main;

/**
 * Created by Nayshins on 9/9/14.
 */
public class Game {
    private ConsoleUi console;
    private Rules rules;
    private Board board;
    private Player player1, player2;

    public Game(ConsoleUi console, Rules rules, Board board, Player player1, Player player2) {
        this.console = console;
        this.rules = rules;
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void gameLoop() {
        Player currentPlayer = player1;
        console.welcome();
        while (!rules.gameOver(board)){
            if (currentPlayer instanceof HumanPlayer){
                
            }
        }
    }


}
