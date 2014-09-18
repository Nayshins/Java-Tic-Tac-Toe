package me.jakenations;

import java.io.IOException;

public interface UI {

    public void welcome();

    public String getInput() throws IOException;

    void movePrompt(int boardSize);

    void spaceOccupied();

    void invalidInput();

    void winner(char marker);

    void draw();

    boolean validateMove(String input);

    void print(String message);
}
