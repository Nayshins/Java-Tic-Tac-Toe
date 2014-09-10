package main;

public class Main {

    public static void main(String[] args) {
	    Board board = new Board();
        Player player = new Player('X', board);
        ComputerPlayer computer = new ComputerPlayer('O', board);
        ConsoleUi console = new ConsoleUi();

    }
}
