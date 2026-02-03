package snakerunner.model.impl;

import java.util.Set;

import javax.swing.Timer;

import snakerunner.commons.Point2D;
import snakerunner.model.GameModel;
import snakerunner.model.Level;
import snakerunner.model.LevelManager;
import snakerunner.model.Snake;
import snakerunner.model.Obstacle; //Added obstacles

public class GameModelImpl implements GameModel {

    private static final int START_TIME = 180;
    private static final int DELAY = 1000;
    private int timeLeft;
    private Timer timer;

    private Level currentLevel;
    private Snake snake;
    private LevelManager levelManager;
    private Set<Point2D<Integer, Integer>> obstacles; //Adding obstacles


    public GameModelImpl() {
        timer = new Timer(DELAY, e -> updateTimer());
        timeLeft = START_TIME;
        //Added obstacle generation
        this.obstacles= Obstacle.generatePresetVerticalPipes();
    }
    
@Override
//Adding obstacles in order to allow the view to view them
    public Set<Point2D<Integer, Integer>> getObstacles(){
        return obstacles;
    }


    private void updateTimer(){
        timeLeft--;

        if(timeLeft<=0){
            timer.stop();
        }
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
    public void startTimer(){
        if(timer.isRunning()){
            timer.stop();
        } else {
        timer.start();
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
    public int getTimeLeft() {
        return timeLeft;
    }

    @Override
    public void stopTimer() {
        timer.stop();
    }

    
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
    }
    
}
