package agh.cs.lab2;

import java.util.*;

abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    // protected List<Car> cars = new ArrayList<>();
    protected Map<Position, Car> carHashMap = new HashMap<>();


    public boolean isOccupied(Position position) {
        if (objectAt (position) == null)
        {
            return false;
        }
        return true;
    }

    public boolean canMoveTo(Position position) {
        if (this.isOccupied(position)) {
            return false;
        }
        return true;
    }

    public boolean place(Car car) {
        if (this.canMoveTo(car.getPosition())) {
            //cars.add(car);
            carHashMap.put(car.getPosition(), car);
            return true;
        } else {
            throw new IllegalArgumentException(car.getPosition().toString() + " is occupied");
        }
    }

    public Object objectAt(Position pos) {
//        for (Car car : this.carHashMap) {
//            if (car.getPosition().equals(pos)) {
//                return car;
//            }
//        }
        return carHashMap.get(pos);
    }

    public void run(MoveDirection[] directions) {

        int movesNumber = directions.length;
        int carNum = this.carHashMap.size();
        int currentCarNum;
        Car currentCar;
        for (int i = 0; i < movesNumber; i++) {
            currentCarNum = i % carNum;
            currentCar = carHashMap.get(currentCarNum);
            int carPositionHash = currentCar.getPosition().hashCode();
            currentCar.move(directions[i]);
            carHashMap.remove(carPositionHash);
            carHashMap.put(currentCar.getPosition(), currentCar);
//            System.out.println("currentCar=" + currentCarNum);
//            System.out.println(currentCar.getPosition().x);
//            System.out.println(currentCar.getPosition().y);
//            System.out.println(currentCar.toString());
//            System.out.println(this.toString());
        }
        System.out.println(this.toString());
    }

    public String toString() {
        Position lowerLeft = new Position(0, 0);
        Position upperRight = new Position(0, 0);
        Set<Position> keys = carHashMap.keySet();
        for (Position p : keys) {
            lowerLeft = lowerLeft.lowerLef(p);
            upperRight = upperRight.upperRight(p);
        }
//        for(HayStack hs : this.hayStacks){
//            lowerLeft=lowerLeft.lowerLef(hs.getPosition());
//            upperRight=upperRight.upperRight(hs.getPosition());
//        }

        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(lowerLeft, upperRight);
    }

    public void positionChanged(Position oldPosition, Position newPosition) {
        Car auto = this.carHashMap.get(oldPosition);
        this.carHashMap.remove(oldPosition);
        this.carHashMap.put(newPosition, auto);
    }

}
