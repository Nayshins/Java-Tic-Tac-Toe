package me.jakenations;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RulesFactoryTest {
    @Test
    public void createsRules3x3WhenOne(){
        RulesFactory factory = new RulesFactory();
        Board board = new Board3x3();
        assertTrue(factory.createRules(1, board) instanceof GameRules);
    }
    @Test
    public void createsRules4x4WhenOne(){
        RulesFactory factory = new RulesFactory();
        Board board = new Board4x4();
        assertTrue(factory.createRules(2, board) instanceof GameRules4x4);
    }
}
