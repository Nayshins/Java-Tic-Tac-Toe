package me.jakenations;

public interface Player {

    public char getMarker();

    public void makeMove(int index) throws Exception;

    public void selectMove() throws Exception;


}
