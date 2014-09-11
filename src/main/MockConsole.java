package main;

/**
 * Created by Nayshins on 9/10/14.
 */
public class MockConsole extends ConsoleUi {
    private int updated;

    public void updateBoard() {
        updated += 1;
    }

    public int getUpdated() {
        return updated;
    }
}
