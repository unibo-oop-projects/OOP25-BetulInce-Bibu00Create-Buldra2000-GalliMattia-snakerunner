package snakerunner.controller.impl;

import snakerunner.controller.Controller;
import snakerunner.graphics.MainFrame;
import snakerunner.model.GameModel;

public class ControllerImpl implements Controller {
    private final MainFrame mainFrame;
    private final GameModel gameModel;

    public ControllerImpl(MainFrame mainFrame, GameModel gameModel) {
        this.mainFrame = mainFrame; //view
        this.gameModel = gameModel; //model
    }

    @Override
    public void init() {
        mainFrame.showMenu();
        mainFrame.display();
        mainFrame.startGameLoop();
    }

    @Override
    public void start() {
        // Implementation to start the game loop
        gameModel.startTimer();
        
        
    }

    @Override
    public void pause(){
        gameModel.stopTimer();
    }

    @Override
    public void updateGame() {
        //un tick di gioco
        gameModel.update();

        if (gameModel.isGameOver()) {
            System.out.println("Controller: Game Over!");
            mainFrame.showMenu();
        }
    }

    @Override
    public GameModel getModel(){
        return gameModel;
    }
}
