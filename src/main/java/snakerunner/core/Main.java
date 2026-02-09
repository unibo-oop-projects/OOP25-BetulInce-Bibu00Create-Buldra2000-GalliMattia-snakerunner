package snakerunner.core;

import snakerunner.controller.Controller;
import snakerunner.controller.impl.ControllerImpl;
import snakerunner.graphics.MainFrame;
import snakerunner.graphics.impl.MainFrameImpl;
import snakerunner.model.GameModel;
import snakerunner.model.impl.GameModelImpl;

/**
 * The Main class of the Snake Runner game.
 */
public final class Main {

    private Main() { }

    /**
     * The entry point of the application.
     * 
     * @param args the command line arguments (not used).
     */
    public static void main(final String[] args) {
        final MainFrame mainFrame = new MainFrameImpl();
        final GameModel gameModel = new GameModelImpl();
        final Controller controller = new ControllerImpl(mainFrame, gameModel);

        controller.init();
    }
}

