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
import snakerunner.graphics.hud.BaseHUD;
import snakerunner.graphics.panel.BasePanel;
import snakerunner.graphics.panel.GamePanel;
import snakerunner.graphics.panel.PanelFactory;
import snakerunner.model.Collectible;
import snakerunner.model.GameModel;
import snakerunner.model.LevelData;
import snakerunner.model.Snake;
import snakerunner.model.impl.LevelLoader;

public class ControllerImpl implements Controller {

    private StateGame state;
    private Timer gameLoopTimer;
    private BaseHUD timerView;
    private BaseHUD scoreView;
    private final MainFrame mainFrame;
    private final GameModel gameModel;
    private int currentLevel = 1; //fixare magic number
    private static final int MAX_LEVEL = 4; //fixare magic number

    private int timeLeft;
    private int score;

    public ControllerImpl(final MainFrame mainFrame, final GameModel gameModel) {
        this.mainFrame = mainFrame; //view
        this.gameModel = gameModel; //model
        this.state = StateGame.MENU;
        initGameLoop(gameModel.getSpeed());
    }

    //Creation components
    @Override
    public void init() {
        final BasePanel menuPanel = PanelFactory.createMenuPanel(this);
        final BasePanel optionPanel = PanelFactory.createOptionPanel(this);
        final BasePanel gamePanel = PanelFactory.createGamePanel(this);

        mainFrame.setPanels(menuPanel, gamePanel, optionPanel);
        mainFrame.showMenu();
        mainFrame.display();

        timerView = ((GamePanel)gamePanel).getTimerView();
        scoreView = ((GamePanel)gamePanel).getScoreView();
        
    }

    @Override
    public void onOption() {
        mainFrame.showOption();
    }

    @Override
    public void start() {
        timeLeft = 5;
        score = 0;
        timerView.setValue(timeLeft);
        scoreView.setValue(score);
        gameLoopTimer.start();
        mainFrame.showGame();
        loadCurrentLevel();
        initGameLoop(gameModel.getSpeed());
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
        timeLeft--;

        // Aggiorna la velocità del timer in base alla velocità attuale del gioco
        setTimerDelay(gameModel.getSpeed());

        if (gameModel.isGameOver()) {
            state = StateGame.GAME_OVER;
            mainFrame.showMenu();
        } else if (gameModel.isLevelCompleted()) {
            System.out.println("Controller: Level Completed!");
            gameLoopTimer.stop();
            nextLevel();
        }

        //view Render
        updateHUD();
    }

    @Override
    public Snake getSnake(){
        return gameModel.getSnake();
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
    public int getScore(){
        return this.score;
    }

    @Override
    public void addScore(final int points) {
        this.score += points;
        gameModel.addScore(points);
        scoreView.setValue(this.score);
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
        timerView.setValue(timeLeft);
        this.score = gameModel.getScore();
        scoreView.setValue(this.score);
    }

    @Override
    public void exit() {
        System.exit(0);
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
        //gameloop??
    }

    private void initGameLoop(int delay) {
        gameLoopTimer = new Timer(delay, e -> {
            updateGame();
        });
    }

    private void setTimerDelay(int delay) {
        gameLoopTimer.setDelay(delay);
    }
}
