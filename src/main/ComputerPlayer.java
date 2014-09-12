package main;

/**
 * Created by Nayshins on 9/9/14.
 */
public class ComputerPlayer extends Player {
    private Rules rules;

    public ComputerPlayer(char marker, Board board, Rules rules) {
        super(marker, board);
        this.rules = rules;
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

    public int lazyComputer() throws Exception {
       int first = board.getEmpty().get(0);
       return first;
    }

    public char getOpponent(char marker){
        char opponent = (marker == 'X') ? 'O' : 'X';
        return opponent;
    }

    public float boardScore(char marker){
        if (rules.winTest(marker, board.makeSolutions())){
            return (float) 1.0;
        } else if (rules.winTest(getOpponent(marker),board.makeSolutions())) {
            return (float) -1.0;
        }
        return (float) 0.0;
    }
    public float negamax(char marker, int depth) throws Exception {
       char opponent = getOpponent(marker);
       float bestScore = Integer.MIN_VALUE;
       if (rules.gameOver(board)){
           return boardScore(marker) / depth;
       } else {
           for (int move : board.getEmpty()){
               board.setCell(marker,move);
               float score = -negamax(opponent, depth + 1);
               board.undoMove(move);
               if (score > bestScore){
                   bestScore = score;
               }
           }
       }
       return bestScore;
    }
    public int unbeatableComputer() throws Exception {
       char opponent = getOpponent(marker);
       int bestMove = -1;
       float bestScore = Integer.MIN_VALUE;
       for (int move : board.getEmpty()){
            board.setCell(marker,move);
            float score = -negamax(opponent, 1);
            board.undoMove(move);
            if (score > bestScore){
                bestScore = score;
                bestMove = move;
            }
       }
       return bestMove;
    }

}
