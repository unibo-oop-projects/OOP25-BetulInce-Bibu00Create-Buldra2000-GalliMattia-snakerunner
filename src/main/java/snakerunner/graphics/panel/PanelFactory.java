package snakerunner.graphics.panel;

import snakerunner.controller.Controller;
import snakerunner.graphics.MainFrame;

public class PanelFactory {

    public static GamePanel createGamePanel(Controller controller) {
        return new GamePanel(controller);
    }

    public static MenuPanel createMenuPanel(MainFrame mainFrame, Controller controller) {
        return new MenuPanel(mainFrame, controller);
    }

    public static OptionPanel createOptionPanel(MainFrame mainFrame) {
        return new OptionPanel(mainFrame);
    }
}
