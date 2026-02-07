package snakerunner.controller;

import java.util.List;
import java.util.Set;

import snakerunner.commons.Point2D;
import snakerunner.graphics.MainFrame;
import snakerunner.model.Collectible;
import snakerunner.model.GameModel;
import snakerunner.model.Snake;

/**
 * The Controller interface defines the methods for controlling the game.
 */
public interface Controller {

    /**
     * Set Panel.
     */
    void init();

    /**
     * Starts the game loop.
     */
    void start();

    /**
     * Show OptionPanel (Controller - View).
     */
    void onOption();

    /**
     * Pause Game (Model - Controller - View).
     */
    void pause();

    /**
     * Get Model.
     * 
     * @return the GameModel instance.
     */
    GameModel getModel();

    /**
     * Get Snake.
     * 
     * @return the Snake instance from the model.
     */
    Snake getSnake();

    /**
     * Get obstacles from Model (Controller - Model).
     * 
     * @return a set of Point2D representing the positions of the obstacles.
     */
    Set<Point2D<Integer, Integer>> getObstacles();

    /** 
     * Get Collectibles from Model (Controller - Model).
     * 
     * @return a list of Collectible objects from the model.
     */
    List<Collectible> getCollectibles();

    /**
     * Get Level from Model (Controller - Model).
     * 
     * @return the current level number.
     */
    int getLevel();

    /**
     * Get Score from Model (Controller - Model).
     * 
     * @return the current score.
     */
    int getScore();

    /**
     * Resume game.
     */
    void resume();

    /**
     * Get View.
     * 
     * @return the MainFrame instance.
     */
    MainFrame getView();

    /**
     * Update gameLoop.
     */
    void updateGame();

    /**
     * Load level from file.
     * 
     * @param filepath path file levels.
     */
    void loadLevelFromFile(String filepath);

    /**
     * Back to menu (Controller - View).
     */
    void onBackMenu();

    /**
     * Exit to the application.
     */
    void exit();
}
