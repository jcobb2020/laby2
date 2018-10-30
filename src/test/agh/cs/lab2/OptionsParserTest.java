package agh.cs.lab2;

import javafx.geometry.Pos;
import org.junit.Test;
import static org.junit.Assert.*;


public class OptionsParserTest {
    @Test
    public void parseTest(){

        MoveDirection[] moveDirectionTab = {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD,MoveDirection.BACKWARD,
                MoveDirection.BACKWARD,MoveDirection.BACKWARD,MoveDirection.LEFT,MoveDirection.LEFT,MoveDirection.LEFT,
                MoveDirection.RIGHT,MoveDirection.RIGHT,MoveDirection.RIGHT,MoveDirection.RIGHT,MoveDirection.WRONG};
        String[] stringTab = {"forward", "FoRwARD", "f", "backward", "BaCkward", "b", "left", "L", "LEFt",
                "right", "r", "R", "RiGhT", "XDDD"};
        assertArrayEquals(moveDirectionTab, OptionsParser.parse(stringTab));
    }
}
