package agh.cs.lab2;

public class HayStack {
    private Position position;

    public HayStack(Position pos) {
        this.position = pos;
    }

    public Position getPosition(){
        return this.position;
    }
    public String toString(){
        return "H";
    }
}
