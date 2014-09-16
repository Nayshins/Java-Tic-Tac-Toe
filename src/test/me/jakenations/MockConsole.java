package me.jakenations;

import java.io.IOException;
import java.util.Queue;


public class MockConsole implements UI {
    private boolean welcomed = false;
    private boolean solicitedInput = false;
    private Queue<String> inputs;
    private boolean inputWarningSent = false;
    private boolean boardPrinted = false;
    private Board board;

    public MockConsole(Board board) {
        this.board = board;
    }


    @Override
    public void print(String string) {

    }

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

    public void printBoard(){
        boardPrinted = true;
    }

    @Override
    public void winner(char marker) {

    }

    @Override
    public void draw() {

    }


    @Override
    public void spaceOccupied() {
        inputWarningSent = true;
    }

    @Override
    public void invalidInput() {

    }

    public boolean wasInputWarningSent() {
        return inputWarningSent;
    }

    public boolean isBoardPrinted() {
        return boardPrinted;
    }
}
