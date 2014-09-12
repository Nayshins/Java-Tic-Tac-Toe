package main;

import java.io.IOException;

/**
 * Created by Nayshins on 9/10/14.
 */
public class MockConsole extends ConsoleUi {
    private boolean welcomed = false;


    @Override
    public void print(String string) {

    }

    public void welcome() {
        welcomed = true;
    }

    @Override
    public String getInput() throws IOException {
        return "1";
    }

    public boolean isWelcomed() {
        return welcomed;
    }
}
