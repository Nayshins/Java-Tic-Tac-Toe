package test;

import main.*;

import org.junit.Test;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

/**
 * Created by Nayshins on 9/9/14.
 */
public class GameTest {
    @Test
    public void runsOnceWhileGameOverFalse() throws Exception {
        MockRules testRules = new MockRules();
        Board board = new Board();
        MockConsole console = new MockConsole(board);

        MockPlayer player1 = new MockPlayer('X', board, console);
        MockComputer player2 = new MockComputer('O', board, testRules);

        Game game = new Game(console, testRules, board, player1, player2 );

        Queue<String> inputQueue = new LinkedList<String>();
        inputQueue.add("A");
        inputQueue.add("3");
        inputQueue.add("4");
        console.setInput(inputQueue);

        Queue<Boolean> gameOverQueue = new LinkedList<Boolean>();
        gameOverQueue.add(false);
        gameOverQueue.add(false);
        gameOverQueue.add(true);
        testRules.setGameOverQueue(gameOverQueue);

        game.gameLoop();
        assertTrue(console.isWelcomed());
        assertTrue(console.isBoardPrinted());
        assertTrue(player1.getMoveMade());
        assertTrue(player2.getMoveMade());
    }

    @Test
    public void testSwitchPlayers() throws Exception {
        Rules testRules = new MockRules();
        Board board = new Board();
        MockConsole console = new MockConsole(board);

        Player player1 = new MockPlayer('X', board, console);
        Player player2 = new MockPlayer('O', board, console);

        Game game = new Game(console, testRules, board, player1, player2 );

        game.setCurrentPlayer(player1);
        game.switchPlayers();
        assertEquals(player2, game.getCurrentPlayer());

    }
}
