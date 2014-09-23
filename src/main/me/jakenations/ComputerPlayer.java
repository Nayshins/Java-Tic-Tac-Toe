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
        if (rules.isMarkerWinner(marker, board.makeSolutions())){
            return (float) 1.0;
        } else if (rules.isMarkerWinner(getOpponent(marker), board.makeSolutions())) {
            return (float) -1.0;
        }
        return (float) 0.0;
    }
    public float negamax(char marker, int depth, float alpha, float beta) throws Exception {
        char opponent = getOpponent(marker);
        float bestScore = Integer.MIN_VALUE;
        if (rules.isGameOver() || depth >= 7){
            return boardScore(marker) / depth;
        } else {
            for (int move : board.getEmpty()){
                board.setCell(marker,move);
                float score = -negamax(opponent, depth + 1, -beta, -alpha);
                undoMove(move);
                if (score > bestScore){
                    bestScore = score;
                }
                if (alpha < score){
                    alpha = score;
                }
                if (alpha >= beta){
                    break;
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
            float score = -negamax(opponent, 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
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
