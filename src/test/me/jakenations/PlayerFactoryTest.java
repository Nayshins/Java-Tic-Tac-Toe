package me.jakenations;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Nayshins on 9/18/14.
 */
public class PlayerFactoryTest {

    @Test
    public void createsAHumanPlayerWhenOne(){
        PlayerFactory factory = new PlayerFactory();
        Board board = new Board3x3();
        UI console = new ConsoleUI();
        Rules rules = new GameRules(board);
        assertTrue(factory.createPlayer(1, 'X', board, console, rules) instanceof HumanPlayer);
    }
    @Test
    public void createsAComputerPlayerWhenOne(){
        PlayerFactory factory = new PlayerFactory();
        Board board = new Board3x3();
        UI console = new ConsoleUI();
        Rules rules = new GameRules(board);
        assertTrue(factory.createPlayer(2, 'X', board, console, rules) instanceof ComputerPlayer);
    }
}
