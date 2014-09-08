package test;

import main.Board;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class BoardTest {
    Board board;

    @Before
    public void setup() {
        this.board = new Board();
    }
    @After
    public void tearDown() {
        this.board = null;
    }
    @Test
    public void testGrid(){
        assertArrayEquals(new char[9], board.getGrid());
    }
    @Test
    public void testGetAndSetCell() {
        board.setCell('X',0);
        assertEquals('X', board.getCell(0));
    }
}