package me.jakenations;

import java.io.IOException;
import java.util.Queue;


public class MockConsole implements UI {
    private boolean welcomed = false;
    private boolean solicitedInput = false;
    private Queue<String> inputs;
    private boolean inputWarningSent = false;
    private boolean boardPrinted = false;
    public boolean isWinner = false;
    public boolean isDraw = false;
    public void welcome() {
        welcomed = true;
    }

    @Override
    public String getInput() throws IOException {
        return inputs.remove();
    }

    public void movePrompt() {
        solicitedInput = true;
    }

    public boolean isSolicitedInput() {
        return solicitedInput;
    }
    public boolean isWelcomed() {
        return welcomed;
    }

    public void setInput(Queue<String> incorrectInput) {
        this.inputs = incorrectInput;
    }

    public void printBoard(Board board){
        boardPrinted = true;
    }

    @Override
    public void winner(char marker) {
        isWinner = true;
    }

    @Override
    public void draw() {
        isDraw = true;
    }


    @Override
    public void print(String message) {

    }

    @Override
    public void spaceOccupied() {
        inputWarningSent = true;
    }

   public boolean validateMove(String input){
        if (input.matches("[1-9]")){
            return true;
        }
        invalidInput();
        return false;
    }

     public void invalidInput() {
        print("Invalid input!");
    }

    public boolean wasInputWarningSent() {
        return inputWarningSent;
    }

    public boolean isBoardPrinted() {
        return boardPrinted;
    }
}
