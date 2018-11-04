package agh.cs.lab2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by student24 on 2018-10-08.
 */
public class MapDirectionTest {

    @Test

    public void test1(){
        assertEquals(1,1);
    }
    @Test
    public void NextTEST(){
        MapDirection direction = MapDirection.NORTH;
        assertEquals(direction.next(), MapDirection.EAST);
        direction = direction.next();
        assertEquals(direction.next(), MapDirection.SOUTH);
        direction = direction.next();
        assertEquals(direction.next(), MapDirection.WEST);
        direction = direction.next();
        assertEquals(direction.next(), MapDirection.NORTH);

    }

    @Test
    public void PreviousTest(){
        MapDirection direction = MapDirection.NORTH;
        assertEquals(direction.previous(), MapDirection.WEST);
        direction = direction.previous();
        assertEquals(direction.previous(), MapDirection.SOUTH);
        direction = direction.previous();
        assertEquals(direction.previous(), MapDirection.EAST);
        direction = direction.previous();
        assertEquals(direction.previous(), MapDirection.NORTH);
        direction = direction.previous();

    }

    @Test
    public void toStirngTest(){
        assertEquals(MapDirection.NORTH.toString(), "Północ");
        assertEquals(MapDirection.SOUTH.toString(), "Południe");
        assertEquals(MapDirection.WEST.toString(), "Zachód");
        assertEquals(MapDirection.EAST.toString(), "Wschód");
    }

}
