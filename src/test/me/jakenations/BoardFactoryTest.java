package me.jakenations;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BoardFactoryTest {
    @Test
    public void createsBoard3x3WhenOne() {
        BoardFactory factory = new BoardFactory();
        assertTrue(factory.createBoard(1) instanceof Board3x3);
    }

    @Test
    public void createsBoard4x4WhenTwo() {
        BoardFactory factory = new BoardFactory();
        assertTrue(factory.createBoard(2) instanceof Board4x4);
    }
}
