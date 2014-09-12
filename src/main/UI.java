package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Nayshins on 9/11/14.
 */
public interface UI {
        public void print(String string);

    public void welcome();

    public String getInput() throws IOException;

}
