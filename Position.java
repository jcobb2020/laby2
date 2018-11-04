package agh.cs.lab2;

/**
 * Created by student24 on 2018-10-08.
 */
public class Position {
    public final int x;
    public final int y;
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return ("("+Integer.toString(x)+","+Integer.toString(y)+")");
    }

    public boolean smaller(Position pos){
        if(x<=pos.x&&y<=pos.y){
            return true;
        }
        return false;
   }
   public boolean larger(Position pos){
       if(x>=pos.x&&y>=pos.y){
           return true;
       }
       return false;
   }

    public Position lowerLef(Position pos){
        int x2;
        int y2;
        if(pos.x>x){
            x2=x;
        }
        else{
            x2=pos.x;
        }
        if(pos.y>y){
            y2=y;
        }
        else{
            y2=pos.y;
        }
        return new Position(x2,y2);
    }

    public Position upperRight(Position pos){
        int x2;
        int y2;
        if(pos.x<x){
            x2=x;
        }
        else{
            x2=pos.x;
        }
        if(pos.y<y){
            y2=y;
        }
        else{
            y2=pos.y;
        }
        return new Position(x2,y2);

    }

    public Position add(Position pos1){
        int x2 = pos1.x + x;
        int y2 = pos1.y + y;
        return new Position(x2, y2);
    }

    public boolean equals(Object other){
        if (this == other){
            return true;
        }
        if (!(other instanceof Position))
            return false;
        Position that = (Position) other;
        if(this.x == that.x && this.y == that.y){
            return true;
        }
        return false;
    }
   public boolean checkPosition(int a, int b) {
       if (this.smaller(new Position(a,a)) && this.larger(new Position(b,b))) {
          return true;
       }
       return false;
    }




}
