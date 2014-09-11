package test;

import main.*;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Nayshins on 9/9/14.
 */
public class GameTest {
    @Test
    public void doesNothingWhenTheGameIsStopped() {
        Rules testRules = new MockRules();
        Board board = new Board();
        ConsoleUi console = new ConsoleUi();
        Player player1 = new MockPlayer('X', board);
        Player player2 = new MockPlayer('O', board);
        Game game = new Game(console, testRules, board, player1, player2 );
        testRules.setGameOver(true);
        game.gameLoop();
        assertTrue(testRules.gameOver(board));
    }
}
