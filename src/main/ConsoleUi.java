package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Nayshins on 9/9/14.
 */
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
                " " + board.getCell(6) + " | " + board.getCell(7) + " | " + board.getCell(8);
        print(boardString);
    }
}
