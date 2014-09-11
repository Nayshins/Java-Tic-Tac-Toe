package main;

/**
 * Created by Nayshins on 9/10/14.
 */
public class HumanPlayer extends Player {

    public HumanPlayer(char marker, Board board) {
        super(marker, board);
    }

    public void makeMove(int index) throws Exception {
        board.setCell(marker, index);
    }

}
