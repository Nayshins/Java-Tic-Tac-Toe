package me.jakenations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleUI implements UI {

    public void print(String string) {
        System.out.println(string);
    }

    public void welcome() {
        print("Welcome to Tic Tac Toe");
    }

    public String getInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        return input;
    }

    public void movePrompt(int boardSize) {
        print("Make a move by entering a number 1-" + boardSize);
    }

    public void spaceOccupied() {
        print("Invalid input");
    }

    public void winner(char marker) {
        print(marker + " is the winner!");
    }

    public void draw() {
        print("Game ended in a draw!");
    }

    @Override
    public boolean validateMove(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            invalidInput();
            return false;
        }
        return true;
    }

    public void invalidInput() {
        print("Invalid input! Try another square!");
    }

    public void gameTypePrompt() {
        print("To start a game please enter 1 for a 3 x 3 board or 2 for a 4 x 4 board");
        print("Will default to 3x3 game for any other number");
    }

    public void playerOnePrompt() {
        print("Select who will be player 1 this game");
        print("enter 1 for human ");
        print("enter 2 for computer ");
        print(("Default is human"));
    }

    public void playerTwoPrompt() {
        print("Select who will be player 2 this game");
        print("enter 1 for human ");
        print("enter 2 for computer ");
        print(("Default is human"));
    }

    @Override
    public int getGameInput() throws IOException {
        boolean validInput = false;
        int input = -1;
        while (!validInput) {
            try {
                validInput = true;
                input = Integer.parseInt(getInput());
            } catch (NumberFormatException e) {
                invalidInput();
                validInput = false;
            }
        }
        return input;
    }
}
