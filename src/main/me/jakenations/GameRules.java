package me.jakenations;

import java.util.ArrayList;

public class GameRules implements Rules {

    private Board board;

    public GameRules(Board board) {
        this.board = board;
    }

    public boolean isDraw() {
        return draw();
    }


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

    public boolean draw() {
        if (board.getEmpty().size() == 0){
            return true;
        }
        return false;
    }

    public boolean gameOver() {
        if (winner(board.makeSolutions())) {
            return true;
        } else if (draw()){
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
