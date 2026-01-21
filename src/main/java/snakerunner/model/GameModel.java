package snakerunner.model;

public interface GameModel {
    
    public void update();

    public void checkCollisions();

    public void loadLevel(Level level);

    public void resetLevel();

    public void nextLevel();

    public void startTimer();

     public int getTimeLeft();

    public boolean isGameOver();
}
