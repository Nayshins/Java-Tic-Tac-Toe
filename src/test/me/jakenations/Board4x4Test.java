package me.jakenations;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Nayshins on 9/17/14.
 */
public class Board4x4Test {
       Board board;

    @Before
    public void setup() {
        this.board = new Board4x4();
    }

    @After
    public void tearDown() {
        this.board = null;
    }

     @Test
    public void testGrid() {
        char[] testGrid = new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        assertArrayEquals(testGrid, board.getGrid());
    }

    @Test
    public void setCellTest() throws Exception {
        board.setCell('X', 0);
        assertEquals('X', board.getCell(0));
    }

    @Test
    public void cellOccupiedTest() throws Exception {
        board.setCell('X', 0);
        assertTrue(board.cellOccupied(0));
    }

    @Test
    public void cellNotOccupiedTest() throws Exception {
        assertFalse(board.cellOccupied(0));
    }

    @Test(expected = Exception.class)
    public void doesNotSetCellIfOccupied() throws Exception {
        board.setCell('X', 0);
        board.setCell('O', 0);
    }

    @Test
    public void locationsTest() throws Exception {
        board.setCell('X', 14);
        ArrayList<Integer> testArray = new ArrayList<Integer>();
        testArray.add(14);
        assertEquals(testArray, board.getLocations('X'));
    }

     @Test
    public void emptyCellTest() throws Exception {
        board.setCell('X', 0);
        board.setCell('X', 1);
        board.setCell('X', 2);
        board.setCell('X', 3);
        ArrayList<Integer> testArray = new ArrayList<Integer>(Arrays.asList(4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));
        assertEquals(testArray, board.getEmpty());
    }

    @Test
    public void makeRowsTest() throws Exception {
        board.setCell('X', 0);
        board.setCell('X', 1);
        board.setCell('X', 2);
        board.setCell('X', 3);
        ArrayList<char[]> rowTest = new ArrayList<char[]>();
        rowTest.add(new char[]{'X', 'X', 'X', 'X'});
        rowTest.add(new char[]{' ', ' ', ' ', ' '});
        rowTest.add(new char[]{' ', ' ', ' ', ' '});
        assertArrayEquals(rowTest.get(0), board.makeRows().get(0));
    }

    @Test
    public void makeColumnsTest() throws Exception {
        board.setCell('X', 0);
        board.setCell('X', 4);
        board.setCell('X', 8);
        board.setCell('X', 12);
        ArrayList<char[]> colTest = new ArrayList<char[]>();
        colTest.add(new char[]{'X', 'X', 'X', 'X'});
        colTest.add(new char[]{' ', ' ', ' ', ' '});
        colTest.add(new char[]{' ', ' ', ' ', ' '});
        assertArrayEquals(colTest.get(0), board.makeColumns().get(0));
    }

    @Test
    public void makeDiagonalsTest() throws Exception {
        board.setCell('X', 0);
        board.setCell('X', 5);
        board.setCell('X', 10);
        board.setCell('X', 15);
        ArrayList<char[]> diagonalsTest = new ArrayList<char[]>();
        diagonalsTest.add(new char[]{'X', 'X', 'X', 'X'});
        diagonalsTest.add(new char[]{' ', ' ', ' ', ' '});
        assertArrayEquals(diagonalsTest.get(0), board.makeDiagonals().get(0));
    }

    @Test
    public void undoCellTest() throws Exception {
        board.setCell('X', 0);
        board.undoCell(0);
        assertEquals(' ', board.getCell(0));
    }

}
