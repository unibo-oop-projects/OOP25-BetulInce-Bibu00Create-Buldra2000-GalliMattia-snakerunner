package snakerunner.model;

public interface GameModel {
    
    public void update();

    public void checkCollisions();

    public void startTimer();

     public int getTimeLeft();

    public boolean isGameOver();
}
