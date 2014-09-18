package me.jakenations;

import java.io.IOException;
import java.util.Queue;


public class MockConsole implements UI {
    private boolean welcomed = false;
    private boolean solicitedInput = false;
    private Queue<Integer> inputs;
    private boolean inputWarningSent = false;
    private boolean boardPrinted = false;
    public boolean isWinner = false;
    public boolean isDraw = false;
    public void welcome() {
        welcomed = true;
    }

    @Override
    public String getInput() throws IOException {
        return null;
    }

    @Override
    public int getGameInput() throws IOException {
        return inputs.remove();
    }

    @Override
    public void playerOnePrompt() {

    }

    @Override
    public void playerTwoPrompt() {

    }

    @Override
    public void movePrompt(int boardSize) {
         solicitedInput = true;
    }



    public boolean isSolicitedInput() {
        return solicitedInput;
    }
    public boolean isWelcomed() {
        return welcomed;
    }

    public void setInput(Queue<Integer> incorrectInput) {
        this.inputs = incorrectInput;
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
    public void gameTypePrompt() {

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
        inputWarningSent = true;
    }

    public boolean wasInputWarningSent() {
        return inputWarningSent;
    }

    public boolean isBoardPrinted() {
        return boardPrinted;
    }
}
