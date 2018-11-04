package agh.cs.lab2;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class RectangularMapTest {

    @Test
    public void objectAtTest() {
        RectangularMap map = new RectangularMap(10, 10);
        map.place(new Car(map, 1, 1));
        map.place(new Car(map, 3, 3));
        assertTrue(map.objectAt(new Position(1, 1)).toString().equals("N"));
        assertTrue(map.objectAt(new Position(3, 3)).toString().equals("N"));
    }

    @Test
    public void runTest() {
        RectangularMap map = new RectangularMap(10, 10);
        map.cars.add(new Car(map, 3, 1));
        map.cars.add(new Car(map, 5, 4));
        MoveDirection[] dirs = {MoveDirection.FORWARD, MoveDirection.FORWARD,};
        map.run(dirs);
        assertTrue(map.cars.get(0).getPosition().equals(new Position(3, 2)));
        assertTrue(map.cars.get(1).getPosition().equals(new Position(5, 5)));
        MoveDirection[] dirs2 = {MoveDirection.BACKWARD, MoveDirection.FORWARD};
        map.run(dirs2);
        assertTrue(map.cars.get(0).getPosition().equals(new Position(3, 1)));
        assertTrue(map.cars.get(1).getPosition().equals(new Position(5, 6)));

    }


    @Test
    public void isOcupiedTest() {
        RectangularMap map = new RectangularMap(10, 10);
        map.cars.add(new Car(map, 3, 2));
        map.cars.add(new Car(map, 5, 4));
        assertTrue(map.isOccupied(new Position(3, 2)));
        assertTrue(map.isOccupied(new Position(5, 4)));
    }

    @Test
    public void placeTest() {
        IWorldMap map = new RectangularMap(10, 10);
        map.place(new Car(map, 5, 5));
        assertFalse(map.place(new Car(map, 14, 2)));
        assertFalse(map.place(new Car(map, 5, 5)));
        assertTrue(map.place(new Car(map, 1, 1)));
    }
    @Test
    public void canMoveToTest() {
        IWorldMap map = new RectangularMap(10,10);
        map.place(new Car(map, 5, 5));
        assertTrue(map.canMoveTo(new Position(5, 4)));
        assertFalse(map.canMoveTo(new Position(88, 88)));
        assertFalse(map.canMoveTo(new Position(5, 5)));
    }
}