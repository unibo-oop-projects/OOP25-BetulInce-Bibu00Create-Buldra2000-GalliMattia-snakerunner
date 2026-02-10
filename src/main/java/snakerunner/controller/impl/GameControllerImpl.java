package snakerunner.controller.impl;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.swing.Timer;

import snakerunner.controller.GameController;
import snakerunner.core.StateGame;
import snakerunner.graphics.MainFrame;
import snakerunner.graphics.hud.BaseHUD;
import snakerunner.model.Direction;
import snakerunner.model.GameModel;
import snakerunner.model.LevelData;
import snakerunner.model.impl.LevelLoader;

public class GameControllerImpl implements GameController, KeyListener {

    private static final int MAX_LEVEL = 4;
    private static final int INITIAL_LEVEL = 1;
    private StateGame state;
    private Timer gameLoopTimer;
    private BaseHUD timerView;
    private BaseHUD scoreView;
    private BaseHUD levelView;
    private BaseHUD lifeView;
    private final MainFrame mainFrame;
    private final GameModel gameModel;
    private int currentLevel = INITIAL_LEVEL; 
    

    private int timeLeft;

    /**
     * Constructor for GameControllerImpl.
     * 
     * @param mainFrame the main frame of the game.
     * @param gameModel the game model that contains the game state and logic.
     */
    public GameControllerImpl(final MainFrame mainFrame, final GameModel gameModel) {
        this.mainFrame = mainFrame; 
        this.gameModel = gameModel; 
        this.state = StateGame.MENU;
        initGameLoop(gameModel.getSpeed());
    }

    //Creation components
    
    //KeyListener
    @Override
    public void keyPressed(final KeyEvent e) {
        //if the fame is not running we ignore the keys
        if (state != StateGame.RUNNING) {
            return;
        }
        final int key = e.getKeyCode();

        //the keyboard bottoms becomes the snake's direction WASD
        switch (key) {
            case KeyEvent.VK_UP:
                gameModel.getSnake().setDirection(Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
                gameModel.getSnake().setDirection(Direction.DOWN);
                break;
            case KeyEvent.VK_LEFT:
                gameModel.getSnake().setDirection(Direction.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                gameModel.getSnake().setDirection(Direction.RIGHT);
                break;
            case KeyEvent.VK_P:
                pause();
                break;

        }


    }

    @Override 
    public void keyTyped(final KeyEvent e) {

    }

    @Override
    public void keyReleased(final KeyEvent e) {

    }

    /**
     * Starts the game by initializing the timer, loading the current level,
     * and updating the HUD.
     */
    @Override
    public void start() {
        gameModel.resetLives();
        timeLeft = 100;
        loadCurrentLevel();
        if (mainFrame instanceof javax.swing.JFrame) {
        ((javax.swing.JFrame) mainFrame).requestFocusInWindow();
    }
        timerView.setValue(timeLeft);
        scoreView.setValue(gameModel.getScore());
        gameLoopTimer.start();
        state = StateGame.RUNNING;
    }

    /**
     * Pauses the game if it is currently running by stopping the game loop timer
     */
    @Override
    public void pause() {
        if (state == StateGame.RUNNING) {
            state = StateGame.PAUSED;
            gameLoopTimer.stop();
        }
    }

    /**
     * Resumes the game if it is currently paused by restarting
     * the game loop timer and updating the game state to RUNNING.
     */
    @Override
    public void resume() {
        if (state == StateGame.PAUSED) {
            state = StateGame.RUNNING;
            gameLoopTimer.restart();

            if (mainFrame instanceof javax.swing.JFrame) {
            ((javax.swing.JFrame) mainFrame).requestFocusInWindow();
            }  
        }
    }

    /**
     * Updates the game state by calling the update method of the game model,
     * checking for game over and level completion conditions,
     * and updating the HUD and main frame accordingly.
     */
    @Override
    public void updateGame() {
        if (state != StateGame.RUNNING) {
            return;
        }

        gameModel.update();
        timeLeft--;

        setTimerDelay(gameModel.getSpeed());

        if (gameModel.isGameOver() || timeLeft == 0) {
            gameLoopTimer.stop();
            state = StateGame.GAME_OVER;
            mainFrame.lose();
            state = StateGame.MENU;
        } else if (gameModel.isLevelCompleted()) {
            handleLevelCompleted();
            }

        //view Render
        updateHUD();
        mainFrame.refresh();
    }
    
    /**
     * Loads a level from a file and updates the game model with the new level data.
     */
    @Override
    public void loadLevelFromFile(final String filePath) {
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

        } catch (final IOException e) {
            throw new RuntimeException("Errore caricamento livello", e);
        }
    }

    /**
     * Sets the delay of the game loop timer
     * after collecting a power-up.
     * 
     * @param delay the new delay for the game loop timer in milliseconds.
     */
    private void setTimerDelay(final int delay) {
        gameLoopTimer.setDelay(delay);
    }

    private void updateHUD() {
        timerView.setValue(timeLeft);
        scoreView.setValue(gameModel.getScore());
        levelView.setValue(currentLevel);
        lifeView.setValue(gameModel.getLives());
        
    }

    private void loadCurrentLevel() {
        gameModel.resetState();
        final String filePath = "levels/level" + currentLevel + ".txt";
        loadLevelFromFile(filePath);
    }

    private void nextLevel() {
        currentLevel++;
        if (currentLevel > MAX_LEVEL) {
            currentLevel = 1;
            mainFrame.won();
            state = StateGame.MENU;
        }
    }

    private void initGameLoop(final int delay) {
        gameLoopTimer = new Timer(delay, e -> {
            updateGame();
        });
    }

    @Override
    public void setHUD(final BaseHUD timerView, final BaseHUD scoreView, final BaseHUD levelView, final BaseHUD lifeView) {
        this.timerView = timerView;
        this.scoreView = scoreView;
        this.levelView = levelView;
        this.lifeView = lifeView;
    }
    
    private void handleLevelCompleted() {
        gameLoopTimer.stop();
        nextLevel();
        loadCurrentLevel();
        if (mainFrame instanceof javax.swing.JFrame) {
        ((javax.swing.JFrame) mainFrame).requestFocusInWindow();
    }
        gameLoopTimer.start();
    }
}
