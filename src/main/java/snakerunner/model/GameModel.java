package snakerunner.model;

import java.util.List;

public interface GameModel {
    
    public void update();

    public void checkCollisions();

    public boolean isGameOver();

    public void loadLevel(LevelData data);

    public void resetLevel();

    public void nextLevel();

    public Snake getSnake();

    //GETTER for the VIEW / DEBUG
    public List<Food> getFoods();

    public Level getLevel();

    public void moveSnakeUp();

    public void moveSnakeDown();

    public void moveSnakeLeft();

    public void moveSnakeRight();
}
