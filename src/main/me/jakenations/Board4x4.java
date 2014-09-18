package me.jakenations;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Nayshins on 9/17/14.
 */
public class Board4x4 implements Board {
    private static final char EMPTY = ' ';
    private int size = 16;

    private char[] grid = new char[]{EMPTY, EMPTY, EMPTY, EMPTY,
                                     EMPTY, EMPTY, EMPTY, EMPTY,
                                     EMPTY, EMPTY, EMPTY, EMPTY,
                                     EMPTY, EMPTY, EMPTY, EMPTY};


    @Override
    public char[] getGrid() {
        return grid;
    }

    @Override
    public char getCell(int index) {
        return grid[index];
    }

    @Override
    public void setCell(char marker, int index) throws Exception {
        if (cellOccupied(index)){
            throw new Exception();
        } else {
            grid[index] = marker;
        }
    }

    @Override
    public ArrayList<Integer> getLocations(char marker) {
        ArrayList<Integer> locations = new ArrayList<Integer>();
        for (int i = 0; i < grid.length; i++) {
            if (grid[i] == marker) {
                locations.add(i);
            }
        }
        return locations;
    }

    @Override
    public ArrayList<Integer> getEmpty() {
        ArrayList<Integer> emptyLocations = new ArrayList<Integer>();
        for (int i = 0; i < grid.length; i++) {
            checkIfCharIsEmpty(emptyLocations, i);
        }
        return emptyLocations;
    }

     private void checkIfCharIsEmpty(ArrayList<Integer> emptyLocations, int i) {
        if (grid[i] == EMPTY) {
            emptyLocations.add(i);
        }
    }

    @Override
    public ArrayList<char[]> makeRows() {
        ArrayList<char[]> rows = new ArrayList<char[]>();
        rows.add(Arrays.copyOfRange(grid, 0, 4));
        rows.add(Arrays.copyOfRange(grid,4,8));
        rows.add(Arrays.copyOfRange(grid,8,grid.length));
        return rows;
    }

    @Override
    public ArrayList<char[]> makeColumns() {
        ArrayList<char[]> columns = new ArrayList<char[]>();
        columns.add(new char[]{ grid[0], grid[4], grid[8], grid[12]});
        columns.add(new char[]{ grid[1], grid[5], grid[9], grid[13]});
        columns.add(new char[]{ grid[2], grid[6], grid[10], grid[14]});
        columns.add(new char[]{ grid[3], grid[7], grid[11], grid[15]});
        return columns;
    }

    @Override
    public ArrayList<char[]> makeDiagonals() {
        ArrayList<char[]> diagonals = new ArrayList<char[]>();
        diagonals.add(new char[]{ grid[0], grid[5], grid[10], grid[15]});
        diagonals.add(new char[]{ grid[3], grid[6], grid[9], grid[12]});
        return diagonals;
    }

    @Override
    public ArrayList<char[]> makeSolutions() {
        ArrayList<char[]> solutions = new ArrayList<char[]>();
        solutions.addAll(makeRows());
        solutions.addAll(makeColumns());
        solutions.addAll(makeDiagonals());
        return solutions;
    }

    @Override
    public boolean cellOccupied(int index) {
        return grid[index] != EMPTY;
    }

    @Override
    public void undoCell(int index) {
        grid[index] = EMPTY;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String getBoardString() {
        return  " " + getCell(0) + " | " + getCell(1) + " | " + getCell(2)+ " | " + getCell(3) +"\n" +
                "---+---+---+---\n" +
                " " + getCell(4) + " | " + getCell(5) + " | " + getCell(6) + " | " + getCell(7) + "\n" +
                "---+---+---+---\n" +
                " " + getCell(8) + " | " + getCell(9) + " | " + getCell(10) +  " | " + getCell(11) +"\n" +
                "---+---+---+---\n" +
                " " + getCell(12) + " | " + getCell(13) + " | " + getCell(14) +  " | " + getCell(15) +"\n";
    }
}
