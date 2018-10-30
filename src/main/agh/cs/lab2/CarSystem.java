package agh.cs.lab2;
import java.util.Arrays;

/**
 * Created by student24 on 2018-10-08.
 */
public class CarSystem {
    public static void main(String[] args){
        Position position1 = new Position(1,2);
        System.out.println(position1);
        Position position2 = new Position(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        MapDirection dir = MapDirection.NORTH;
        System.out.println(dir);
        System.out.println(dir.next());
        dir = dir.next();
        dir = dir.previous();
        System.out.println(dir);



    }

}
