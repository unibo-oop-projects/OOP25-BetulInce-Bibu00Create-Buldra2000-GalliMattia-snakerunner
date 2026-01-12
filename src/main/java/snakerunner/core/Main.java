package snakerunner.core;

import javax.swing.SwingUtilities;

import snakerunner.controller.impl.ControllerImpl;
import snakerunner.graphics.MainFrame;
import snakerunner.graphics.impl.MainFrameImpl;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Snake Runner!");

        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrameImpl();
            ControllerImpl controller = new ControllerImpl(mainFrame);
            controller.init();
        });
    }
}
