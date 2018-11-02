package agh.cs.lab2;

import org.omg.PortableInterceptor.ObjectReferenceFactory;

import java.util.ArrayList;
import java.util.List;


public class UnboundedMap implements IWorldMap{


    List<HayStack> hayStacks;
    List<Car> cars = new ArrayList<>();

    public UnboundedMap(List<HayStack> hayS) {
        this.hayStacks = hayS;
    }

   @Override
    public boolean isOccupied(Position position) {
        for (int i = 0; i < cars.size(); i++) {
            Car currentCar = cars.get(i);
            if (currentCar.getPosition().equals(position)) {

                return true;
            }
        }
        for (int i = 0; i < hayStacks.size(); i++) {
            HayStack currentHS = hayStacks.get(i);
            if (currentHS.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean canMoveTo(Position position) {
        if (this.isOccupied(position)) {
            return false;
        }
        return true;
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
        int carNum=this.cars.size();
        System.out.println("carNum =" + carNum);
        int currentCarNum;
        Car currentCar;
        for(int i=0; i<movesNumber; i++){
            currentCarNum=i%carNum;
            currentCar = cars.get(currentCarNum);
            currentCar.move(directions[i]);
           /* System.out.println("currentCar=" + currentCarNum);
            System.out.println(currentCar.getPosition().x);
            System.out.println(currentCar.getPosition().y);
            System.out.println(currentCar.toString());
            System.out.println(this.toString()); */
        }
        System.out.println(this.toString());
    }
    @Override
    public Object objectAt(Position pos){
        for(Car car : this.cars){
            if (car.getPosition().equals(pos)){
                return car;
            }
        }
        for(HayStack hS : this.hayStacks){
            if (hS.getPosition().equals(pos)){
                return hS;
            }
        }
        return null;
    }

    public String toString (){
        Position lowerLeft = new Position(0,0);
        Position upperRight = new Position(0,0);
        for(Car auto : this.cars){
            lowerLeft=lowerLeft.lowerLef(auto.getPosition());
            upperRight=upperRight.upperRight(auto.getPosition());
        }
        for(HayStack hs : this.hayStacks){
            lowerLeft=lowerLeft.lowerLef(hs.getPosition());
            upperRight=upperRight.upperRight(hs.getPosition());
        }

        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(lowerLeft, upperRight);
    }
}

