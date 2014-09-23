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
    public boolean isDraw() {
        return false;
    }

    public boolean isGameOverTest() {
        return isGameOver();
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
