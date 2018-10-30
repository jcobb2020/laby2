package agh.cs.lab2;

public class OptionsParser {

    public static MoveDirection[] parse(String[] args){
        MoveDirection[] dirs = new MoveDirection[args.length];
        int count = 0;
        for (String argument : args){

            if(argument.equalsIgnoreCase("l") || argument.equalsIgnoreCase("left")){
                dirs[count]=MoveDirection.LEFT;
            }
            else if (argument.equalsIgnoreCase("r") || argument.equalsIgnoreCase("right")){
                dirs[count]=MoveDirection.RIGHT;
            }
            else if (argument.equalsIgnoreCase("f") || argument.equalsIgnoreCase("forward")){
                dirs[count]=MoveDirection.FORWARD;
            }
            else if (argument.equalsIgnoreCase("b") || argument.equalsIgnoreCase("backward")){
                dirs[count]=MoveDirection.BACKWARD;

            }
            else {
                dirs[count]=MoveDirection.WRONG;
            }
            count ++;

        }
        return dirs;
    }

}
