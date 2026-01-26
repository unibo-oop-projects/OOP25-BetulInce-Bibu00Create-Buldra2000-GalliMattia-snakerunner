package snakerunner.model.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import snakerunner.commons.Point2D;
import snakerunner.model.Food;
import snakerunner.model.FoodEffect;
import snakerunner.model.GameModel;
import snakerunner.model.Level;
import snakerunner.model.LevelData;
import snakerunner.model.Snake;

public class GameModelImpl implements GameModel {

    //Prova
    private static final FoodEffect FoodEffect = null;

    private Level currentLevel;
    private Snake snake;
    private Queue<Food> foods;
    //private LevelManager levelManager;

    public GameModelImpl() {
    }

    @Override
    public void update() {
        // Every game update logic goes here and updates the game state accordingly.
        
        //snake.move();
        //checkCollisions();
        
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
    public void loadLevel(LevelData data) {
        this.currentLevel = new LevelImpl(data);
        spawnSnake();
        spawnFoods(data.getFoodPositions());

    }

    @Override
    public void resetLevel() {
        //this.snake = new SnakeImpl();
        //this.food = new FoodImpl();
    }

    @Override
    public void nextLevel() {
        //this.currentLevel = levelManager.nextLevel();
        // WIN OR DEATH CONDITION
    }

    @Override
    public Snake getSnake() {
        return this.snake;
    }

    @Override
    public Level getLevel() {
        return this.currentLevel;
    }

    private void spawnSnake() {
        //this.snake = new SnakeImpl();
    }

    private void spawnFoods(List<Point2D<Integer, Integer>> foodPositions) {
        foods = new LinkedList<>();
        
        for (Point2D<Integer, Integer> p : foodPositions) {
            foods.add(new FoodImpl(FoodEffect, p));
        }
    }
}
