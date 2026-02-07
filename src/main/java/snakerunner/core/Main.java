package snakerunner.core;


import snakerunner.controller.Controller;
import snakerunner.controller.impl.ControllerImpl;
import snakerunner.graphics.MainFrame;
import snakerunner.graphics.impl.MainFrameImpl;
import snakerunner.model.GameModel;
import snakerunner.model.impl.GameModelImpl;

public final class Main {

    private Main(){}

    public static void main(final String[] args) {

        final MainFrame mainFrame = new MainFrameImpl();
        final GameModel gameModel = new GameModelImpl();
        final Controller controller = new ControllerImpl(mainFrame, gameModel);
        
        controller.init();
        controller.start();
    }
}

