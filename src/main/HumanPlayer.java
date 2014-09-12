package main;

import java.io.Console;

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
    public int selectMove() {
        return 1;
    }

}
