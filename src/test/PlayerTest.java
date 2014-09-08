package test;

import main.Player;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Nayshins on 9/8/14.
 */
public class PlayerTest {
    @Test
    public void markerTest() {
        Player player = new Player('X');
        assertEquals('X', player.getMarker());
    }
}
