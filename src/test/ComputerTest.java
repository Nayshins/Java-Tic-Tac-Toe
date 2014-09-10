package test;

import main.Board;
import main.ComputerPlayer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Nayshins on 9/9/14.
 */
public class ComputerTest {
    private Board board;
    private ComputerPlayer computer;

    @Before
    public void setUp() {
        this.board = new Board();
        this.computer = new ComputerPlayer('X', board);
    }

    @After
    public void tearDown() {
        this.board = null;
        this.computer = null;
    }

    @Test
    public void computerMarkerTest() {
        assertEquals('X',computer.getMarker());
    }
    @Test
    public void computerHasBoard() {
        assertEquals(board,computer.getBoard());
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
        computer.lazyComputer();
        assertEquals('X', board.getCell(2));
    }
}
