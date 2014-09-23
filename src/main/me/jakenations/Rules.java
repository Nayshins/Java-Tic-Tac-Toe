package me.jakenations;

import java.util.ArrayList;


public interface  Rules {

    public boolean winner(ArrayList<char[]> solutions);

    public boolean isDraw();

    public boolean isGameOver();

    public boolean isMarkerWinner(char marker, ArrayList<char[]> chars);


}
