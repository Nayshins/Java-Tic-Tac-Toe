package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Nayshins on 9/9/14.
 */
public class ConsoleUi implements UI {
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

}
