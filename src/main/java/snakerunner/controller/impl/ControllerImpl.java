package snakerunner.controller.impl;

import javax.swing.Timer;

import snakerunner.audio.AudioPlayer;
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

    private Timer gameLoopTimer;

    private GamePanel gamePanel;
    private MenuPanel menuPanel;
    private OptionPanel optionPanel;

    public ControllerImpl(MainFrame mainFrame, GameModel gameModel) {
        this.mainFrame = mainFrame; //view
        this.gameModel = gameModel; //model
        this.state = StateGame.MENU;
        initGameLoop();
    }

    private void initGameLoop(){
        gameLoopTimer = new Timer(16, e -> updateGame());
    }

    //Creation components
    @Override
    public void init() {
        menuPanel = PanelFactory.createMenuPanel(this);
        gamePanel = PanelFactory.createGamePanel(this);
        optionPanel = PanelFactory.createOptionPanel(this);

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

        updateHUD();

        gameLoopTimer.start();
        gameModel.startTimer();
        System.out.println("StateGame.RUNNING , StartTimer");
    }

    @Override
    public void pause(){
        state = StateGame.PAUSED;
        gameLoopTimer.stop();
        gameModel.stopTimer();
        System.out.println("StateGame.PAUSED , StopTimer");
        //gameModel.loadLevel(level);
    }

    @Override
    public void resume(){
        state = StateGame.RUNNING;
        gameLoopTimer.restart();
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

        updateHUD();

        if (gameModel.isGameOver()) {
            System.out.println("Controller: Game Over!");
            state = StateGame.GAME_OVER;
            mainFrame.showMenu();
        }
    }

    @Override
    public void onOption(){
        mainFrame.showOption();
    }

    @Override
    public GameModel getModel(){
        return gameModel;
    }

    @Override
    public void setSoundEnable(boolean isEnable){
        AudioPlayer.setSoundEnabled(isEnable);
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

    private void updateHUD(){
        gamePanel.updateTimer(gameModel.getTimeLeft());
        gamePanel.updateLevel(gameModel.getLevel());
        //gamePanel.updateLife(gameModel.getLife());
        //gamePanel.updateScore(gameModel.getScore());
    }

}
