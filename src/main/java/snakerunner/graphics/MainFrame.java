package snakerunner.graphics;

import snakerunner.graphics.panel.GamePanel;
import snakerunner.graphics.panel.MenuPanel;
import snakerunner.graphics.panel.OptionPanel;

public interface MainFrame {

    /**
     * Show Frame
     */
    void display();

    /**
     * Show MenuPanel
     */
    void showMenu();

    /**
     * Show GamePanel
     */
    void showGame();

    /**
     * Set Panel
     * @param menuPanel Set MenuPanel
     * @param gamePanel Set GamePanel
     * @param optionPanel Set OptionPanel
     */
    void setPanels(final MenuPanel menuPanel, final GamePanel gamePanel, final OptionPanel optionPanel);

    /**
     * Show OptionPanel
     */
    void showOption();

    /**
     * Show JDialog "You won!"
     */
    void won();

    /**
     * Show JDialog "You lose!"
     */
    void lose();
    
    /**
     * Start the game loop with a specified delay.
     * @param delay The delay in milliseconds between each game update.
     */
    public void startGameLoop(int delay);

    /**
     * Stop the game loop.
     */
    public void stopGameLoop();
    
    /**
     * Set the delay for the game loop after the snake consume a clock.
     * @param delay The delay in milliseconds between each game update.
     */
    public void setTimerDelay(int delay);
}
