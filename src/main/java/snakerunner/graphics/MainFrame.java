package snakerunner.graphics;

import snakerunner.graphics.panel.GamePanel;
import snakerunner.graphics.panel.MenuPanel;
import snakerunner.graphics.panel.OptionPanel;

public interface MainFrame {

    void display();

    void showMenu();

    void showGame();

    void setPanels(final MenuPanel menuPanel, final GamePanel gamePanel, final OptionPanel optionPanel);

    void showOption();

    void setSoundEnabled(boolean isEnable);

    void won();

    void lose();
}
