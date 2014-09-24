package me.jakenations;

import java.io.IOException;

public class HumanPlayer implements Player {
    private Board board;
    private char marker;

    public HumanPlayer(char marker, Board board) {
        this.board = board;
        this.marker = marker;
    }

    public char getMarker() {
        return marker;
    }

    public void makeMove(int index) throws Exception {
        board.setCell(marker, index);
    }

    public void selectMove() throws IOException {
        boolean validMove = false;
        while (!validMove) {
            int move = 1;
            move -= 1;
            try {
                validMove = true;
                makeMove(move);
            } catch (Exception cellOccupied){
                validMove = false;
            }
        }
    }
}
