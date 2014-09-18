package me.jakenations;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nayshins on 9/18/14.
 */
public class LazyComputerTest {
    @Test
    public void lazyComputerSelectsFirstOpenCell() throws Exception {
        Board board = new Board3x3();
        Player computer = new LazyComputer('X', board);
        board.setCell('X', 0);
        board.setCell('O', 1);
        computer.selectMove();
        assertEquals('X', board.getCell(2));
    }
}
