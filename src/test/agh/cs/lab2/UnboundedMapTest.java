package agh.cs.lab2;

import javafx.geometry.Pos;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class UnboundedMapTest {
    List<HayStack> hayStacks = new ArrayList<>();

    @Test
    public void isOccupiedTest() {
        this.hayStacks.add(new HayStack(new Position(3, 3)));
        IWorldMap map = new UnboundedMap(hayStacks);
        assertTrue(map.isOccupied(new Position(3, 3)));
        map.place(new Car(map, 5, 5));
        assertTrue(map.isOccupied(new Position(5, 5)));
    }

    @Test
    public void canMoveToTest() {
        this.hayStacks.add(new HayStack(new Position(3, 3)));
        IWorldMap map = new UnboundedMap(hayStacks);
        map.place(new Car(map, 5, 5));
        assertTrue(map.canMoveTo(new Position(5, 4)));
        assertTrue(map.canMoveTo(new Position(88, 88)));
        assertFalse(map.canMoveTo(new Position(5, 5)));
        assertFalse(map.canMoveTo(new Position(3, 3)));
    }

    @Test
    public void placeTest() {
        this.hayStacks.add(new HayStack(new Position(3, 3)));
        IWorldMap map = new UnboundedMap(hayStacks);
        map.place(new Car(map, 5, 5));
        assertTrue(map.place(new Car(map, 14, 2)));
        assertFalse(map.place(new Car(map, 5, 5)));
        assertFalse(map.place(new Car(map, 3, 3)));
        assertFalse(map.place(new Car(map, 5, 5)));
        assertFalse(map.place(new Car(map, 5, 5)));
    }

    @Test
    public void runTest() {
        this.hayStacks.add(new HayStack(new Position(3, 3)));
        UnboundedMap map = new UnboundedMap(hayStacks);
        map.cars.add(new Car(map, 3, 2));
        map.cars.add(new Car(map, 5, 4));
        MoveDirection[] dirs = {MoveDirection.FORWARD, MoveDirection.FORWARD,};
        map.run(dirs);
        assertTrue(map.cars.get(0).getPosition().equals(new Position(3, 2)));
        assertTrue(map.cars.get(1).getPosition().equals(new Position(5, 5)));
    }

    @Test
    public void isOcupiedTest() {
        UnboundedMap map = new UnboundedMap(hayStacks);
        map.cars.add(new Car(map, 3, 2));
        map.cars.add(new Car(map, 5, 4));
        assertTrue(map.isOccupied(new Position(3, 2)));
        assertTrue(map.isOccupied(new Position(5, 4)));
        hayStacks.add(new HayStack(new Position(3, 3)));
        assertTrue(map.isOccupied(new Position(3, 3)));
    }
    @Test
    public void objectAtTest(){
        UnboundedMap map = new UnboundedMap(hayStacks);
        map.place(new Car(map, 1,1));
        hayStacks.add(new HayStack(new Position(3,3)));
        assertTrue(map.objectAt(new Position(1,1)).toString().equals("N"));
        assertTrue(map.objectAt(new Position(3,3)).toString().equals("H"));

    }
}
