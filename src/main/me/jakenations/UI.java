package me.jakenations;

import java.io.IOException;

/**
 * Created by Nayshins on 9/11/14.
 */
public interface UI {
        public void print(String string);

    public void welcome();

    public String getInput() throws IOException;

}