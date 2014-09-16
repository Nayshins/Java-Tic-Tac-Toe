package me.jakenations;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class ConsoleUiTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private ConsoleUi console;
    private Board board;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        this.board = new Board3x3();
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
                        " " + board.getCell(6) + " | " + board.getCell(7) + " | " + board.getCell(8) + "\n\n";
        assertEquals(boardString, outContent.toString());

    }

    @Test
    public void testSpaceOccupiedWarning() throws Exception {
        console.spaceOccupied();
        assertEquals("Space already filled please choose another\n", outContent.toString());

    }

    @Test
    public void testPrintsWinner() {
        char marker = 'X';
        console.winner(marker);
        assertEquals("X is the winner!\n", outContent.toString());
    }

    @Test
    public void testComputerMakingMove() throws Exception {
        console.computerMove();
        assertEquals("Computer is making it's move\n", outContent.toString());
    }

    @Test
    public void testDraw() throws Exception {
        console.draw();
        assertEquals("Game ended in a draw!\n", outContent.toString());

    }
}
