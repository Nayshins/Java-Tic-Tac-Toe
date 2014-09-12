package main;

import java.io.IOException;

/**
 * Created by Nayshins on 9/10/14.
 */
public class HumanPlayer extends Player {
    private ConsoleUi console;

    public HumanPlayer(char marker, Board board, ConsoleUi console) {
        super(marker, board);
        this.console = console;
    }

    public void makeMove(int index) throws Exception {
        board.setCell(marker, index);
    }

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
}
