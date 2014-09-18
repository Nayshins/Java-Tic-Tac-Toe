package me.jakenations;

/**
 * Created by Nayshins on 9/18/14.
 */
public class LazyComputer implements Player {
    private Board board;
    private char marker;

    public LazyComputer(char marker, Board board) {
        this.marker = marker;
        this.board = board;
    }

    @Override
    public char getMarker() {
        return marker;
    }

    @Override
    public void selectMove() throws Exception {
        makeMove(lazyComputer());
    }

    private void makeMove(int move) throws Exception {
        board.setCell(marker, move);
    }

    public int lazyComputer() throws Exception {
        if (board.getEmpty().isEmpty()) {
            return 0;
        }
        return board.getEmpty().get(0);
    }
}
