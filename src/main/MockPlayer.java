package main;

/**
 * Created by Nayshins on 9/10/14.
 */
public class MockPlayer extends HumanPlayer {
    public boolean moveMade = false;
    public int indexOfMove;

    public MockPlayer(char marker, Board board, ConsoleUi console) {
        super(marker, board, console);
    }

    @Override
    public void makeMove(int index){
        moveMade = true;
        indexOfMove = index;
    }
    public boolean getMoveMade() {
        return moveMade;
    }
}
