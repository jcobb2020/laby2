package agh.cs.lab2;

/**
 * Created by student24 on 2018-10-08.
 */
public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;



    public String toString() {
        switch (this){
            case NORTH:return "Północ";
            case SOUTH:return "Południe";
            case WEST:return "Zachód";
            case EAST:return "Wschód";
            default:return "_";
        }
    }
    public MapDirection next(){
        switch (this){
            case NORTH:return EAST;
            case SOUTH:return WEST;
            case WEST:return NORTH;
            case EAST:return SOUTH;
            default:return this;
        }
    }
    public MapDirection previous(){
        switch (this){
            case NORTH:return WEST;
            case SOUTH:return EAST;
            case WEST:return SOUTH;
            case EAST:return NORTH;
            default:return this;
        }
    }
}
