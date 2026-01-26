package snakerunner.model;

public interface GameModel {
    
    public void update();

    public void checkCollisions();

    public boolean isGameOver();

    public void loadLevel(LevelData data);

    public void resetLevel();

    public void nextLevel();

    public Snake getSnake();

    public Level getLevel();
}
