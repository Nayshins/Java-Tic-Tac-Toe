package me.jakenations;

import java.io.IOException;

public class MockPlayer implements Player {
    public boolean moveMade = false;
    public int indexOfMove;
    public char marker;
    public Board board;
    public UI console;

    public MockPlayer(char marker, Board board, UI console) {
        this.marker = marker;
        this.board = board;
        this.console = console;
    }

    @Override
    public char getMarker() {
        return 0;
    }

    public void makeMove(int index){
        moveMade = true;
        indexOfMove = index;
    }

    @Override
    public void selectMove() throws IOException {
        boolean validMove = false;

        console.movePrompt(board.getSize());
        while (!validMove) {
            int move = console.getGameInput();
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


    public boolean getMoveMade() {
        return moveMade;
    }
}
