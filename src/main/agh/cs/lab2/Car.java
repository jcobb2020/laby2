package agh.cs.lab2;
import java.util.ArrayList;
import java.util.List;
//import com.sun.java.util.jar.pack.Instruction;

public class Car extends AbstractWorldObject {
    private MapDirection direction = MapDirection.NORTH;
    private IWorldMap map;

    public String toString() {
        switch (this.direction) {
            case SOUTH:
                return "S";
            case NORTH:
                return "N";
            case WEST:
                return "W";
            case EAST:
                return "E";
            default:
                return "XD?";
        }
        // return "D";
        //stara metoda toString
        //  return (this.position + " " + this.direction);
    }

    public Car(IWorldMap map) {
        this.map = map;
        this.position = new Position(2,2);
    }

    public Car(IWorldMap map, int x, int y) {
        this.map = map;
        this.position = new Position(x, y);
    }


//    public static void main(String[] args) {
//        MoveDirection[] directions = new OptionsParser().parse(args);
//        List<HayStack> hayStacks = new ArrayList<>();
//        hayStacks.add(new HayStack(new Position(-4, -4)));
//        hayStacks.add(new HayStack(new Position(7, 7)));
//        hayStacks.add(new HayStack(new Position(3, 3)));
//        hayStacks.add(new HayStack(new Position(2, 0)));
//
//
//        UnboundedMap map = new UnboundedMap(hayStacks);
////        System.out.println(map.toString());
//
//        map.place(new Car(map));
//        map.place(new Car(map,3,4));
//        map.run(directions);
//
//
//
//    }

    public void move(MoveDirection dir) {

        switch (dir) {
            case WRONG:
                return;
            case LEFT:
                this.direction = this.direction.previous();
                return;
            case RIGHT:
                this.direction = this.direction.next();
                return;
            default:
                break;

        }
        int sign = 1;
        if (dir == MoveDirection.BACKWARD) {
            sign = -1;
        }
        switch (this.direction) {
            case WEST:
                sign = sign * -1;
                break;
            case SOUTH:
                sign = sign * -1;
                break;
            default:
                break;

        }
        Position newPosition;
        Position vectorX = new Position(sign, 0);
        Position vectorY = new Position(0, sign);
        if (this.direction == MapDirection.NORTH || this.direction == MapDirection.SOUTH) {
            newPosition = this.position.add(vectorY);
        } else {
            newPosition = this.position.add(vectorX);
        }
        if (this.map.canMoveTo(newPosition)) {   // new chceking move avability
            this.position = newPosition;
        }
    }
}


/*case FORWARD:
                switch (direction) {
                    case NORTH:
                        Position newPositionN = new Position(position.x, position.y + 1);
                        position = newPositionN;
                        break;
                    case SOUTH:
                        Position newPositionS = new Position(position.x, position.y - 1);
                        position = newPositionS;
                        break;
                    case EAST:
                        Position newPositionE = new Position(position.x + 1, position.y);
                        position = newPositionE;
                        break;
                    case WEST:
                        Position newPositionW = new Position(position.x - 1, position.y);
                        position = newPositionW;
                        break;

                    // default:
                    // break;
                }
                position = checkPosition(position);
                System.out.println(position);
                break;
            case BACKWARD:
                switch (this.direction) {
                    case NORTH:
                        Position newPositionN = new Position(this.position.x, this.position.y - 1);
                        this.position = newPositionN;
                        break;
                    case SOUTH:
                        Position newPositionS = new Position(this.position.x, this.position.y + 1);
                        this.position = newPositionS;
                        break;
                    case EAST:
                        Position newPositionE = new Position(this.position.x - 1, this.position.y);
                        this.position = newPositionE;
                        break;
                    case WEST:
                        Position newPositionW = new Position(this.position.x + 1, this.position.y);
                        this.position = newPositionW;
                        break;
                }
                break;
                */