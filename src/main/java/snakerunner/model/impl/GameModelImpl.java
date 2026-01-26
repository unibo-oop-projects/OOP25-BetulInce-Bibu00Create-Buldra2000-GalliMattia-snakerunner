package snakerunner.model.impl;

import snakerunner.model.GameModel;
import snakerunner.model.Level;
import snakerunner.model.LevelManager;
import snakerunner.model.Snake;

public class GameModelImpl implements GameModel {

    private Level currentLevel;
    private Snake snake;
    private LevelManager levelManager;

    public GameModelImpl() {
    }

    @Override
    public void update() {
        // Every game update logic goes here and updates the game state accordingly.
        
        //snake.move();
        checkCollisions();
        
    }

    @Override
    public void checkCollisions() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isGameOver() {
        /*
        if (level.IsBlocked(snake.getHead())) {
            return true;
        } else {
            return false;
        }
        */
       return false;
    }

    @Override
    public void loadLevel(Level level) {
        this.currentLevel = level;
        resetLevel();
    }

    @Override
    public void resetLevel() {
        //snake = new Snake()
    }

    @Override
    public void nextLevel() {
        this.currentLevel = levelManager.nextLevel();
        // WIN OR DEATH CONDITION
    }
}
