package me.jakenations;

/**
 * Created by Nayshins on 9/18/14.
 */
public class RulesFactory {
    public Rules createRules(int input, Board board) {
        if (input == 1) {
            return new GameRules(board);
        } else if (input == 2) {
            return new GameRules4x4(board);
        }

        return null;
    }
}
