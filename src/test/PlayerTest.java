package test;

import main.Board;
import main.MockBoard;
import main.Player;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Nayshins on 9/8/14.
 */
public class PlayerTest {
    private Board board;
    private Player player;

    @Before
    public void setUp() {
        this.board = new MockBoard();
        this.player = new Player('X', board);
    }
    @Test
    public void playerHasMarker() {
        assertEquals('X', player.getMarker());
    }
    @Test
    public void playerHasBoard() {
        assertEquals(board, player.getBoard());
    }
    @Test
    public void makeMoveTest(){

    }
}
