package snakerunner.controller.impl;

import java.util.Timer;
import snakerunner.controller.GameController;

public class GameControllerImpl implements GameController {

    private final Timer timer;

    public GameControllerImpl() {
        this.timer = new Timer();
    }


    @Override
    public void startWindow() {
        // Implementation to start the game window
    }

    @Override
    public void start() {
        // Implementation to start the game loop
    }
    
}
