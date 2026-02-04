package snakerunner.model.impl;

import javax.swing.Timer;
import snakerunner.model.GameModel;
import snakerunner.model.Level;
import snakerunner.model.LevelManager;
import snakerunner.model.LevelManager;
import snakerunner.model.Snake;

public class GameModelImpl implements GameModel {

    private static final int START_TIME = 180;
    private static final int DELAY = 1000;
    private int timeLeft;
    private Timer timer;
    private Level currentLevel;
    private Snake snake;
    private LevelManager levelManager;

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
        timer.start();
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
        // WIN OR DEATH CONDITION
    }

    @Override
    public boolean hasWon(){
        return false; //TODO
    }

    @Override
    public boolean hasLost(){
        return false; //TODO
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

    @Override
    public int getTimeLeft() {
        return timeLeft;
    }

    @Override
    public void stopTimer() {
        timer.stop();
    }

    @Override
    public Level getLevel() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLevel'");
    }
    
}
