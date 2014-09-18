package me.jakenations;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Nayshins on 9/18/14.
 */
public class Console4x4Test {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private UI console;
    private Board board;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        this.board = new Board4x4();
        this.console = new Console4x4Ui();
    }

    @After
    public void tearDown() {
        System.setOut(null);
        this.board = null;
        this.console = null;
    }

    @Test
    public void printBoardTest() throws Exception {
        console.printBoard(board);
        String boardString =  " " + board.getCell(0) + " | " + board.getCell(1) + " | " + board.getCell(2)+ " | " + board.getCell(3) +"\n" +
                "---+---+---+---\n" +
                " " + board.getCell(4) + " | " + board.getCell(5) + " | " + board.getCell(6) + " | " + board.getCell(7) + "\n" +
                "---+---+---+---\n" +
                " " + board.getCell(8) + " | " + board.getCell(9) + " | " + board.getCell(10) +  " | " + board.getCell(11) +"\n" +
                "---+---+---+---\n" +
                " " + board.getCell(12) + " | " + board.getCell(13) + " | " + board.getCell(14) +  " | " + board.getCell(15) +"\n\n";
        assertEquals(boardString, outContent.toString());

    }

    @Test
    public void validateMoveTest() {
        assertTrue(console.validateMove("12"));
    }
    @Test
    public void validateMoveFalseNumberTest() {
        assertFalse(console.validateMove("21"));
    }

    @Test
    public void validateMoveFalseLetterTest() {
        assertFalse(console.validateMove("A"));
    }


}
