package me.jakenations;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class ComputerTest {
    private Board board;
    private ComputerPlayer computer;
    private GameRules rules;

    @Before
    public void setUp() {
        this.board = new Board3x3();
        this.rules = new GameRules(board);
        this.computer = new ComputerPlayer('X', board, rules);
    }

    @After
    public void tearDown() {
        this.board = null;
        this.computer = null;
        this.rules = null;
    }

    @Test
    public void computerMarkerTest() {
        assertEquals('X', computer.getMarker());
    }

    @Test
    public void computerHasBoard() {
        assertEquals(board, computer.getBoard());
    }

    @Test
    public void computerMakesMove() throws Exception {
        computer.makeMove(0);
        assertEquals('X', board.getCell(0));
    }

    @Test
    public void lazyComputerSelectsFirstOpenCell() throws Exception {
        board.setCell('X', 0);
        board.setCell('O', 1);

        assertEquals(2, computer.lazyComputer());
    }


    @Test
    public void getOpponentTest() {
        assertEquals('O', computer.getOpponent('X'));
    }

    @Test
    public void boardScoreReturns1ForWin() throws Exception {
        board.setCell('X', 0);
        board.setCell('X', 1);
        board.setCell('X', 2);
        assertEquals(1, computer.boardScore('X'), .01);
    }

    @Test
    public void boardScoreReturnsNegativeForLoss() throws Exception {
        board.setCell('O', 0);
        board.setCell('O', 1);
        board.setCell('O', 2);
        assertEquals(-1, computer.boardScore('X'), .01);
    }

    @Test
    public void returnsZeroIfNoWinner() {
        assertEquals(0, computer.boardScore('X'), .01);
    }

    @Test
    public void negamaxReturnsZeroForDrawAndMarker() throws Exception {
        board.setCell('O', 0);
        board.setCell('O', 1);
        board.setCell('X', 2);
        board.setCell('X', 3);
        board.setCell('O', 4);
        board.setCell('O', 5);
        board.setCell('O', 6);
        board.setCell('X', 7);
        board.setCell('X', 8);
        assertEquals(0, computer.negamax('X', 1), 0.01);
    }

    @Test
    public void negamaxReturnsOneForWin() throws Exception {
        board.setCell('O', 0);
        board.setCell('O', 1);
        board.setCell('X', 2);
        board.setCell('X', 3);
        board.setCell('O', 4);
        board.setCell('O', 5);
        board.setCell('X', 6);
        board.setCell('X', 7);
        board.setCell('X', 8);
        assertEquals(1, computer.negamax('X', 1), 0.01);
    }

    @Test
    public void negamaxReturnsNegativeOneForLoss() throws Exception {
        board.setCell('O', 0);
        board.setCell('O', 1);
        board.setCell('O', 2);
        board.setCell('X', 3);
        board.setCell('O', 4);
        board.setCell('O', 5);
        board.setCell('O', 6);
        board.setCell('X', 7);
        board.setCell('X', 8);
        assertEquals(-1, computer.negamax('X', 1), 0.01);
    }

    @Test
    public void negamaxReturnsOneWhenWinningMove() throws Exception {
        board.setCell('O', 0);
        board.setCell('O', 1);
        board.setCell('X', 3);
        board.setCell('O', 4);
        board.setCell('O', 5);
        board.setCell('X', 7);
        board.setCell('X', 8);
        assertEquals(1, computer.negamax('X', 0), 0.01);
    }

    @Test
    public void negamaxReturnsZeroWhenLosing() throws Exception {
        board.setCell('O', 0);
        board.setCell('X', 1);
        board.setCell('X', 2);
        board.setCell('X', 3);
        board.setCell('O', 4);
        board.setCell('O', 5);
        board.setCell('X', 7);
        board.setCell('X', 8);
        assertEquals(0, computer.negamax('O', 0), 0.01);
    }

    @Test
    public void unbeatableComputerReturnsCellThatMakesThreeInARow() throws Exception {
        board.setCell('O', 2);
        board.setCell('O', 7);
        board.setCell('X', 0);
        board.setCell('X', 3);
        assertEquals(6, computer.unbeatableComputer());
    }

    @Test
    public void blocksOpponentThreeInARow() throws Exception {
        board.setCell('O', 0);
        board.setCell('O', 2);
        board.setCell('X', 6);
        assertEquals(1, computer.unbeatableComputer());
    }

    @Test
    public void winsGameInsteadOfBlocking() throws Exception {
        board.setCell('O', 0);
        board.setCell('O', 2);
        board.setCell('X', 6);
        board.setCell('X', 8);
        assertEquals(7, computer.unbeatableComputer());
    }

    @Test
    public void completesThreeInARowInsteadOfATie() throws Exception {
        board.setCell('X', 0);
        board.setCell('O', 1);
        board.setCell('O', 3);
        board.setCell('X', 4);
        board.setCell('O', 5);
        board.setCell('O', 7);
        assertEquals(8, computer.unbeatableComputer());
    }

}
