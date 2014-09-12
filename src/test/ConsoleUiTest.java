package test;

import main.Board;
import main.ConsoleUi;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by Nayshins on 9/9/14.
 */
public class ConsoleUiTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private ConsoleUi console;
    private Board board;

    @Before
    public void setUp(){
        System.setOut(new PrintStream(outContent));
        this.board = new Board();
        this.console = new ConsoleUi(board);
    }

    @After
    public void tearDown() {
        System.setOut(null);
        this.board = null;
        this.console = null;
    }
    @Test
    public void printToConsoleTest() {

        console.print("hello");
        assertEquals("hello\n", outContent.toString());
    }
    @Test
    public void getStandardInput() throws IOException {
        String input = "Test input";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            assertEquals(input, console.getInput());
        } finally {
            System.setIn(stdin);
        }
    }
    @Test
    public void welcomeTest() {
        console.welcome();
        assertEquals("Welcome to Tic Tac Toe\n", outContent.toString());
    }
    @Test
    public void movePromptTest() {
        console.movePrompt();
        assertEquals("Make a move by entering a number 1-9\n", outContent.toString());

    }

    @Test
    public void printBoardTest() throws Exception {
        console.printBoard();
        String boardString =
                " " + board.getCell(0) + " | " + board.getCell(1) + " | " + board.getCell(2) + "\n" +
                "---+---+---\n" +
                " " + board.getCell(3) + " | " + board.getCell(4) + " | " + board.getCell(5) + "\n" +
                "---+---+---\n" +
                " " + board.getCell(6) + " | " + board.getCell(7) + " | " + board.getCell(8) + "\n";
        assertEquals(boardString, outContent.toString());

    }
}
