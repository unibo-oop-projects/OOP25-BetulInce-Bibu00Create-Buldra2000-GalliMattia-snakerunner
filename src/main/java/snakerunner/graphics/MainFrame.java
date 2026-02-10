package snakerunner.graphics;

import snakerunner.graphics.panel.BasePanel;
//for the keys
import java.awt.event.KeyListener;


public interface MainFrame {
    //test
    
    void addKeyListener(KeyListener l);

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
    void setPanels(BasePanel menuPanel, BasePanel gamePanel, BasePanel optionPanel);

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

    void refresh();
}
