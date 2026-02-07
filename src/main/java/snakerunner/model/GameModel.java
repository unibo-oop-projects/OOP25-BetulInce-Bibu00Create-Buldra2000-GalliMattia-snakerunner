package snakerunner.model;

import java.util.List;

public interface GameModel {
    
    /** 
     * Updates the game state. 
     */
    public void update();

    /** 
     * Checks if the game is over. 
     */
    public boolean isGameOver();

    /** 
     * Loads a level from the given data. 
     */
    public void loadLevel(LevelData data);

    /** 
     * Resets the current level to its initial state. 
     */
    public void resetLevel();

    /** 
     * Returns the snake in the game. 
     */
    public Snake getSnake();

    /** 
     * Returns the list of collectibles in the game. 
     */
    public List<Collectible> getCollectibles();

    /** 
     * Returns the current level. 
     */
    public Level getLevel();

    //public Level nextLevel();

    //Adding obstacles
    public java.util.Set<snakerunner.commons.Point2D<Integer,Integer>> getObstacles();
    
    /**
     * Checks if the current level is completed.
     * @return true if the level is completed, false otherwise.
     */
    public boolean isLevelCompleted();

    /** Adds points to the player's score. 
     * @param points The number of points to add to the score.
     */
    public void addScore(int points);

    /** 
     * Returns the current score. 
     * @return The current score.
     */
    public int getScore();
    
    /** 
     * Applies the slow effect to the game after the snake consumes a clock.
     */
    public void applySlowEffect();

    /** 
     * Returns the current speed of the game. 
     * @return The current speed of the game.
     */
    public int getSpeed();
}
