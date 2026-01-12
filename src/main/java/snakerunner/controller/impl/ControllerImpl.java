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
    public void show() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'show'");
    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hide'");
    }

}
