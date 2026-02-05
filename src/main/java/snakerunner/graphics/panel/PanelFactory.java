package snakerunner.graphics.panel;

import snakerunner.controller.Controller;

public class PanelFactory {

    public static GamePanel createGamePanel(final Controller controller) {
        return new GamePanel(controller);
    }

    public static MenuPanel createMenuPanel(final Controller controller) {
        return new MenuPanel(controller);
    }

    public static OptionPanel createOptionPanel(final Controller controller) {
        return new OptionPanel(controller);
    }
}
