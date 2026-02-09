package snakerunner.controller;

import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;

import snakerunner.commons.Point2D;
import snakerunner.graphics.hud.BaseHUD;
import snakerunner.model.Collectible;
import snakerunner.model.Direction;
import snakerunner.model.Door;
import snakerunner.model.Snake;


//LinkedBlockingQueue -> thread safe
//controller must not see Swing

public interface GameController {

    /**
     * Starts the game loop.
     */
    void start();

    /**
     * Pause Game (Model - Controller - View)
     */
    void pause();

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
     * Get Doors from Model (Controller - Model)
     * @return
     */
    List<Door> getDoors();

    /**
     * Get Direction from Model (Controller - Model)
     * 
     * @return the current direction of the snake.
     */
    Direction getDirection();

    /**
     * Get Level from Model (Controller - Model)
     * @return
     */
    int getLevel();

    void setHUD(final BaseHUD timerView, final BaseHUD scoreView);

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
     * Update gameLoop
     */
    void updateGame();

    /**
     * Load level from file.
     * 
     * @param filepath path file levels.
     */
    void loadLevelFromFile(String filepath);

    void keyPressed(KeyEvent e);

    void keyTyped(KeyEvent e);

    void keyReleased(KeyEvent e);
}
