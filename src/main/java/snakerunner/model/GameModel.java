package snakerunner.model;

public interface GameModel {
    
    void update();

    public void checkCollisions();

    public void loadLevel(Level level);

    public Level getLevel();

    public void resetLevel();

    public void nextLevel();

    public void startTimer();

    public void stopTimer();

    public int getTimeLeft();

    public boolean isGameOver();

    boolean hasWon();

    boolean hasLost();
}
