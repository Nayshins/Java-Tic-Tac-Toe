package me.jakenations;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

public class PlayerTest {
    private Board board;
    private HumanPlayer player;
    private MockConsole console;

    @Before
    public void setUp() {
        this.board = new Board3x3();
        this.console = new MockConsole();
        this.player = new HumanPlayer('X', board, console);
    }

    @After
    public void tearDown() {
        this.board = null;
        this.console = null;
        this.player = null;
    }

    @Test
    public void playerHasMarker() throws Exception {
        assertEquals('X', player.getMarker());
    }


    @Test
    public void successfulMakeMove() throws Exception {
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

        Queue<Integer> inputQueue = new LinkedList<Integer>();
        inputQueue.add(1);
        console.setInput(inputQueue);
        player.selectMove();
        assertTrue(console.isSolicitedInput());
        assertEquals('X', board.getCell(0));
    }

    @Test
    public void testSelectMoveWithSpaceOccupiedInput() throws Exception {
        board.setCell('O', 2);
        Queue<Integer> inputQueue = new LinkedList<Integer>();
        inputQueue.add(3);
        inputQueue.add(4);
        console.setInput(inputQueue);
        player.selectMove();
        assertEquals('O', board.getCell(2));
        assertTrue(console.wasInputWarningSent());
        assertEquals('X', board.getCell(3));
    }
}
