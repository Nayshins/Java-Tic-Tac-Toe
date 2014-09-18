package me.jakenations;

public class Main {

    public static void main(String[] args) throws Exception {
	    Board board = new Board3x3();
        Rules rules = new GameRules(board);

        UI console = new ConsoleUi();
        Player player = new HumanPlayer('X', board, console);
        Player computer = new ComputerPlayer('O', board, rules);
        Game game = new Game(console, rules, board, player, computer);
        game.gameLoop();
    }
}
