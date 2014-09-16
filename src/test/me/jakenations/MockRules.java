package me.jakenations;

import java.util.ArrayList;
import java.util.Queue;


public class MockRules implements Rules {
    private Queue<Boolean> gameOverQueue;

    @Override
    public boolean winner(ArrayList<char[]> solutions) {
        return false;
    }

    @Override
    public boolean draw() {
        return false;
    }

    @Override
    public boolean gameOver( ) {
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
