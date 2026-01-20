package snakerunner.model;

public interface GameModel {
    
    public void update();

    public void checkCollisions();

    public boolean isGameOver();

    public void loadLevel(Level level);

    public void resetLevel();
}
