package main;

import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by Nayshins on 9/8/14.
 */
public abstract class Rules {
    public boolean isGameOver;
    public Queue<Boolean> gameOverQueue;

    public boolean winner(ArrayList<char[]> solutions) {
        for (char[] solution : solutions) {
            char first = solution[0];
            if (first == ' ') {
                continue;
            } else if(first == solution[1] & first == solution[2]) {
                return true;
            }
        }
        return false;
    }

    public boolean draw(ArrayList<Integer> empties) {
        if (empties.isEmpty()){
           return true;
        }
        return false;
    }

    public boolean gameOver(Board board) {
        if (winner(board.makeSolutions())) {
            return true;
        } else if (draw(board.getEmpty())){
            return true;
        }
        return false;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean isGameOver) {
        this.isGameOver = isGameOver;
    }

    public boolean winTest(char marker, ArrayList<char[]> chars){
        return true;
    };

    public void setGameOverQueue(Queue<Boolean> gameOverQueue) {
    }

    public boolean isDraw() {
        return false;
    }
}
