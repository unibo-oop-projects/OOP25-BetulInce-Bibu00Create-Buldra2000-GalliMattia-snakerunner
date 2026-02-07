package snakerunner.controller;

import java.util.List;
import java.util.Set;
import snakerunner.commons.Point2D;
import snakerunner.graphics.MainFrame;
import snakerunner.model.Collectible;
import snakerunner.model.GameModel;
import snakerunner.model.LevelData;

//LinkedBlockingQueue -> thread safe
//controller must not see Swing

public interface Controller {

    /**
     * Set Panel
     */
    void init();

    /**
     * Starts the game loop.
     */
    void start();

    /**
     * Show OptionPanel (Controller - View)
     */
    void onOption();

    /**
     * Pause Game (Model - Controller - View)
     */
    void pause();

    GameModel getModel();

    /**
     * Get obstacles from Model (Controller - Model)
     * 
     * @return
     */
    Set<Point2D<Integer, Integer>> getObstacles();

    /** 
     * Get Collectibles from Model (Controller - Model)
    */
    List<Collectible> getCollectibles();

    /**
     * Resume game
     */
    void resume();

    /**
     * Get View
     * 
     * @return
     */
    MainFrame getView();

    /**
     * Update gameLoop
     */
    void updateGame();

    /**
     * Load level from file
     * 
     * @param filepath path file levels
     */
    void loadLevelFromFile(String filepath);

    /**
     * Back to menu (Controller - View)
     */
    void onBackMenu();

    /**
     * Exit to the application
     */
    void exit();
}
