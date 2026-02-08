package snakerunner.model.impl;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import snakerunner.commons.Point2D; //This is not used at the moment we could delete it
import snakerunner.model.Collectible;
import snakerunner.model.GameModel;
import snakerunner.model.Level;
import snakerunner.model.LevelData;
import snakerunner.model.Snake;
import snakerunner.model.Door;


public class GameModelImpl implements GameModel {

    private static final int INITIAL_SPEED = 150;
    private static final int SLOW_EFFECT_DURATION = 50;
    private static final int SLOW_EFFECT_SPEED = 300;

    private Level currentLevel;
    private Snake snake;
    private List<Collectible> collectibles;
    private boolean levelCompleted;
    private int score;
    private int speed;
    private int slowEffectDuration;
    private List<Door> doors;

    public GameModelImpl() {
        currentLevel = null;
        snake = new Snake(new Point2D<>(5, 10)); // Starting position of the snake
        collectibles = Collections.emptyList();
        levelCompleted = false;
        score = 0;
        speed = INITIAL_SPEED;
        slowEffectDuration = 0;
    }

    @Override
    public void update() {
        // Every game update logic goes here and updates the game state accordingly.
        snake.move();

        checkCollisions();
        // TODO Auto-generated method stub
        //Should we check for a collision in case the snake hits itself?

        //Collision with walls
        //gameOver= true;
        //Collision with collectibles

        //controllo impatti con ostacoli/porte/corpo del serpente
        //checkCollisions();
        //gestione power-up e cibo
        checkCollectibles();

        if (slowEffectDuration > 0) {
            slowEffectDuration--;
            if (slowEffectDuration == 0) {
                speed = INITIAL_SPEED; // reset speed after slow effect ends
            }
        }

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
        //this.obstacle = data.getObstacles(); //TODO: decide if we want to set the obstacles from the level data or always use the ones defined in the level implementation
        this.collectibles = data.getCollectibles();
        this.doors = data.getDoors();
        //this.snake = data.getSnake(); //TODO: decide if we want to set the snake position from the level data or always start in a fixed position
        this.levelCompleted = false;

        //debugPrintLevel();
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
    public Set<Point2D<Integer, Integer>> getObstacles(){
        //Error control in case the current level is still null
        if (currentLevel != null) {
            //We get the coordinates
            return currentLevel.getObstacles();
        }
        return Collections.emptySet(); //In order to avoid errors we return an empty set of points.
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

    @Override
    public void applySlowEffect() {
        speed = SLOW_EFFECT_SPEED;
        slowEffectDuration = SLOW_EFFECT_DURATION;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void openDoor() {
        for( Door door: doors) { 
            door.setOpen(true);
        }
    }


    /*
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
    */

    private void checkCollisions() {
        // Implement collision detection logic here
        /* 
        if(snake.isCollidingWithItself()){

        }
        */
    }

    
    private void checkCollectibles() {
        Iterator<Collectible> iterator = collectibles.iterator();
        Point2D<Integer, Integer> snakeHead = snake.getHead();

        while (iterator.hasNext()) {
            Collectible c = iterator.next();

            if (c.getPosition().equals(snakeHead)) {
                c.consume(this);
                iterator.remove();
            }
        }
    }

}
