package snakerunner.controller.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import snakerunner.commons.Point2D;
import snakerunner.controller.Controller;
import snakerunner.core.StateGame;
import snakerunner.graphics.MainFrame;
import snakerunner.graphics.panel.GameBoardPanel;
import snakerunner.graphics.panel.GamePanel;
import snakerunner.graphics.panel.MenuPanel;
import snakerunner.graphics.panel.OptionPanel;
import snakerunner.graphics.panel.PanelFactory;
import snakerunner.model.Collectible;
import snakerunner.model.GameModel;
import snakerunner.model.LevelData;
import snakerunner.model.impl.LevelLoader;

public class ControllerImpl implements Controller {

    private static final Logger LOGGER = Logger.getLogger(ControllerImpl.class.getName()); 

    private StateGame state;
    private MenuPanel menuPanel;
    private OptionPanel optionPanel;
    private GamePanel gamePanel;
    private GameBoardPanel gameBoardPanel;
    private Timer gameLoopTimer;
    private final MainFrame mainFrame;
    private final GameModel gameModel;

    public ControllerImpl(final MainFrame mainFrame, final GameModel gameModel) {
        this.mainFrame = mainFrame; //view
        this.gameModel = gameModel; //model
        this.state = StateGame.MENU;
        initGameLoop();
    }

    private void initGameLoop(){
        gameLoopTimer = new Timer(16, e -> {
            updateGame();
            gameBoardPanel.repaint();
        });
    }

    //Creation components
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
    public void onOption(){
        mainFrame.showOption();
    }

    @Override
    public void start() {
        mainFrame.showGame();
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
        gameModel.checkCollisions();

        if (gameModel.isGameOver()) {
            state = StateGame.GAME_OVER;
            mainFrame.showMenu();
        }

        //view Render
        updateHUD();
        
    }

    @Override
    public Set<Point2D<Integer, Integer>> getObstacles(){
        return gameModel.getLevel().getObstacles();
    }

    @Override
    public List<Point2D<Integer, Integer>> getCollectibles(){
        return gameModel.getCollectibles()
            .stream()
            .map(Collectible::getPosition)
            .toList();
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
    

    private void updateHUD(){
        //TODO
    }

    @Override
    public void exit(){
        System.exit(0);
    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resume'");
    }

    @Override
    public void onPause() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onPause'");
    }

    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onResume'");
    }
}
