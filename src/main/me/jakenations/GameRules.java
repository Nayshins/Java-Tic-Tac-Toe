package me.jakenations;

import java.util.ArrayList;

public class GameRules implements Rules {

    public boolean isDraw() {
        return isDraw;
    }

    private boolean isDraw = false;

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
        if (empties.size() == 0){
            return true;
        }
        return false;
    }

    public boolean gameOver(Board board) {
        if (winner(board.makeSolutions())) {
            return true;
        } else if (draw(board.getEmpty())){
            isDraw = true;
            return true;
        }
        return false;
    }

    public boolean winTest(char marker, ArrayList<char[]> solutions){
        for (char[] solution : solutions) {
            char first = solution[0];
            if (first == ' ' || first != marker) {
                continue;
            } else if(marker == solution[1] & first == solution[2]) {
                return true;
            }
        }
        return false;
    }
}
