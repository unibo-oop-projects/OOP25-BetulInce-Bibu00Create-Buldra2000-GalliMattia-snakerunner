package snakerunner.model;

import java.util.HashSet;
import java.util.Set;

import snakerunner.commons.Point2D;

public class Obstacle extends Entity{
    
//Dimensions in grid
    private int width;
    private int height;

    //Obstacle's inital positions and dimensions
    public Obstacle(int x, int y, int width, int height){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
    }
 
    //Getter Width
    public int getWidth(){
        return width;
    }

    //Getter Height
    public int getHeight(){
        return height;
    }

//We check if targetX is between x and x + width and targetY is between y and y + height (the area)
    public boolean isHit(int targetX, int targetY){
     return targetX>= this.x && targetX< this.x + this.width && //Checking if x is between the beginning and the end of the obstacle
            targetY>= this.y && targetY< this.y + this.height;//Checking if the y is between the beginning and the end of the obstacle
     

    }

    //We use this method to get the occupied positions by transforming them into a set
    public Set<Point2D<Integer, Integer>> getOccupiedPositions(){
        Set<Point2D<Integer, Integer>> positions = new HashSet<>();
        for(int i = 0; i< width; i++){ //iterates through width and then height
            for (int j= 0; j< height; j++){
                //adds a new "point" to the set for every cell that's occupied
                positions.add(new Point2D<Integer,Integer>(x + i, y+j));
            }
        }
        return positions;
    }



}
  

 