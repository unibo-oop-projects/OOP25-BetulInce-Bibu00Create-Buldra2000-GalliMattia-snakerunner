package snakerunner.controller.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
    private MenuPanel menuPanel;
    private OptionPanel optionPanel;
    private GamePanel gamePanel;
    private Timer gameLoopTimer;
    private TimerView timerView;
    private final MainFrame mainFrame;
    private final GameModel gameModel;
    private int currentLevel = 1; //fixare magic number
    private static final int MAX_LEVEL = 4; //fixare magic number

    private int timeLeft;

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
        menuPanel = PanelFactory.createMenuPanel(this);
        optionPanel = PanelFactory.createOptionPanel(this);
        gamePanel = PanelFactory.createGamePanel(this);

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
        timeLeft = 60;
        timerView.setTimeLeft(timeLeft);
        gameLoopTimer.start();
        mainFrame.showGame();
        // Implementation to start the game loop
        loadCurrentLevel();
        mainFrame.startGameLoop(gameModel.getSpeed());
        state = StateGame.RUNNING;
    }

    @Override
    public void pause() {
        if (state == StateGame.RUNNING) {
            state = StateGame.PAUSED;
            gameLoopTimer.stop();
        }
    }


    //tick di gioco 
    @Override
    public void updateGame() {
        if (state != StateGame.RUNNING) {
            return;
        }

        gameModel.update();
        timeLeft--;
        mainFrame.setTimerDelay(gameModel.getSpeed());

        if (gameModel.isGameOver()) {
            state = StateGame.GAME_OVER;
            mainFrame.showMenu();
        } else if (gameModel.isLevelCompleted()) {
            System.out.println("Controller: Level Completed!");
            mainFrame.stopGameLoop();
            nextLevel();
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
    public void loadLevelFromFile(String filePath) {
        
        try (InputStream is = LevelLoader.class
                .getClassLoader()
                .getResourceAsStream(filePath)) {

            if (is == null) {
                throw new IllegalArgumentException("File livello non trovato: " + filePath);
            }

            final List<String> lines = new BufferedReader(new InputStreamReader(is))
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

    @Override
    public void resume() {
        if(state == StateGame.PAUSED) {
            state = StateGame.RUNNING;
        }
        gameLoopTimer.restart();
    }

    private void loadCurrentLevel() {
        String filePath = "levels/level" + currentLevel + ".txt";
        loadLevelFromFile(filePath);
    }

    private void nextLevel() {
        currentLevel++;
        if (currentLevel > MAX_LEVEL) {
            currentLevel = 1; 
        }
        loadCurrentLevel();
        mainFrame.startGameLoop(gameModel.getSpeed());
    }
}
