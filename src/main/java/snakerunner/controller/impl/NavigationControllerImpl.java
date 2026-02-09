package snakerunner.controller.impl;

import snakerunner.controller.GameController;
import snakerunner.controller.NavigationController;
import snakerunner.controller.WorldController;
import snakerunner.graphics.MainFrame;
import snakerunner.graphics.panel.BasePanel;
import snakerunner.graphics.panel.GamePanel;
import snakerunner.graphics.panel.PanelFactory;
import snakerunner.model.GameModel;

public class NavigationControllerImpl implements NavigationController {
    
    private MainFrame mainFrame;
    private GameModel gameModel;
    private GameController gameController;
    private BasePanel menuPanel;
    private BasePanel optionPanel;

    public NavigationControllerImpl(final MainFrame mainFrame, final GameModel gameModel) {
        this.mainFrame = mainFrame;
        this.gameModel = gameModel;

    }

    @Override
    public void init() {
        menuPanel = PanelFactory.createMenuPanel(this);
        optionPanel = PanelFactory.createOptionPanel(this);

        mainFrame.setPanels(menuPanel, null, optionPanel);
        mainFrame.showMenu();
        mainFrame.display();
    }

    @Override
    public void startGame() {
        if (gameController == null) {
            gameController = new GameControllerImpl(mainFrame, gameModel);
        }

        WorldController wc = new WorldControllerImpl(gameModel);

        final BasePanel gamePanel = PanelFactory.createGamePanel(gameController);
        
        if (gamePanel instanceof GamePanel gp) {
            gp.setWorldController(wc);
            gameController.setHUD(gp.getTimerView(), gp.getScoreView());
        }

        mainFrame.setPanels(menuPanel, gamePanel, optionPanel);
        mainFrame.showGame();
        gameController.start();
        
    }

    @Override
    public void onOption() {
        mainFrame.showOption();
    }

    @Override
    public void onBackMenu() {
        mainFrame.showMenu();
    }

    @Override
    public void exit() {
        System.exit(0);
    }

    @Override
    public MainFrame getView() {
        return mainFrame;
    }

}
