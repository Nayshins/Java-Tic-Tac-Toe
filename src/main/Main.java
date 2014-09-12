package main;

public class Main {

    public static void main(String[] args) {
	    Board board = new Board();
        Rules rules = new GameRules();

        ConsoleUi console = new ConsoleUi(board);
        Player player = new HumanPlayer('X', board, console);
        Player computer = new ComputerPlayer('O', board, rules);
        Game game = new Game(console, rules, board, player, computer);
    }
}
