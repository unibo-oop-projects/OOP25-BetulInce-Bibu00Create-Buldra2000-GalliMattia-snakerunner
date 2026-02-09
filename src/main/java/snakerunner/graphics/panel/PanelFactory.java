package snakerunner.graphics.panel;

import snakerunner.controller.GameController;
import snakerunner.controller.NavigationController;
import snakerunner.controller.WorldController;

public final class PanelFactory {

    private PanelFactory(){}

    public static BasePanel createGamePanel(final GameController controller) {
        return new GamePanel(controller);
    }

    public static BasePanel createMenuPanel(final NavigationController navigationController) {
        return new MenuPanel(navigationController);
    }

    public static BasePanel createOptionPanel(final NavigationController navigationController) {
        return new OptionPanel(navigationController);
    }

    public static GameBoardPanel createGameBoardPanel(final WorldController worldController) {
        return new GameBoardPanel(worldController);
    }

}
