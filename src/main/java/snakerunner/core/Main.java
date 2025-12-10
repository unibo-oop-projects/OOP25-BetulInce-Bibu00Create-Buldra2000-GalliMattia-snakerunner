package snakerunner.core;

import snakerunner.graphics.MainFrame;
import snakerunner.graphics.MainFrameImpl;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Snake Runner!");
        
        final MainFrame mainFrame = new MainFrameImpl();
        mainFrame.display();
        };
}
