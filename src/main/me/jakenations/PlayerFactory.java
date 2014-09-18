package me.jakenations;

public class PlayerFactory {

    public Player createPlayer(int input, char marker, Board board, UI console, Rules rules) {
        if (input == 1){
            return new HumanPlayer(marker, board, console);
        } else if (input == 2) {
            return new ComputerPlayer(marker, board, rules);
        } else if (input == 3) {
            return new LazyComputer(marker, board);
        }
        return new HumanPlayer(marker, board, console);
    }
}
