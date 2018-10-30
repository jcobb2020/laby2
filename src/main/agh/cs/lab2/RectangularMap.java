package agh.cs.lab2;


import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    int height, width;
    List<Car> cars = new ArrayList<>();

    public RectangularMap(int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Override
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

    @Override
    public boolean isOccupied(Position position) {
        for (int i = 0; i < cars.size(); i++) {
            Car currentCar = cars.get(i);
            if (currentCar.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean place(Car car) {
        if (this.canMoveTo(car.getPosition())) {
            cars.add(car);
            return true;
        }
        System.out.println("placeError");
        return false;
    }

    @Override
    public void run(MoveDirection[] directions) {

        int movesNumber = directions.length;
        int carNum = this.cars.size();
        System.out.println("carNum =" + carNum);
        int currentCarNum;
        Car currentCar;
        for (int i = 0; i < movesNumber; i++) {
            currentCarNum = i % carNum;
            currentCar = cars.get(currentCarNum);
            currentCar.move(directions[i]);
            System.out.println(this.isOccupied(currentCar.getPosition()));

           /* System.out.println("currentCar=" + currentCarNum);
            System.out.println(currentCar.getPosition().x);
            System.out.println(currentCar.getPosition().y);
            System.out.println(currentCar.toString());
            System.out.println(this.toString()); */

        }
        System.out.println(this.toString());


    }

    @Override
    public Car objectAt(Position pos) {
        for (Car car : this.cars) {
            if (car.getPosition().equals(pos)) {
                return car;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);

        return visualizer.draw(new Position(0, 0), new Position(width, height));

    }


}
