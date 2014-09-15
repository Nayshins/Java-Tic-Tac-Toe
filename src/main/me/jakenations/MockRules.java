package me.jakenations;

import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by Nayshins on 9/10/14.
 */
public class MockRules implements Rules {
    private Queue<Boolean> gameOverQueue;

    @Override
    public boolean winner(ArrayList<char[]> solutions) {
        return false;
    }

    @Override
    public boolean draw(ArrayList<Integer> empties) {
        return false;
    }

    @Override
    public boolean gameOver(Board board) {
        return isGameOver();
    }

    @Override
    public boolean winTest(char marker, ArrayList<char[]> chars) {
        return false;
    }

    @Override
    public boolean isDraw() {
        return false;
    }

    public boolean isGameOver() {
        return gameOverQueue.remove();
    }
    public void setGameOverQueue(Queue<Boolean> queue){
        this.gameOverQueue = queue;
    }
}
