package main;

import java.util.ArrayList;

/**
 * Created by Nayshins on 9/10/14.
 */
public class MockRules extends GameRules {
    private boolean isGameOver;

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
        return isGameOver;
    }

    public void setGameOver(boolean isGameOver) {
        this.isGameOver = isGameOver;
    }
}
