package agh.cs.lab2;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class RectangularMapTest {
    @Test
    public void isOccupiedTest(){
        IWorldMap map = new RectangularMap(10,10);
        assertFalse(map.isOccupied(new Position(3,3)));
        map.place(new Car(map, 5,5));
        assertTrue(map.isOccupied(new Position(5,5)));
    }

}
