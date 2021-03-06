package me.jakenations;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;


public class GameTest {
    @Test
    public void runsOnceWhileGameOverFalse() throws Exception {
        Board board = new Board3x3();
        MockRules testRules = new MockRules(board);
        MockConsole console = new MockConsole();

        MockPlayer player1 = new MockPlayer('X', board, console);
        MockComputer player2 = new MockComputer('O', board, testRules);

        Game game = new Game(console, testRules, board, player1, player2);

        Queue<Integer> inputQueue = new LinkedList<Integer>();
        inputQueue.add(1);
        inputQueue.add(3);
        inputQueue.add(4);
        console.setInput(inputQueue);

        Queue<Boolean> gameOverQueue = new LinkedList<Boolean>();
        gameOverQueue.add(false);
        gameOverQueue.add(false);
        gameOverQueue.add(true);
        testRules.setGameOverQueue(gameOverQueue);

        game.gameLoop();
        assertTrue(console.isWelcomed());
        assertTrue(player1.getMoveMade());
        assertTrue(player2.getMoveMade());
    }



    @Test
    public void testSwitchPlayers() throws Exception {
        Board board = new Board3x3();
        Rules testRules = new MockRules(board);
        MockConsole console = new MockConsole();

        Player player1 = new MockPlayer('X', board, console);
        Player player2 = new MockPlayer('O', board, console);

        Game game = new Game(console, testRules, board, player1, player2);

        game.setCurrentPlayer(player1);
        game.switchPlayers();
        assertEquals(player2, game.getCurrentPlayer());

    }
}
