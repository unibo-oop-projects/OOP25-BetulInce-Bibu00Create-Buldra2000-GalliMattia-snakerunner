package snakerunner.controller;

import snakerunner.graphics.MainFrame;
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

    public GameModel getModel();

    public MainFrame getView();

    public void updateGame();

    public void setSoundEnable(boolean isEnable);

    public void loadLevelFromFile(String filepath);
}
