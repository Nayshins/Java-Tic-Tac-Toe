package me.jakenations;

public class Main {

    public static void main(String[] args) throws Exception {
	    BoardFactory boardFactory = new BoardFactory();
        RulesFactory rulesFactory = new RulesFactory();
        PlayerFactory playerFactory = new PlayerFactory();

            int gameType = 1;
            Board board = boardFactory.createBoard(gameType);
            Rules rules = rulesFactory.createRules(gameType, board);

            int player1Input = 1;
            Player player1 = playerFactory.createPlayer(player1Input, 'X', board, rules);
            int player2Input = 2;
            Player player2 = playerFactory.createPlayer(player2Input, 'O', board, rules);
    }
}
