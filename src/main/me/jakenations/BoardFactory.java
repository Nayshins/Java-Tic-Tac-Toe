package me.jakenations;

public class BoardFactory {
    public Board createBoard(int input) {
        if (input == 1) {
            return new Board3x3();
        } else if (input == 2) {
            return new Board4x4();
        }
        return new Board3x3();
    }
}
