package main;

/**
 * Created by Nayshins on 9/8/14.
 */
public class Player {

    private char marker;
    private Board board;

    public Player(char marker, Board board) {
        this.marker = marker;
        this.board = board;
    }

    public char getMarker() {
        return marker;
    }

    public void makeMove(int index) throws Exception {
        board.setCell(marker, index);
    }

    public Board getBoard() {
        return board;
    }
}
