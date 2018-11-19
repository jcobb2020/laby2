package agh.cs.lab2;

//import javafx.geometry.Pos;
import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {
    @Test
    public void toStringTest() {
        int x = 2010;
        int y = 1337;
        Position pos = new Position(x, y);
        assertEquals(pos.toString(), ("(2010,1337)"));
    }

    @Test
    public void smallerTest() {
        assertFalse(new Position(5, 7).smaller(new Position(2, -2)));
        assertFalse(new Position(13, -13).smaller(new Position(12, 12)));
        assertTrue(new Position(-5, -10).smaller(new Position(-1, -2)));
    }

    @Test
    public void largerTest() {
        assertTrue(new Position(13, 28).larger(new Position(10, 5)));
        assertFalse(new Position(-13, 28).larger(new Position(10, 5)));
        assertFalse(new Position(1, 6).larger(new Position(10, 15)));

    }

    @Test
    public void lowerLeftTest(){
        assertEquals(new Position(-3, 5).lowerLef(new Position(4,1)).toString(), ("(-3,1)"));
        assertEquals(new Position(12, 88).lowerLef(new Position(10,4)).toString(), ("(10,4)"));
    }

    @Test
    public void upperRightTest(){
        assertEquals(new Position(-3, 5).upperRight(new Position(4,1)).toString(), ("(4,5)"));
        assertEquals(new Position(12, 88).upperRight(new Position(10,4)).toString(), ("(12,88)"));
        assertEquals(new Position(99, 1).upperRight(new Position(10,40)).toString(), ("(99,40)"));
    }

    @Test
    public void addTest(){
        assertEquals(new Position(5,20).add(new Position(10,30)).toString(), "(15,50)");
        assertNotEquals(new Position(10,-20).add(new Position(10,30)).toString(), "(20,50)");
    }

    @Test

    public void equalsTest(){
        assertTrue(new Position(3,4).equals(new Position(3,4)));
        assertFalse(new Position(1,2).equals("3,4"));
        assertFalse(new Position(5,5).equals(new Position(44,90)));
        assertFalse(new Position(5,0).equals(5));
    }

    @Test

    public void checkPositionTest(){
        assertFalse(new Position(5,5).checkPosition(4,0));
        assertFalse(new Position(5,4).checkPosition(4,0));
        assertTrue(new Position(4,4).checkPosition(4,0));
        assertTrue(new Position(0,0).checkPosition(4,0));
        assertFalse(new Position(-1,0).checkPosition(4,0));
    }

}
