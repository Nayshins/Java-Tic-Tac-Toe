package me.jakenations;

public class Main {

    public static void main(String[] args) throws Exception {
	    BoardFactory boardFactory = new BoardFactory();
        RulesFactory rulesFactory = new RulesFactory();
        UI console = new ConsoleUI();

        console.gameTypePrompt();
        int gameType = console.getGameInput();
        Board board = boardFactory.createBoard(gameType);
        Rules rules = rulesFactory.createRules(gameType, board);


        Player player = new HumanPlayer('X', board, console);
        Player computer = new ComputerPlayer('O', board, rules);
        Game game = new Game(console, rules, board, player, computer);
        game.gameLoop();
    }
}
