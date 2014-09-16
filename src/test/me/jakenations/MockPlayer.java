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

        console.movePrompt();
        while (!validMove) {
            String input = console.getInput();
            if (validateMove(input)){
                int move = Integer.parseInt(input);
                move -= 1;
                try {
                    validMove = true;
                    makeMove(move);
                } catch (Exception cellOccupied){
                    validMove = false;
                    console.spaceOccupied();
                }
            }

        }
    }
        public boolean validateMove(String input){
        if (input.matches("[1-9]")){
            return true;
        }
        console.invalidInput();
        return false;
    }

    public boolean getMoveMade() {
        return moveMade;
    }
}
