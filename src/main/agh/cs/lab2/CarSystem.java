package agh.cs.lab2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by student24 on 2018-10-08.
 */
public class CarSystem {
    public static void main(String[] args) {
        try {
            MoveDirection[] directions = new OptionsParser().parse(args);
            List<HayStack> hayStacks = new ArrayList<>();
            hayStacks.add(new HayStack(new Position(-5, -4)));
            hayStacks.add(new HayStack(new Position(7, 7)));
            hayStacks.add(new HayStack(new Position(3, 3)));
            hayStacks.add(new HayStack(new Position(2, 0)));
            UnboundedMap map = new UnboundedMap(hayStacks);
            map.place(new Car(map));
            map.place(new Car(map, 3, 4));
//            map.place(new Car(map, 3, 4));
            map.run(directions);
        }
        catch (IllegalArgumentException ex){
            System.out.println("Some Exception happened");
        }
    }

}
