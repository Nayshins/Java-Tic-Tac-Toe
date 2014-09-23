package me.jakenations;

public class GameRules extends Rules {


    public GameRules(Board board) {
        super(board);
    }

    boolean isWinningLine(char[] solution, char first) {
        return first == solution[1] & first == solution[2];
    }
}
