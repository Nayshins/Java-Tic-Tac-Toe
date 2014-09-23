package me.jakenations;

public class GameRules4x4 extends Rules {

    public GameRules4x4(Board board) {
        super(board);
    }

    @Override
    boolean isWinningLine(char[] solution, char first) {
        return (first == solution[1] && first == solution[2] && first == solution[3]);
    }
}

