package me.jakenations;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ConsoleUITest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private UI console;
    private Board board;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        this.board = new Board3x3();
        this.console = new ConsoleUI();
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
        assertEquals("Welcome to Tic Tac Toe\n\n", outContent.toString());
    }

    @Test
    public void movePromptTest() {
        console.movePrompt(board.getSize());
        assertEquals("Make a move by entering a number 1-9\n", outContent.toString());

    }

    @Test
    public void testPrintsWinner() {
        char marker = 'X';
        console.winner(marker);
        assertEquals("X is the isWinner!\n", outContent.toString());
    }


    @Test
    public void testDraw() throws Exception {
        console.draw();
        assertEquals("Game ended in a draw!\n", outContent.toString());

    }

    @Test
    public void validateMoveTest() {
        assertTrue(console.validateMove("1"));
    }

    @Test
    public void validateMoveFalseLetterTest() {
        assertFalse(console.validateMove("A"));
    }
}
