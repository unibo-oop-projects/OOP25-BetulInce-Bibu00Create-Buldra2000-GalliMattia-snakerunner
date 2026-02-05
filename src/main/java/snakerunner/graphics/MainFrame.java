package snakerunner.graphics;

import snakerunner.controller.Controller;
import snakerunner.graphics.panel.GamePanel;
import snakerunner.graphics.panel.MenuPanel;
import snakerunner.graphics.panel.OptionPanel;

public interface MainFrame {

    void display();

    void showMenu();

    void showGame();

    void setPanels(final MenuPanel menuPanel, final GamePanel gamePanel, final OptionPanel optionPanel);

    void showOption();

    void pause();

    void setController(Controller controller);

    void setSoundEnabled(boolean isEnable);
}
