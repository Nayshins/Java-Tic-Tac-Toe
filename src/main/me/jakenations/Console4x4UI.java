package me.jakenations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console4x4UI implements UI {
    @Override
    public void welcome() {
        print("Welcome to 4x4 Tic Tac Toe!\n");
    }

    public void print(String string) {
        System.out.println(string);
    }


    @Override
    public String getInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        return input;
    }

    @Override
    public void movePrompt() {
        print("Make a move by entering a number 1-9");
    }

    @Override
    public void spaceOccupied() {
        print("Space already filled please choose another");
    }

    @Override
    public void invalidInput() {
        print("Invalid input! Please enter a number 1 - 16!");
    }

    @Override
    public void printBoard(Board board ) {
          String boardString =  " " + board.getCell(0) + " | " + board.getCell(1) + " | " + board.getCell(2)+ " | " + board.getCell(3) +"\n" +
                "---+---+---+---\n" +
                " " + board.getCell(4) + " | " + board.getCell(5) + " | " + board.getCell(6) + " | " + board.getCell(7) + "\n" +
                "---+---+---+---\n" +
                " " + board.getCell(8) + " | " + board.getCell(9) + " | " + board.getCell(10) +  " | " + board.getCell(11) +"\n" +
                "---+---+---+---\n" +
                " " + board.getCell(12) + " | " + board.getCell(13) + " | " + board.getCell(14) +  " | " + board.getCell(15) +"\n";
            print(boardString);
    }

    @Override
    public void winner(char marker) {
         print(marker + " is the winner!");
    }

    @Override
    public void draw() {
        print("Game ended in a draw!");
    }
    public boolean validateMove(String input){
        if (input.matches("^(1[0-6]?|[2-9])$")){
            return true;
        }
        invalidInput();
        return false;
    }
}
