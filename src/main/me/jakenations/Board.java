package me.jakenations;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {
    private final char empty = ' ';

    private char[] grid = new char[]{empty, empty, empty, empty, empty, empty, empty, empty, empty};

    public char[] getGrid() {
        return grid;
    }

    public char getCell(int index) {
        return grid[index];
    }

    public void setCell(char marker, int index) throws Exception {
        if (cellOccupied(index)){
            throw new Exception();
        } else {
            grid[index] = marker;
        }
    }

    public ArrayList<Integer> getLocations(char marker) {
        ArrayList<Integer> locations = new ArrayList<Integer>();
        for (int i = 0; i < grid.length; i++) {
            if (grid[i] == marker) {
                locations.add(i);
            }
        }
        return locations;
    }

    public ArrayList<Integer> getEmpty() {
        ArrayList<Integer> emptyLocations = new ArrayList<Integer>();
        for (int i = 0; i < grid.length; i++) {
            checkIfCharIsEmpty(emptyLocations, i);
        }
        return emptyLocations;
    }

    private void checkIfCharIsEmpty(ArrayList<Integer> emptyLocations, int i) {
        if (grid[i] == empty) {
            emptyLocations.add(i);
        }
    }

    public ArrayList<char[]> makeRows() {
        ArrayList<char[]> rows = new ArrayList<char[]>();
        rows.add(Arrays.copyOfRange(grid,0,3));
        rows.add(Arrays.copyOfRange(grid,3,6));
        rows.add(Arrays.copyOfRange(grid,6,grid.length));
        return rows;
    }

    public ArrayList<char[]> makeColumns() {
        ArrayList<char[]> columns = new ArrayList<char[]>();
        columns.add(new char[]{ grid[0], grid[3], grid[6]});
        columns.add(new char[]{ grid[1], grid[4], grid[7]});
        columns.add(new char[]{ grid[2], grid[5], grid[8]});
        return columns;
    }

    public ArrayList<char[]> makeDiagonals() {
        ArrayList<char[]> diagonals = new ArrayList<char[]>();
        diagonals.add(new char[]{ grid[0], grid[4], grid[8]});
        diagonals.add(new char[]{ grid[2], grid[4], grid[6]});
        return diagonals;
    }

    public ArrayList<char[]> makeSolutions() {
        ArrayList<char[]> solutions = new ArrayList<char[]>();
        solutions.addAll(makeRows());
        solutions.addAll(makeColumns());
        solutions.addAll(makeDiagonals());
        return solutions;
    }

    public boolean cellOccupied(int index) {
        if (grid[index] != empty){
            return true;
        } else {
            return false;
        }
    }

    public char getEmptyChar(){
        return empty;
    }

    public void undoCell(int index) {
        grid[index] = empty;
    }
}
