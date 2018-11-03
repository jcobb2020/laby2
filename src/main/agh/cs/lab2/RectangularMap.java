package agh.cs.lab2;


import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {
    int height, width;
//    List<Car> cars = new ArrayList<>();

    public RectangularMap(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public boolean canMoveTo(Position position) {
        if (this.isOccupied(position)) {
            return false;
        }
        if (position.x <= width && position.y <= height) {
            if (position.x >= 0 && position.y >= 0) {
                return true;
            }
        }
        return false;
    }

//    public boolean isOccupied(Position position) {
//        for (int i = 0; i < cars.size(); i++) {
//            Car currentCar = cars.get(i);
//            if (currentCar.getPosition().equals(position)) {
//                return true;
//            }
//        }
//        return false;
//    }

//    public boolean place(Car car) {
//        if (this.canMoveTo(car.getPosition())) {
//            cars.add(car);
//            return true;
//        }
//        System.out.println("placeError");
//        return false;
//    }

//    public void run(MoveDirection[] directions) {
//
//        int movesNumber = directions.length;
//        int carNum = this.cars.size();
//        System.out.println("carNum =" + carNum);
//        int currentCarNum;
//        Car currentCar;
//        for (int i = 0; i < movesNumber; i++) {
//            currentCarNum = i % carNum;
//            currentCar = cars.get(currentCarNum);
//            currentCar.move(directions[i]);
//            System.out.println(this.isOccupied(currentCar.getPosition()));
//        }
//        System.out.println(this.toString());
//    }

//    public Car objectAt(Position pos) {
//        for (Car car : this.cars) {
//            if (car.getPosition().equals(pos)) {
//                return car;
//            }
//        }
//        return null;
//    }

//    public String toString() {
//        MapVisualizer visualizer = new MapVisualizer(this);
//        return visualizer.draw(new Position(0, 0), new Position(width, height));
//    }
}
