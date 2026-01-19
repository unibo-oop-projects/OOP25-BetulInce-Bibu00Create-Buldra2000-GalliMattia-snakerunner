package snakerunner.controller.impl;

import snakerunner.controller.Controller;
import snakerunner.graphics.MainFrame;

public class ControllerImpl implements Controller {
    private final MainFrame mainFrame;

    public ControllerImpl(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void init() {
        mainFrame.showMenu();
        mainFrame.display();
    }

    @Override
    public void start() {
        // Implementation to start the game loop
    }
}
