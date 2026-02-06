package snakerunner.model.impl;

import java.util.Collections;
import java.util.List;

import snakerunner.commons.Point2D;
import snakerunner.model.Collectible;
import snakerunner.model.GameModel;
import snakerunner.model.Level;
import snakerunner.model.LevelData;
import snakerunner.model.Snake;

public class GameModelImpl implements GameModel {

    private Level currentLevel;
    private Snake snake;
    private List<Collectible> collectibles;
    private boolean levelCompleted;
    private int score;

    public GameModelImpl() {
    }

    @Override
    public void update() {
        // Every game update logic goes here and updates the game state accordingly.
        
        //snake.move();

        //controllo impatti con ostacoli/porte/corpo del serpente
        checkCollisions();

        //gestione power-up e cibo
        //checkCollectibles();

        if (collectibles.isEmpty()) {
            levelCompleted = true;
        }
    
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
        this.collectibles = data.getCollectibles();
        //this.snake = new SnakeImpl(new Point2D<>(5,5), 3);
        this.levelCompleted = false;
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
    public List<Collectible> getCollectibles() {
        return Collections.unmodifiableList(collectibles);    
    }

    @Override
    public Level getLevel() {
        return this.currentLevel;
    }

    @Override
    public boolean isLevelCompleted() {
        return this.levelCompleted;
    }

    @Override
    public void addScore(int points) {
        score += points;
    }

    @Override
    public int getScore() {
        return score;
    }

    private void debugPrintLevel() {
        System.out.println("=== LEVEL DEBUG ===");

        System.out.println("Walls:");
        for (Point2D<Integer, Integer> p : currentLevel.getObstacles()) {
            System.out.println("  wall at " + p);
        }

        System.out.println("Collectibles:");
        for (Collectible c : collectibles) {
            System.out.println("  collectible at " + c.getPosition());
        }

        System.out.println("===================");
    }

    private void checkCollisions() {
        // Implement collision detection logic here
    }

    /*
    private void checkCollectibles() {
        Iterator<Collectible> iterator = collectibles.iterator();
        Point2D<Integer, Integer> snakeHead = snake.getHead();

        while (iterator.hasNext()) {
            Collectible c = iterator.next();
            if (c.getPosition().equals(snakeHead)) {
                c.consume(snake);
                iterator.remove();
            }
        }
    }
*/
}
