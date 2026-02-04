package snakerunner.graphics;

import snakerunner.graphics.panel.GamePanel;
import snakerunner.graphics.panel.MenuPanel;
import snakerunner.graphics.panel.OptionPanel;

public interface MainFrame {

    void display();

    void showMenu();

    void showGame();

    void showOption();

    void setMenuPanel(MenuPanel menuPanel);

    void setGamePanel(GamePanel gamePanel);

    void setOptionPanel(OptionPanel optionPanel);

    void won();

    void lose();
}
