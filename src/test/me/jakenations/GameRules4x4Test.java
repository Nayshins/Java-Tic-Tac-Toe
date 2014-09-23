package me.jakenations;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Nayshins on 9/18/14.
 */
public class GameRules4x4Test {
    Board board;
    Rules rules;

    @Before
    public void setup() {
        this.board = new Board4x4();
        this.rules = new GameRules4x4(board);
    }

    @After
    public void tearDown() {
        this.board = null;
        this.rules = null;
    }

    @Test
    public void winnerRowTest() throws Exception {
        board.setCell('X', 0);
        board.setCell('X', 1);
        board.setCell('X', 2);
        board.setCell('X', 3);
        assertTrue("4 in a row returns true", rules.winner(board.makeSolutions()));
    }

    @Test
    public void winnerColTest() throws Exception {
        board.setCell('X', 0);
        board.setCell('X', 4);
        board.setCell('X', 8);
        board.setCell('X', 12);
        assertTrue("4 in a column return true", rules.winner(board.makeSolutions()));
    }

     @Test
    public void winTestReturnsTrueForWinner() throws Exception {
        board.setCell('X', 0);
        board.setCell('X', 1);
        board.setCell('X', 2);
        board.setCell('X', 3);
        assertTrue(rules.isMarkerWinner('X', board.makeSolutions()));
    }

     @Test
    public void winTestReturnsFalseIfNotWinner() throws Exception {
        board.setCell('O', 0);
        board.setCell('O', 1);
        board.setCell('X', 2);
        assertFalse(rules.isMarkerWinner('X', board.makeSolutions()));
    }


}
