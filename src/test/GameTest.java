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
        Rules testRules = new MockRules();
        Board board = new Board();
        MockConsole console = new MockConsole(board);
        Player player1 = new MockPlayer('X', board, console);
        Player player2 = new MockPlayer('O', board, console);
        Game game = new Game(console, testRules, board, player1, player2 );
        Queue<Boolean> gameOverQueue = new LinkedList<Boolean>();
        gameOverQueue.add(false);
        gameOverQueue.add(true);
        testRules.setGameOverQueue(gameOverQueue);

        game.gameLoop();

        assertTrue(console.isWelcomed());
        assertTrue(player1.getMoveMade());
    }
}
