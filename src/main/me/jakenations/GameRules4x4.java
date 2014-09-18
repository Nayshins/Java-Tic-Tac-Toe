package me.jakenations;

import java.util.ArrayList;

/**
 * Created by Nayshins on 9/17/14.
 */
public class GameRules4x4 implements Rules {
    private Board board;

    public GameRules4x4(Board board) {
        this.board = board;
    }

    @Override
    public boolean winner(ArrayList<char[]> solutions) {
         for (char[] solution : solutions) {
            char first = solution[0];
            if (first == ' ') {
                continue;
            } else if(first == solution[1] & first == solution[2] & first == solution[3]) {
                return true;
            }
        }
        return false;
    }


    public boolean draw() {
        if (board.getEmpty().size() == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean gameOver() {
        if (winner(board.makeSolutions())) {
            return true;
        } else if (draw()){
            return true;
        }
        return false;
    }

    @Override
    public boolean winTest(char marker, ArrayList<char[]> solutions) {
         for (char[] solution : solutions) {
            char first = solution[0];
            if (first == ' ' || first != marker) {
                continue;
            } else if(marker == solution[1] & first == solution[2] & first == solution[3]) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isDraw() {
        return draw();
    }
}

