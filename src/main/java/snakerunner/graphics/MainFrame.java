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
}
