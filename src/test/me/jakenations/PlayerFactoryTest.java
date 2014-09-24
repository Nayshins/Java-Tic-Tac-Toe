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

        Rules rules = new GameRules(board);
        assertTrue(factory.createPlayer(1, 'X', board, rules) instanceof HumanPlayer);
    }
    @Test
    public void createsAComputerPlayerWhenTwo(){
        PlayerFactory factory = new PlayerFactory();
        Board board = new Board3x3();
        Rules rules = new GameRules(board);
        assertTrue(factory.createPlayer(2, 'X', board, rules) instanceof ComputerPlayer);
    }

    @Test
    public void createsLazyComputerPlayerWhenThree(){
        PlayerFactory factory = new PlayerFactory();
        Board board = new Board3x3();
        Rules rules = new GameRules(board);
        assertTrue(factory.createPlayer(3, 'X', board, rules) instanceof LazyComputer);
    }
}
