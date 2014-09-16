package me.jakenations;

import java.io.IOException;

public interface UI {
    public void print(String string);

    public void welcome();

    public String getInput() throws IOException;

    void movePrompt();

    void spaceOccupied();

    void invalidInput();

    void printBoard();

    void winner(char marker);

    void draw();
}
