package snakerunner.model;

import java.util.List;

public interface GameModel {
    
    public void update();

    public void checkCollisions();

    public boolean isGameOver();

    public void loadLevel(LevelData data);

    public void resetLevel();

    public Snake getSnake();

    //GETTER PER LA VIEW / DEBUG
    public List<Collectible> getCollectibles();

    public Level getLevel();
}
