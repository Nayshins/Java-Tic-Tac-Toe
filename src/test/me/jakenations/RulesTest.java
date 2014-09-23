package me.jakenations;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RulesTest {
    Board board;
    Rules rules;

    @Before
    public void setUp() {
        this.board = new Board3x3();
        this.rules = new GameRules(board);
    }

    @After
    public void tearDown() {
        this.board = null;
        this.rules = null;
    }

    @Test
    public void noWinnerTest() {
        assertFalse("Empty grid returns false", rules.winner(board.makeSolutions()));
    }

    @Test
    public void winnerRowTest() throws Exception {
        board.setCell('X', 0);
        board.setCell('X', 1);
        board.setCell('X', 2);
        assertTrue("3 in a row returns true", rules.winner(board.makeSolutions()));
    }

    @Test
    public void winnerColTest() throws Exception {
        board.setCell('X', 0);
        board.setCell('X', 3);
        board.setCell('X', 6);
        assertTrue("3 in a column return true", rules.winner(board.makeSolutions()));
    }

    @Test
    public void drawTest() throws Exception {
        board.setCell('X', 0);
        board.setCell('O', 1);
        board.setCell('X', 2);
        board.setCell('X', 3);
        board.setCell('O', 4);
        board.setCell('X', 5);
        board.setCell('O', 6);
        board.setCell('X', 7);
        board.setCell('O', 8);
        assertTrue("Returns true when there is a draw", rules.isDraw());
    }

    @Test
    public void noDrawTest() throws Exception {
        assertFalse("Returns false when there is not a draw", rules.isDraw());
    }

    @Test
    public void noGameOverTest() throws Exception {
        assertFalse("Return false when there is no winner", rules.isGameOver());
    }

    @Test
    public void winGameOverTest() throws Exception {
        board.setCell('X', 0);
        board.setCell('X', 1);
        board.setCell('X', 2);
        assertTrue("Return true when the game is won", rules.isGameOver());
        assertFalse(rules.isDraw());
    }

    @Test
    public void drawGameOverTest() throws Exception {
        board.setCell('X', 0);
        board.setCell('O', 1);
        board.setCell('X', 2);
        board.setCell('X', 3);
        board.setCell('O', 4);
        board.setCell('X', 5);
        board.setCell('O', 6);
        board.setCell('X', 7);
        board.setCell('O', 8);
        assertTrue("Return true when the game ends in a draw", rules.isGameOver());
        assertTrue(rules.isDraw());
    }

    @Test
    public void winTestReturnsTrueForWinner() throws Exception {
        board.setCell('X', 0);
        board.setCell('X', 1);
        board.setCell('X', 2);
        assertTrue(rules.isMarkerWinner('X', board.makeSolutions()));
    }

    @Test
    public void winTestReturnsFalseIfNotWinner() throws Exception {
        board.setCell('O', 0);
        board.setCell('O', 1);
        board.setCell('X', 2);
        assertFalse(rules.isMarkerWinner('X', board.makeSolutions()));
    }

    @Test
    public void winTestReturnsTrueForO() throws Exception {
        board.setCell('O', 0);
        board.setCell('O', 1);
        board.setCell('O', 2);
        assertTrue(rules.isMarkerWinner('O', board.makeSolutions()));
    }
}
