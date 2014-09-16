package me.jakenations;

public class ComputerPlayer implements Player {
    private Board board;
    private char marker;
    private Rules rules;

    public ComputerPlayer(char marker, Board board, Rules rules) {
        this.marker = marker;
        this.rules = rules;
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

    public void selectMove() throws Exception {
        makeMove(unbeatableComputer());
    }

    public int lazyComputer() throws Exception {
        return board.getEmpty().get(0);
    }

    public char getOpponent(char marker){
        return (marker == 'X') ? 'O' : 'X';
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
                undoMove(move);
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
            undoMove(move);
            if (score > bestScore){
                bestScore = score;
                bestMove = move;
            }
        }
        return bestMove;
    }

    private void undoMove(int move){
        board.undoCell(move);
    }

}
