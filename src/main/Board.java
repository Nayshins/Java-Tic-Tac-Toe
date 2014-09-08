package main;

/**
 * Created by Nayshins on 9/8/14.
 */
public class Board {


    private char[] grid = new char[9];

    public char[] getGrid() {
        return grid;
    }

    public char getCell(int i) {
        return grid[i];
    }

    public void setCell(char x, int i) {
        grid[i] = x;
    }
}
