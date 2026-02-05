package snakerunner.controller.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import snakerunner.controller.Controller;
import snakerunner.core.StateGame;
import snakerunner.graphics.MainFrame;
import snakerunner.graphics.panel.GamePanel;
import snakerunner.graphics.panel.MenuPanel;
import snakerunner.graphics.panel.OptionPanel;
import snakerunner.graphics.panel.PanelFactory;
import snakerunner.model.GameModel;
import snakerunner.model.LevelData;
import snakerunner.model.impl.LevelLoader;

public class ControllerImpl implements Controller {

    private static final Logger LOGGER = Logger.getLogger(ControllerImpl.class.getName()); 

    private StateGame state;
    private MenuPanel menuPanel;
    private OptionPanel optionPanel;
    private GamePanel gamePanel;
    private final MainFrame mainFrame;
    private final GameModel gameModel;

    public ControllerImpl(final MainFrame mainFrame, final GameModel gameModel) {
        this.mainFrame = mainFrame; //view
        this.gameModel = gameModel; //model
        this.state = StateGame.MENU;
    }

    @Override
    public void init() {
        menuPanel = PanelFactory.createMenuPanel(this);
        optionPanel = PanelFactory.createOptionPanel(this);
        gamePanel = PanelFactory.createGamePanel(this);

        mainFrame.setPanels(menuPanel, gamePanel, optionPanel);

        mainFrame.showMenu();
        mainFrame.display();
    }

    @Override
    public void onStart(){
        mainFrame.showGame();
    }

    @Override
    public void onOption(){
        mainFrame.showOption();
    }

    @Override
    public void start() {
        // Implementation to start the game loop
        state = StateGame.RUNNING;
    }

    @Override
    public void pause(){

        if(state == StateGame.RUNNING){
            state = StateGame.PAUSED;
        }
    }


    //tick di gioco 
    @Override
    public void updateGame() {
        if (state != StateGame.RUNNING){
            return;
        }

        gameModel.update();

        if (gameModel.isGameOver()) {
            state = StateGame.GAME_OVER;
            mainFrame.showMenu();
        }

        //view Render
    }

    @Override
    public void onBackMenu(){
        mainFrame.showMenu();
    }

    @Override
    public GameModel getModel(){
        return gameModel;
    }

    @Override
    public MainFrame getView() {
        return mainFrame;
    }

    @Override
    public void setSoundEnable(boolean isEnable){
        //TODO
    }

    @Override
    public void loadLevelFromFile(final String filePath) {
        // Legge il file dal classpath (resources)
        try (InputStream is = LevelLoader.class
                .getClassLoader()
                .getResourceAsStream(filePath)) {

            if (is == null) {
                final String errorMsg = "File not found: " + filePath;
                LOGGER.log(Level.SEVERE, errorMsg);
                throw new IllegalArgumentException(errorMsg);
            }

            final List<String> lines = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))
                    .lines()
                    .toList();

            final LevelData level = LevelLoader.load(lines);
            gameModel.loadLevel(level);

        } catch (IOException e) {
            final String errorMsg = "Error file load" + filePath;
            LOGGER.log(Level.SEVERE, errorMsg, e);
            throw new IllegalStateException(errorMsg, e);
        }
    }

    @Override
    public void exit(){
        System.exit(0);
    }

}
