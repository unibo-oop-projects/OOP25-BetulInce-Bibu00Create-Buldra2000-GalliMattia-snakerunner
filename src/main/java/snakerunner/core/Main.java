package snakerunner.core;

import javax.swing.SwingUtilities;
import snakerunner.controller.Controller;
import snakerunner.controller.impl.ControllerImpl;
import snakerunner.graphics.MainFrame;
import snakerunner.graphics.impl.MainFrameImpl;
import snakerunner.model.GameModel;
import snakerunner.model.impl.GameModelImpl;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Snake Runner!");

        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrameImpl();
            GameModel gameModel = new GameModelImpl();
            
            Controller controller = new ControllerImpl(mainFrame, gameModel);
            mainFrame.setController(controller);
            controller.init();
        });
    }
}
