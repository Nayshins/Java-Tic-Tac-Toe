package main;

/**
 * Created by Nayshins on 9/8/14.
 */
public abstract class Player {

    public char marker;
    public Board board;

    public Player(char marker, Board board) {
        this.marker = marker;
        this.board = board;
    }

    public char getMarker() {
        return marker;
    }

    public void makeMove(int index) throws Exception {
    }

    public Board getBoard() {
        return board;
    }

    public void lazyComputer() throws Exception{}

    public char getOpponent(char marker) {
        return 0;
    }

    public float boardScore(char marker){
        return 0;
    }

    public float negamax(char x, int depth) throws Exception {
        return 0;
    }


    public int unbeatableComputer() throws Exception {

        return 0;
    }
}
