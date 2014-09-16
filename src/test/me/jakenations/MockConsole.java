package me.jakenations;

import java.io.IOException;
import java.util.Queue;

/**
 * Created by Nayshins on 9/10/14.
 */
public class MockConsole extends ConsoleUi {
    private boolean welcomed = false;
    private boolean solicitedInput = false;
    private Queue<String> inputs;
    private boolean inputWarningSent = false;
    private boolean boardPrinted = false;


    public MockConsole(Board board) {
        super(board);
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
//          return "1";
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
    public void spaceOccupied() {
        inputWarningSent = true;
    }

    public boolean wasInputWarningSent() {
        return inputWarningSent;
    }

    public boolean isBoardPrinted() {
        return boardPrinted;
    }
}
