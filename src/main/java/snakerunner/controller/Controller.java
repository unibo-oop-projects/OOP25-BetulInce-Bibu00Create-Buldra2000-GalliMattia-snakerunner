package snakerunner.controller;

import snakerunner.graphics.MainFrame;
import snakerunner.model.GameModel;
import snakerunner.model.LevelData;

//LinkedBlockingQueue -> thread safe
//controller must not see Swing

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

    public  void loadLevel(LevelData data);

    public void inputKeyPressed(int keyCode);
}
