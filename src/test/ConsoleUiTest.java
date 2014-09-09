package test;

import main.ConsoleUi;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by Nayshins on 9/9/14.
 */
public class ConsoleUiTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    ConsoleUi console;

    @Before
    public void setUp(){
        System.setOut(new PrintStream(outContent));
        this.console = new ConsoleUi();
    }

    @After
    public void tearDown() {
        System.setOut(null);
        this.console = null;
    }
    @Test
    public void printToConsoleTest() {

        console.print("hello");
        assertEquals("hello\n", outContent.toString());
    }
    @Test
    public void welcomeTest() {
        console.welcome();
        assertEquals("Welcome to Tic Tac Toe\n", outContent.toString());
    }
}
