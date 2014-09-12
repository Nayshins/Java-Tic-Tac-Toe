package main;

public class Main {

    public static void main(String[] args) {
	    Board board = new Board();
        Rules rules = new GameRules();
        Player player = new HumanPlayer('X', board);
        Player computer = new ComputerPlayer('O', board, rules);
        ConsoleUi console = new ConsoleUi();
        Game game = new Game(console, rules, board, player, computer);
    }
}
