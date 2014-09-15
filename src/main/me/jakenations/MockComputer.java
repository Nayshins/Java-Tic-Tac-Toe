package me.jakenations;

/**
 * Created by Nayshins on 9/12/14.
 */
public class MockComputer extends ComputerPlayer{
    public boolean moveMade = false;
    public int indexOfMove;

    public MockComputer(char marker, Board board, Rules rules) {
        super(marker, board, rules);
    }

    @Override
    public void makeMove(int index){
        moveMade = true;
        indexOfMove = index;
    }
    public boolean getMoveMade() {
        return moveMade;
    }

    public int unbeatableComputer() throws Exception {
        return lazyComputer();
    }

}
