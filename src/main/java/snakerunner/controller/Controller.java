package snakerunner.controller;

import snakerunner.model.GameModel;

//LinkedBlockingQueue -> thread safe
//Il controller non deve vedere Swing

public interface Controller {

    public void init();

    /**
     * Starts the game loop.
     */
    void start();

    void pause();

    GameModel getModel();

    void updateGame();

    void setSoundEnable(boolean isEnable);

    void resume();


    //GamePanel
    void onPause();

    void onResume();

    void onBackToMenu();
}
