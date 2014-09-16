package me.jakenations;

import java.util.ArrayList;


public interface  Rules {

    public boolean winner(ArrayList<char[]> solutions);

    public boolean draw();

    public boolean gameOver();

    public boolean winTest(char marker, ArrayList<char[]> chars);

    public boolean isDraw();
}
