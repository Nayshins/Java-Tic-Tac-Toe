package me.jakenations;

import java.util.ArrayList;

public class GameRules implements Rules {

    private Board board;

    public GameRules(Board board) {
        this.board = board;
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

    public boolean isDraw() {
        return board.getEmpty().size() == 0;
    }

    public boolean isGameOver() {
        if (winner(board.makeSolutions())) {
            return true;
        } else if (isDraw()){
            return true;
        }
        return false;
    }

    public boolean isMarkerWinner(char marker, ArrayList<char[]> solutions){
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

    private boolean isBlank(char first) {
        return first != ' ';
    }
}
