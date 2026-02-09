package snakerunner.controller;

import java.util.List;
import java.util.Set;

import snakerunner.commons.Point2D;
import snakerunner.model.Collectible;
import snakerunner.model.Direction;
import snakerunner.model.Door;
import snakerunner.model.Snake;

public interface WorldController {

    /**
     * Get Snake.
     * 
     * @return the Snake instance from the model.
     */
    Snake getSnake();

    /**
     * Get obstacles from Model (Controller - Model).
     * 
     * @return a set of Point2D representing the positions of the obstacles.
     */
    Set<Point2D<Integer, Integer>> getObstacles();

    /** 
     * Get Collectibles from Model (Controller - Model).
     * 
     * @return a list of Collectible objects from the model.
     */
    List<Collectible> getCollectibles();

    /**
     * Get Doors from Model (Controller - Model)
     * @return
     */
    List<Door> getDoors();

    /**
     * Get Level from Model (Controller - Model)
     * @return
     */
    int getLevel();

    /**
     * Get Score from Model (Controller - Model).
     * 
     * @return the current score.
     */
    int getScore();

    /**
     * Get Direction from Model (Controller - Model)
     * 
     * @return the current direction of the snake.
     */
    Direction getDirection();
    
}
