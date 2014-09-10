package main;

/**
 * Created by Nayshins on 9/9/14.
 */
public class ComputerPlayer {
    private char marker;
    private Board board;

    public ComputerPlayer(char marker, Board board) {
        this.marker = marker;
        this.board = board;
    }

    public char getMarker() {
        return marker;
    }

    public Board getBoard() {
        return board;
    }

    public void makeMove(int index) throws Exception {
        board.setCell(marker, index);
    }

    public void lazyComputer() throws Exception {
       int first = board.getEmpty().get(0);
       makeMove(first);
    }
}
