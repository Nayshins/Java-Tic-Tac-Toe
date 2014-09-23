package me.jakenations;

import java.util.ArrayList;


public abstract class  Rules {
    public Board board;

    public Rules(Board board) {
        this.board = board;
    }

    public boolean isWinner(ArrayList<char[]> solutions) {
        for (char[] solution : solutions) {
            char first = solution[0];
            if (firstIsBlank(first)) {
                continue;
            } else if(isWinningLine(solution, first)) {
                return true;
            }
        }
        return false;
    }

    abstract boolean isWinningLine(char[] solution, char first);

    public boolean isDraw() {
        return board.getEmpty().size() == 0;
    }

    public boolean isGameOver() {
        if (isWinner(board.concatenateWinConditions())) {
            return true;
        } else if (isDraw()){
            return true;
        }
        return false;
    }

    public boolean isMarkerWinner(char marker, ArrayList<char[]> solutions) {
         for (char[] solution : solutions) {
            char first = solution[0];
            if (firstIsBlank(first)|| first != marker) {
                continue;
            } else if(isWinningLine(solution, first)) {
                return true;
            }
        }
        return false;
    }

    private boolean firstIsBlank(char first){
        return first == board.EMPTY;
    };
}
