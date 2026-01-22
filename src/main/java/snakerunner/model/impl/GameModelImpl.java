package snakerunner.model.impl;

import javax.swing.Timer;
import snakerunner.model.GameModel;
import snakerunner.model.Level;
<<<<<<< HEAD
<<<<<<< HEAD
import snakerunner.model.LevelManager;
=======
>>>>>>> c57c0f0 (added method for load a level and reset a level)
=======
import snakerunner.model.LevelManager;
>>>>>>> 24f76ac (added new method in Game model)
import snakerunner.model.Snake;

public class GameModelImpl implements GameModel {

<<<<<<< HEAD
    private static final int START_TIME = 180;
    private static final int DELAY = 1000;
    private int timeLeft;
    private Timer timer;

    public GameModelImpl() {
        timer = new Timer(DELAY, e -> updateTimer());
        timeLeft = START_TIME;
    }

    private void updateTimer(){
        timeLeft--;

        if(timeLeft<=0){
            timer.stop();
        }
    }
    private Level currentLevel;
    private Snake snake;
    private LevelManager levelManager;
<<<<<<< HEAD
<<<<<<< HEAD
=======
    private Level currentLevel;
    private Snake snake;
>>>>>>> c57c0f0 (added method for load a level and reset a level)
=======
>>>>>>> 24f76ac (added new method in Game model)
=======
    private static final int START_TIME = 180;
    private static final int DELAY = 1000;
    private int timeLeft;
    private Timer timer;

    public GameModelImpl() {
        timer = new Timer(DELAY, e -> updateTimer());
        timeLeft = START_TIME;
    }

    private void updateTimer(){
        timeLeft--;

        if(timeLeft<=0){
            timer.stop();
        }
    }
>>>>>>> 9c0b08f (added package hud, add TimerView, fix ControllerImpl & GameModelImpl)

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
<<<<<<< HEAD
        if(timer.isRunning()){
            timer.stop();
        } else {
        timer.start();
        }
=======
        timer.start();
>>>>>>> 9c0b08f (added package hud, add TimerView, fix ControllerImpl & GameModelImpl)
    }

    @Override
    public boolean isGameOver() {
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 8dc557d (Added new methods for the grid and the obstacles)
        /*
        if (level.IsBlocked(snake.getHead())) {
            return true;
        } else {
            return false;
        }
        */
       return false;
<<<<<<< HEAD
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
=======
        // WIN OR DEATH CONDITION
        return false;
>>>>>>> 24f76ac (added new method in Game model)
=======
>>>>>>> 8dc557d (Added new methods for the grid and the obstacles)
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
    }

    @Override
    public int getTimeLeft() {
        return timeLeft;
    }

    @Override
    public void stopTimer() {
        timer.stop();
    }

    
    
}
