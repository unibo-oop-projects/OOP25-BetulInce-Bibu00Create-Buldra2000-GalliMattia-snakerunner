package snakerunner.controller.impl;

import snakerunner.controller.Controller;
import snakerunner.core.StateGame;
import snakerunner.graphics.MainFrame;
import snakerunner.graphics.panel.GamePanel;
import snakerunner.graphics.panel.MenuPanel;
import snakerunner.graphics.panel.OptionPanel;
import snakerunner.graphics.panel.PanelFactory;
import snakerunner.model.GameModel;

public class ControllerImpl implements Controller {
    private StateGame state;

    private final MainFrame mainFrame;
    private final GameModel gameModel;

    private GamePanel gamePanel;
    private MenuPanel menuPanel;
    private OptionPanel optionPanel;

    public ControllerImpl(MainFrame mainFrame, GameModel gameModel) {
        this.mainFrame = mainFrame; //view
        this.gameModel = gameModel; //model
        this.state = StateGame.MENU;
    }

    //Creation components
    @Override
    public void init() {
        menuPanel = PanelFactory.createMenuPanel(mainFrame, this);
        gamePanel = PanelFactory.createGamePanel(this);
        optionPanel = PanelFactory.createOptionPanel(mainFrame);

        mainFrame.setMenuPanel(menuPanel);
        mainFrame.setGamePanel(gamePanel);
        mainFrame.setOptionPanel(optionPanel);

        mainFrame.showMenu();
        mainFrame.display();
    }

    @Override
    public void start() {
        mainFrame.showGame();
        // Implementation to start the game loop
        state = StateGame.RUNNING;
        gameModel.startTimer();
        System.out.println("StateGame.RUNNING , StartTimer");
    }

    @Override
    public void pause(){
        state = StateGame.PAUSED;
        gameModel.stopTimer();
        System.out.println("StateGame.PAUSED , StopTimer");
        //gameModel.loadLevel(level);
    }

    @Override
    public void resume(){
        state = StateGame.RUNNING;
        gameModel.startTimer();
        System.out.println("StateGame.RESUME , StartTimer");
        //gameModel.loadLevel(level);
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
        //TODO
    }

    @Override
    public void onPause() {
        pause();
    }

    @Override
    public void onResume() {
        resume();
    }

    @Override
    public void onBackToMenu() {
        state = StateGame.MENU;
        mainFrame.showMenu();
    }
}
