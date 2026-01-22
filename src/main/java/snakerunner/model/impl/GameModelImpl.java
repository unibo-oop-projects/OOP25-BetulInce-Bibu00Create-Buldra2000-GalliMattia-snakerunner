package snakerunner.model.impl;

import javax.swing.Timer;
import snakerunner.model.GameModel;

public class GameModelImpl implements GameModel {

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
        // TODO Auto-generated method stub
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

    
    
}
