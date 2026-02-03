package snakerunner.model;

public interface GameModel {
    
    public void update();

    public void checkCollisions();

    public void startTimer();

    public void stopTimer();

    public int getTimeLeft();

    public boolean isGameOver();

    public void loadLevel(Level level);

    public void resetLevel();

    public void nextLevel();

    //Added
    public java.util.Set<snakerunner.commons.Point2D<Integer,Integer>> getObstacles();
}
