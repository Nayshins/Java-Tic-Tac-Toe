package me.jakenations;

import java.util.ArrayList;
import java.util.Queue;


public class MockRules extends Rules {
    private Queue<Boolean> gameOverQueue;

    public MockRules(Board board) {
        super(board);
    }

    @Override
    public boolean isWinner(ArrayList<char[]> solutions) {
        return false;
    }

    @Override
    boolean isWinningLine(char[] solution, char first) {
        return false;
    }

    @Override
    public boolean isDraw() {
        return false;
    }

    @Override
    public boolean isMarkerWinner(char marker, ArrayList<char[]> chars) {
        return false;
    }


    public boolean isGameOver() {
        return gameOverQueue.remove();
    }
    public void setGameOverQueue(Queue<Boolean> queue){
        this.gameOverQueue = queue;
    }
}
