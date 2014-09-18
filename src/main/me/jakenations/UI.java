package me.jakenations;

import java.io.IOException;

public interface UI {

    public void welcome();

    public String getInput() throws IOException;

    void movePrompt();

    void spaceOccupied();

    void invalidInput();

    void printBoard(Board board);

    void winner(char marker);

    void draw();

    boolean validateMove(String input);

    void print(String message);
}
