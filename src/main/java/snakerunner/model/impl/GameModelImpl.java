package snakerunner.model.impl;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import snakerunner.commons.Point2D;
import snakerunner.model.Collectible;
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
    private List<Collectible> foods;
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
        System.out.println("Spawn Snake...");
        spawnSnake();
        System.out.println("Spawn Foods...");
        spawnFoods(data.getFoodPositions());

        debugPrintLevel();
    }

    @Override
    public void resetLevel() {
        //this.snake = new SnakeImpl();
        //this.food = new FoodImpl();
    }

    @Override
    public Snake getSnake() {
        return this.snake;
    }

    @Override
    public List<Collectible> getFoods() {
        return Collections.unmodifiableList(foods);    
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
            foods.add((Collectible) new FoodImpl(FoodEffect, p));
        }
    }

    private void debugPrintLevel() {
        System.out.println("=== LEVEL DEBUG ===");

        System.out.println("Walls:");
        for (Point2D<Integer, Integer> p : currentLevel.getObstacles()) {
            System.out.println("  wall at " + p);
        }

        System.out.println("Fruits:");
        for (Collectible f : foods) {
            System.out.println("  fruit at " + f.getPosition());
        }

        System.out.println("===================");
    }
}
