package snakerunner.controller.impl;

import snakerunner.controller.Controller;
import snakerunner.core.StateGame;
import snakerunner.graphics.MainFrame;
import snakerunner.model.GameModel;

public class ControllerImpl implements Controller {
    private StateGame state;
    private final MainFrame mainFrame;
    private final GameModel gameModel;

    public ControllerImpl(MainFrame mainFrame, GameModel gameModel) {
        this.mainFrame = mainFrame; //view
        this.gameModel = gameModel; //model
        this.state = StateGame.MENU;
    }

    @Override
    public void init() {
        mainFrame.showMenu();
        mainFrame.display();
    }

    @Override
    public void start() {
        // Implementation to start the game loop
        state = StateGame.RUNNING;
        gameModel.startTimer();
        mainFrame.startGameLoop(); //Added
        System.out.println("StateGame.RUNNING , StartTimer");
    }

    @Override
    public void pause(){
        state = StateGame.PAUSED;
        gameModel.stopTimer();
        System.out.println("StateGame.PAUSED , StopTimer");
        mainFrame.startGameLoop();
        //gameModel.loadLevel(level);
    }

    @Override
    public void resume(){
        state = StateGame.RUNNING;
        gameModel.startTimer();
        System.out.println("StateGame.RESUME , StartTimer");
    }

    @Override
    public void updateGame() {
        if (state != StateGame.RUNNING){
            return;
        }

        //un tick di gioco
        gameModel.update();

        if (gameModel.isGameOver()) {
            System.out.println("Controller: Game Over!");
            state = StateGame.GAME_OVER;
            mainFrame.showMenu();
        }
    }

    @Override
    public GameModel getModel(){
        return gameModel;
    }

    @Override
    public void setSoundEnable(boolean isEnable){
        System.out.println("Controller: setSoundEnable()");
    }
}
