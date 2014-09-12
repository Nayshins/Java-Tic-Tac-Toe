package test;

import main.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Nayshins on 9/8/14.
 */
public class PlayerTest {
    private Board board;
    private Player player;
    private ConsoleUi console;

    @Before
    public void setUp() {
        this.board = new Board();
        this.console = new MockConsole(board);
        this.player = new HumanPlayer('X', board, console);
    }
    @After
    public void tearDown() {
        this.board = null;
        this.console = null;
        this.player = null;
    }

    @Test
    public void playerHasMarker() throws Exception{
        assertEquals('X', player.getMarker());
    }
    @Test
    public void playerHasBoard() throws Exception{
        assertEquals(board, player.getBoard());
    }
    @Test
    public void successfulMakeMove() throws Exception{
        player.makeMove(0);
        assertEquals('X', board.getCell(0));
    }
    @Test(expected = Exception.class)
    public void makeMoveOnOccupiedCell() throws Exception {
        board.setCell('X', 0);
        player.makeMove(0);
    }

    @Test
    public void testSelectMove() throws Exception {
        assertEquals(1, player.selectMove());
    }
}
