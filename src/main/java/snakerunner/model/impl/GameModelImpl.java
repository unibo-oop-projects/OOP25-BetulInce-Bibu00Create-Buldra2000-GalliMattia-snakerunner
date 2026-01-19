package snakerunner.model.impl;

import snakerunner.model.GameModel;

public class GameModelImpl implements GameModel {

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
        // TODO Auto-generated method stub
        return false;
    }
    
}
