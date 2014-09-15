package main;

import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by Nayshins on 9/8/14.
 */
public interface  Rules {


    public boolean winner(ArrayList<char[]> solutions);

    public boolean draw(ArrayList<Integer> empties);

    public boolean gameOver(Board board);



    public boolean winTest(char marker, ArrayList<char[]> chars);




    public boolean isDraw();
}
