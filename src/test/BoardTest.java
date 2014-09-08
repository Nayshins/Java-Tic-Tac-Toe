package test;

import main.Board;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;


import java.util.ArrayList;
import java.util.Arrays;

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
        char[] testGrid = new char[]{' ',' ',' ',' ',' ',' ',' ',' ',' '};
        assertArrayEquals(testGrid, board.getGrid());
    }
    @Test
    public void testGetAndSetCell() {
        board.setCell('X',0);
        assertEquals('X', board.getCell(0));
    }
    @Test
    public void locationsTest() {
        board.setCell('X', 0);
        ArrayList<Integer> testArray = new ArrayList<Integer>();
        testArray.add(0);
        assertEquals(testArray, board.getLocations('X'));
    }
    @Test
    public void emptyCellTest() {
        board.setCell('X', 0);
        board.setCell('X', 1);
        board.setCell('X', 2);
        board.setCell('X', 3);
        ArrayList<Integer> testArray = new ArrayList<Integer>(Arrays.asList(4, 5, 6, 7, 8));
        assertEquals(testArray, board.getEmpty());
    }
    @Test
    public void makeRowsTest() {
        board.setCell('X', 0);
        board.setCell('X', 1);
        board.setCell('X', 2);
        ArrayList<char[]> rowTest = new ArrayList<char[]>();
        rowTest.add(new char[]{'X','X','X'});
        rowTest.add(new char[]{' ',' ',' '});
        rowTest.add(new char[]{' ',' ',' '});
        assertArrayEquals(rowTest.get(0), board.makeRows().get(0));
    }
    @Test
    public void makeRowsTestEmpty(){
        ArrayList<char[]> rowTest = new ArrayList<char[]>();
        rowTest.add(new char[]{'X','X','X'});
        rowTest.add(new char[]{' ',' ',' '});
        rowTest.add(new char[]{' ',' ',' '});
        assertArrayEquals(rowTest.get(2), board.makeRows().get(2));
    }
    @Test
    public void makeColumnsTest() {
        board.setCell('X', 0);
        board.setCell('X', 3);
        board.setCell('X', 6);
        ArrayList<char[]> colTest = new ArrayList<char[]>();
        colTest.add(new char[]{'X','X','X'});
        colTest.add(new char[]{' ',' ',' '});
        colTest.add(new char[]{' ',' ',' '});
        assertArrayEquals(colTest.get(0), board.makeColumns().get(0));
    }
    @Test
    public void makeDiagonalsTest() {
        board.setCell('X', 0);
        board.setCell('X', 4);
        board.setCell('X', 8);
        ArrayList<char[]> diagonalsTest = new ArrayList<char[]>();
        diagonalsTest.add(new char[]{'X','X','X'});
        diagonalsTest.add(new char[]{' ',' ',' '});
        assertArrayEquals(diagonalsTest.get(0), board.makeDiagonals().get(0));
    }
    @Test
    public void makeSolutionsTest() {
        board.setCell('X', 0);
        board.setCell('X', 1);
        board.setCell('X', 2);
        ArrayList<char[]> solutionsTest = new ArrayList<char[]>();
        solutionsTest.add(new char[]{'X','X','X'});
        solutionsTest.add(new char[]{' ',' ',' '});
        solutionsTest.add(new char[]{' ',' ',' '});
        solutionsTest.add(new char[]{'X',' ',' '});
        solutionsTest.add(new char[]{'X',' ',' '});
        solutionsTest.add(new char[]{'X',' ',' '});
        solutionsTest.add(new char[]{'X',' ',' '});
        solutionsTest.add(new char[]{'X',' ',' '});
        assertArrayEquals(solutionsTest.get(0),board.makeSolutions().get(0));
        assertArrayEquals(solutionsTest.get(1),board.makeSolutions().get(1));
        assertArrayEquals(solutionsTest.get(2),board.makeSolutions().get(2));
        assertArrayEquals(solutionsTest.get(3),board.makeSolutions().get(3));
        assertArrayEquals(solutionsTest.get(4),board.makeSolutions().get(4));
        assertArrayEquals(solutionsTest.get(5),board.makeSolutions().get(5));
        assertArrayEquals(solutionsTest.get(6),board.makeSolutions().get(6));
        assertArrayEquals(solutionsTest.get(7),board.makeSolutions().get(7));
    }

}