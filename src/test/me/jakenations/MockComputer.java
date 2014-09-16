package me.jakenations;

public class MockComputer implements Player{
    public boolean moveMade = false;
    public int indexOfMove;
    private Board board;
    private Rules rules;
    private char marker;

    public MockComputer(char marker, Board board, Rules rules) {
        this.marker = marker;
        this.board = board;
        this.rules = rules;
    }

    @Override
    public char getMarker() {
        return 0;
    }

    @Override
    public void makeMove(int index){
        moveMade = true;
        indexOfMove = index;
    }
    public boolean getMoveMade() {
        return moveMade;
    }

     public int lazyComputer() throws Exception {
        int first = board.getEmpty().get(0);
        return first;
    }


    public void selectMove() throws Exception {
        makeMove(lazyComputer());
    }

}
