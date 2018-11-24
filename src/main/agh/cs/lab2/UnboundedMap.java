package agh.cs.lab2;

//import org.omg.PortableInterceptor.ObjectReferenceFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class UnboundedMap extends AbstractWorldMap{

    private List<HayStack> hayStacks = new ArrayList<>();
   // List<Car> cars = new ArrayList<>();

    public UnboundedMap(List<HayStack> hayS) {
        this.hayStacks = hayS;
    }

   @Override
    public boolean isOccupied(Position position) {
//        for (int i = 0; i < cars.size(); i++) {
//            Car currentCar = cars.get(i);
//            if (currentCar.getPosition().equals(position)) {
//
//                return true;
//            }
//        }
        if (super.isOccupied(position)){
            return true;
       }
        for (int i = 0; i < hayStacks.size(); i++) {
            HayStack currentHS = hayStacks.get(i);
            if (currentHS.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

//    public boolean canMoveTo(Position position) {
//        if (this.isOccupied(position)) {
//            return false;
//        }
//        return true;
//    }
//    @Override
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
//        int carNum=this.cars.size();
//        System.out.println("carNum =" + carNum);
//        int currentCarNum;
//        Car currentCar;
//        for(int i=0; i<movesNumber; i++){
//            currentCarNum=i%carNum;
//            currentCar = cars.get(currentCarNum);
//            currentCar.move(directions[i]);
//            System.out.println("currentCar=" + currentCarNum);
//            System.out.println(currentCar.getPosition().x);
//            System.out.println(currentCar.getPosition().y);
//            System.out.println(currentCar.toString());
//            System.out.println(this.toString());
//        }
//        System.out.println(this.toString());
//    }

    public Object objectAt(Position pos){
        if (carHashMap.get(pos)!=null){
            return carHashMap.get(pos);
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
        Set<Position> keys = carHashMap.keySet();
        for (Position p : keys) {
            lowerLeft = lowerLeft.lowerLef(p);
            upperRight = upperRight.upperRight(p);
        }
        for(HayStack hs : this.hayStacks){
            lowerLeft=lowerLeft.lowerLef(hs.getPosition());
            upperRight=upperRight.upperRight(hs.getPosition());
        }

        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(lowerLeft, upperRight);
    }
}

