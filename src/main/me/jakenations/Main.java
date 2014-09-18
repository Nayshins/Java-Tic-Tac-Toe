package me.jakenations;

public class Main {

    public static void main(String[] args) throws Exception {
	    Board board = new Board4x4();
        Rules rules = new GameRules4x4(board);

        UI console = new ConsoleUI();
        Player player = new HumanPlayer('X', board, console);
        Player computer = new ComputerPlayer('O', board, rules);
        Game game = new Game(console, rules, board, player, computer);
        game.gameLoop();
    }
}
