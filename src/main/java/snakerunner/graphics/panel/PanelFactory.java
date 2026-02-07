package snakerunner.graphics.panel;

import snakerunner.controller.Controller;

public final class PanelFactory {

    private PanelFactory(){}

    public static BasePanel createGamePanel(final Controller controller) {
        return new GamePanel(controller);
    }

    public static BasePanel createMenuPanel(final Controller controller) {
        return new MenuPanel(controller);
    }

    public static BasePanel createOptionPanel(final Controller controller) {
        return new OptionPanel(controller);
    }
}
