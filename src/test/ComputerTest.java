package test;

import main.ComputerPlayer;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Nayshins on 9/9/14.
 */
public class ComputerTest {
    @Test
    public void computerMarkerTest() {
        ComputerPlayer computer = new ComputerPlayer('X');
        assertEquals('X',computer.getMarker());
    }
}
