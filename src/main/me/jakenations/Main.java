package me.jakenations;

public class Main {

    public static void main(String[] args) throws Exception {
	    BoardFactory boardFactory = new BoardFactory();
        RulesFactory rulesFactory = new RulesFactory();
        PlayerFactory playerFactory = new PlayerFactory();
        UI console = new ConsoleUI();

        boolean playAgain = false;

        while(!playAgain) {
            console.gameTypePrompt();
            int gameType = console.getGameInput();
            Board board = boardFactory.createBoard(gameType);
            Rules rules = rulesFactory.createRules(gameType, board);

            console.playerOnePrompt();
            int player1Input = console.getGameInput();
            Player player1 = playerFactory.createPlayer(player1Input, 'X', board, console, rules);
            console.playerTwoPrompt();
            int player2Input = console.getGameInput();
            Player player2 = playerFactory.createPlayer(player2Input, 'O', board, console, rules);

            Game game = new Game(console, rules, board, player1, player2);
            game.gameLoop();
            playAgain = game.playAgain();
        }
    }
}
