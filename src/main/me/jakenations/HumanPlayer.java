package me.jakenations;

import java.io.IOException;

public class HumanPlayer implements Player {
    private UI console;
    private Board board;
    private char marker;

    public HumanPlayer(char marker, Board board, UI console) {
        this.console = console;
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

        console.movePrompt(board.getSize());
        while (!validMove) {
            String input = console.getInput();
            if (console.validateMove(input)){
                int move = Integer.parseInt(input);
                move -= 1;
                try {
                    validMove = true;
                    makeMove(move);
                } catch (Exception cellOccupied){
                    validMove = false;
                    console.invalidInput();
                }
            }

        }
    }
}
