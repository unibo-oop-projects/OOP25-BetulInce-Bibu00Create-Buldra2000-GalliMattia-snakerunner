package snakerunner.controller;

import snakerunner.graphics.MainFrame;

/**
 * Coordinate interaction between views and action.
 */
public interface NavigationController {
    
    /**
     * Initialize the application and set up view state (Controller - View)
     */
    void init();

    /**
     * Transition from current view to OptionPanel (Controller - View)
     */
    void onOption();

    /**
     * Transition from current view to MenuPanel (Controller - View)
     */
    void onBackMenu();

    /**
     * start game
     */
    void startGame();

    /**
     * Terminate the application
     */
    void exit();

    /**
     * 
     * @return
     */
    MainFrame getView();

}
