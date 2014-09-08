package main;

import java.util.ArrayList;

/**
 * Created by Nayshins on 9/8/14.
 */
public class Rules {
    public boolean winner(ArrayList<char[]> solutions) {
        for (char[] solution : solutions) {
            char first = solution[0];
            if (first == ' ') {
                continue;
            } else if(first == solution[1] & first == solution[2]) {
                return true;
            }
        }
        return false;
    }
}
