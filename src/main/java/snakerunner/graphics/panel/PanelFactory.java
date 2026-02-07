package snakerunner.graphics.panel;

import snakerunner.controller.Controller;

public class PanelFactory {

    public static GamePanel createGamePanel(Controller controller) {
        return new GamePanel(controller);
    }

    public static MenuPanel createMenuPanel(Controller controller) {
        return new MenuPanel(controller);
    }

    public static OptionPanel createOptionPanel(Controller controller) {
        return new OptionPanel(controller);
    }
}
