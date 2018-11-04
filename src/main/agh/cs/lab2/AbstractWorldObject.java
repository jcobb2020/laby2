package agh.cs.lab2;

abstract class AbstractWorldObject {
    protected Position position;

//    public AbstractWorldObject(){
//        this.position=new Position(0,0);
//    }
    public Position getPosition(){
        return this.position;
    }
}
