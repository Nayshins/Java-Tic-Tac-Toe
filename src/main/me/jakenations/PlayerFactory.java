package me.jakenations;

public class PlayerFactory {

    public Player createPlayer(int input, char marker, Board board, UI console, Rules rules) {
        if (input == 1){
            return new HumanPlayer(marker, board, console);
        } else if (input == 2) {
            return new ComputerPlayer(marker, board, rules);
        }
        return new HumanPlayer(marker, board, console);
    }
}
