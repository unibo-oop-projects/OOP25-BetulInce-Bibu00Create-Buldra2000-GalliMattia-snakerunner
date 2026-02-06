package snakerunner.controller.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;
import javax.swing.Timer;
import snakerunner.commons.Point2D;
import snakerunner.controller.Controller;
import snakerunner.core.StateGame;
import snakerunner.graphics.MainFrame;
import snakerunner.graphics.hud.TimerView;
import snakerunner.graphics.panel.GamePanel;
import snakerunner.graphics.panel.MenuPanel;
import snakerunner.graphics.panel.OptionPanel;
import snakerunner.graphics.panel.PanelFactory;
import snakerunner.model.Collectible;
import snakerunner.model.GameModel;
import snakerunner.model.LevelData;
import snakerunner.model.impl.LevelLoader;

public class ControllerImpl implements Controller {

    private StateGame state;
    private Timer gameLoopTimer;
    private TimerView timerView;
    private final MainFrame mainFrame;
    private final GameModel gameModel;

    private int timeLeft;
    private final int currentLevel = 1;

    public ControllerImpl(final MainFrame mainFrame, final GameModel gameModel) {
        this.mainFrame = mainFrame; //view
        this.gameModel = gameModel; //model
        this.state = StateGame.MENU;
        initGameLoop();
    }

    private void initGameLoop() {
        gameLoopTimer = new Timer(1000, e -> {
            updateGame();
        });
    }

    //Creation components
    @Override
    public void init() {
        final MenuPanel menuPanel = PanelFactory.createMenuPanel(this);
        final OptionPanel optionPanel = PanelFactory.createOptionPanel(this);
        final GamePanel gamePanel = PanelFactory.createGamePanel(this);

        mainFrame.setPanels(menuPanel, gamePanel, optionPanel);
        mainFrame.showMenu();
        mainFrame.display();

        timerView = gamePanel.getTimerView();
        
    }

    @Override
    public void onOption() {
        mainFrame.showOption();
    }

    @Override
    public void start() {
        timeLeft = 5;
        timerView.setTimeLeft(timeLeft);
        gameLoopTimer.start();
        mainFrame.showGame();
        // Implementation to start the game loop
        state = StateGame.RUNNING;
    }

    @Override
    public void pause() {
        if (state == StateGame.RUNNING) {
            state = StateGame.PAUSED;
            gameLoopTimer.stop();
        }
    }

    @Override
    public void resume() {
        if (state == StateGame.PAUSED) {
            state = StateGame.RUNNING;
            gameLoopTimer.restart();
        }
    }

    //tick di gioco 
    @Override
    public void updateGame() {
        if (state != StateGame.RUNNING) {
            return;
        }

        gameModel.update();
        gameModel.checkCollisions();
        timeLeft--;

        if(timeLeft == 0) {
            state = StateGame.GAME_OVER;
            gameLoopTimer.stop();
            mainFrame.lose();
            mainFrame.showMenu();
        }

        if (gameModel.isGameOver()) {
            state = StateGame.GAME_OVER;
            mainFrame.showMenu();
        }

        //view Render
        updateHUD();
    }

    @Override
    public Set<Point2D<Integer, Integer>> getObstacles() {
        return gameModel.getLevel().getObstacles();
    }

    @Override
    public List<Collectible> getCollectibles() {
        return gameModel.getCollectibles();
    }

    @Override
    public int getLevel() {
        return this.currentLevel;
    }

    @Override
    public void onBackMenu() {
        mainFrame.showMenu();
    }

    @Override
    public GameModel getModel() {
        return gameModel;
    }

    @Override
    public MainFrame getView() {
        return mainFrame;
    }

    @Override
    public void loadLevelFromFile(final String filePath) {
        // Legge il file dal classpath (resources)
        try (InputStream is = LevelLoader.class
                .getClassLoader()
                .getResourceAsStream(filePath)) {

            if (is == null) {
                throw new IllegalArgumentException("File livello non trovato: " + filePath);
            }

            final List<String> lines = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))
                    .lines()
                    .toList();

            final LevelData level = LevelLoader.load(lines);
            gameModel.loadLevel(level);

        } catch (IOException e) {
            throw new RuntimeException("Errore caricamento livello", e);
        }
    }
    

    private void updateHUD() {
        timerView.setTimeLeft(timeLeft);
    }

    @Override
    public void exit() {
        System.exit(0);
    }
}
