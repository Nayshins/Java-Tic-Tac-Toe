package test;

import main.Board;
import main.Rules;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Nayshins on 9/8/14.
 */
public class RulesTest {
   Board board;
   Rules rules;

   @Before
   public void setUp(){
       this.board = new Board();
       this.rules = new Rules();
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
   public void winnerRowTest() {
        board.setCell('X', 0);
        board.setCell('X', 1);
        board.setCell('X', 2);
        assertTrue("3 in a row returns true", rules.winner(board.makeSolutions()));
   }
   @Test
   public void winnerColTest() {
        board.setCell('X', 0);
        board.setCell('X', 3);
        board.setCell('X', 6);
        assertTrue("3 in a column return true", rules.winner(board.makeSolutions()));
   }
    @Test
    public void drawTest() {
        board.setCell('X', 0);
        board.setCell('O', 1);
        board.setCell('X', 2);
        board.setCell('X', 3);
        board.setCell('O', 4);
        board.setCell('X', 5);
        board.setCell('O', 6);
        board.setCell('X', 7);
        board.setCell('O', 8);
        assertTrue("Returns true when there is a draw", rules.draw(board.getEmpty()));
    }
    @Test
    public void noDrawTest() {
        assertFalse("Returns false when there is not a draw", rules.draw(board.getEmpty()));
    }
}
