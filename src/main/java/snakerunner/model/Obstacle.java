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
 
    //Getter Widht
    public int getWidth(){
        return width;
    }

    //Getter Height
    public int getHeight(){
        return height;
    }

//We check if targetX is between x and x + width and targetY is between y and y + height
    public boolean isHit(int targetX, int targetY){
     return targetX>= this.x && targetX< this.x + this.width && 
            targetY>= this.y && targetY< this.y + this.height;
     

    }

    public Set<Point2D<Integer, Integer>> getOccupiedPositions(){
        Set<Point2D<Integer, Integer>> positions = new HashSet<>();
        for(int i = 0; i< width; i++){
            for (int j= 0; j< height; j++){
                positions.add(new Point2D<Integer,Integer>(x + i, y+j));
            }
        }
        return positions;
    }

    public static Set<Point2D<Integer, Integer>> generatePresetVerticalPipes() {
        Set<Point2D<Integer, Integer>> allPositions = new HashSet<>();

        //Obstacles. These are temporary obstacles. They may change
         //Pipes are distanced by 4 "blocks"
        Obstacle obs1 = new Obstacle(6, 3, 1, 10); 
        Obstacle obs2 = new Obstacle(10, 7, 1, 10); 
        Obstacle obs3 = new Obstacle(30, 10, 1, 10);
        Obstacle obs4 = new Obstacle(50, 15, 1, 10);
        Obstacle obs5 = new Obstacle(3, 15, 4, 1);

        
        allPositions.addAll(obs1.getOccupiedPositions());
        allPositions.addAll(obs2.getOccupiedPositions());
        allPositions.addAll(obs3.getOccupiedPositions());
        allPositions.addAll(obs4.getOccupiedPositions());
        allPositions.addAll(obs5.getOccupiedPositions());

        return allPositions;
    }

}
  

 