package snakerunner.controller;

import java.awt.Point;
import java.util.List;
import java.util.Set;

import snakerunner.commons.Point2D;
import snakerunner.graphics.MainFrame;
import snakerunner.model.GameModel;

//LinkedBlockingQueue -> thread safe
//Il controller non deve vedere Swing

public interface Controller {

    void init();

    /**
     * Starts the game loop.
     */
    void start();

    void onOption();

    void pause();

    GameModel getModel();

    Set<Point2D<Integer, Integer>> getObstacles();

    List<Point2D<Integer, Integer>> getCollectibles();

    void resume();

    void onPause();

    void onResume();

    MainFrame getView();

    void updateGame();

    void setSoundEnable(boolean isEnable);

    void loadLevelFromFile(String filepath);

    void onBackMenu();

    void exit();
}
