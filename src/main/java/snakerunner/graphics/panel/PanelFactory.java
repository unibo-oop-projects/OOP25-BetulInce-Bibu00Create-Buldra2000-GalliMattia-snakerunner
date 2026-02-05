package snakerunner.graphics.panel;

import snakerunner.graphics.MainFrame;

public class PanelFactory {

    public static GamePanel createGamePanel(MainFrame mainFrame) {
        return new GamePanel(mainFrame);
    }

    public static MenuPanel createMenuPanel(MainFrame mainFrame) {
        return new MenuPanel(mainFrame);
    }

    public static OptionPanel createOptionPanel(MainFrame mainFrame) {
        return new OptionPanel(mainFrame);
    }
}
