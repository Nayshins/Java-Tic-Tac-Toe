package test;

import main.Board;
import main.Rules;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Nayshins on 9/8/14.
 */
public class RulesTest {
    @Test
    public void noWinnerTest() {
        Board board = new Board();
        Rules rules = new Rules();
        assertFalse("Empty grid returns false", rules.winner(board.makeSolutions()));
    }
    @Test
    public void winnerRowTest() {
        Board board = new Board();
        Rules rules =  new Rules();
        board.setCell('X', 0);
        board.setCell('X', 1);
        board.setCell('X', 2);
        assertTrue("3 in a row returns true", rules.winner(board.makeSolutions()));
    }
    @Test
    public void winnerColTest() {
        Board board = new Board();
        Rules rules =  new Rules();
        board.setCell('X', 0);
        board.setCell('X', 3);
        board.setCell('X', 6);
        assertTrue("3 in a column return true", rules.winner(board.makeSolutions()));
    }
    @Test
    public void drawTest() {
        Board board = new Board();
        Rules rules = new Rules();

    }
}
