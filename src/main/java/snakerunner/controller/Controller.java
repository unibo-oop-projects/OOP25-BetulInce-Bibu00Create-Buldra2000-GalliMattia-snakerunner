package snakerunner.controller;

import snakerunner.model.GameModel;

//LinkedBlockingQueue -> thread safe
//Il controller non deve vedere Swing

public interface Controller {

    public void init();

    /**
     * Starts the game loop.
     */
    public void start();

    public void pause();

    public void resume();

    public GameModel getModel();

    public void updateGame();

    public void setSoundEnable(boolean isEnable);
}
