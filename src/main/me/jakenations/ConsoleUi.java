package me.jakenations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleUi implements UI {
    private Board board;

    public ConsoleUi(Board board) {
        this.board = board;
    }

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

    public void movePrompt() {
        print("Make a move by entering a number 1-9");
    }

    public void printBoard() {
        String boardString =  " " + board.getCell(0) + " | " + board.getCell(1) + " | " + board.getCell(2)+ "\n" +
                "---+---+---\n" +
                " " + board.getCell(3) + " | " + board.getCell(4) + " | " + board.getCell(5) + "\n" +
                "---+---+---\n" +
                " " + board.getCell(6) + " | " + board.getCell(7) + " | " + board.getCell(8) +"\n";
        print(boardString);
    }

    public void spaceOccupied() {
        print("Space already filled please choose another");
    }

    public void winner(char marker) {
        print(marker + " is the winner!");
    }

    public void computerMove() {
        print("Computer is making it's move");
    }

    public void draw() {
        print("Game ended in a draw!");
    }

    public void invalidInput() {
        print("Invalid input!");
    }
}
