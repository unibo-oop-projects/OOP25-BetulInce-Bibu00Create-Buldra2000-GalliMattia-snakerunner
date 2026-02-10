package snakerunner.controller;

import java.awt.event.KeyEvent;

import snakerunner.graphics.hud.BaseHUD;


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

    void setHUD(final BaseHUD timerView, final BaseHUD scoreView, final BaseHUD levelView, final BaseHUD lifeView);

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
