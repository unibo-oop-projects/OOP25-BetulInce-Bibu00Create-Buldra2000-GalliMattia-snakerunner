package snakerunner.model;

import java.util.List;
import java.util.Set;

import snakerunner.commons.Point2D;

public interface GameModel {
    
    /** 
     * Updates the game state. 
     */
    void update();

    /** 
     * Checks if the game is over. 
     */
    boolean isGameOver();

    /** 
     * Loads a level from the given data. 
     */
    void loadLevel(LevelData data);

    /** 
     * Resets the current level to its initial state. 
     */
    void resetLevel();

    /** 
     * Returns the snake in the game. 
     */
    Snake getSnake();

    /** 
     * Returns the list of collectibles in the game. 
     */
    List<Collectible> getCollectibles();

    /** 
     * Returns the current level. 
     */
    Level getLevel();


    //Adding obstacles
    Set<Point2D<Integer, Integer>> getObstacles();
    
    /**
     * Checks if the current level is completed.
     * @return true if the level is completed, false otherwise.
     */
    boolean isLevelCompleted();

    /** Adds points to the player's score. 
     * @param points The number of points to add to the score.
     */
    void addScore(int points);

    /** 
     * Returns the current score. 
     * @return The current score.
     */
    int getScore();
    
    /** 
     * Applies the slow effect to the game after the snake consumes a clock.
     */
    void applySlowEffect();

    /** 
     * Returns the current speed of the game. 
     * @return The current speed of the game.
     */
    int getSpeed();

    /**
     * Open doors
    */
    void openDoor();
    
}
