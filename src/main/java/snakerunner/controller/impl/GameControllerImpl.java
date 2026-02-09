package snakerunner.controller.impl;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.swing.Timer;

import snakerunner.commons.Point2D;
import snakerunner.controller.GameController;
import snakerunner.core.StateGame;
import snakerunner.graphics.MainFrame;
import snakerunner.graphics.hud.BaseHUD;
import snakerunner.model.Collectible;
import snakerunner.model.Direction;
import snakerunner.model.Door;
import snakerunner.model.GameModel;
import snakerunner.model.LevelData;
import snakerunner.model.Snake;
import snakerunner.model.impl.LevelLoader;

public class GameControllerImpl implements GameController {

    private StateGame state;
    private Timer gameLoopTimer;
    private BaseHUD timerView;
    private BaseHUD scoreView;
    private final MainFrame mainFrame;
    private final GameModel gameModel;
    private int currentLevel = 1; //fixare magic number
    private static final int MAX_LEVEL = 4; //fixare magic number

    private int timeLeft;

    public GameControllerImpl(final MainFrame mainFrame, final GameModel gameModel) {
        this.mainFrame = mainFrame; //view
        this.gameModel = gameModel; //model
        this.state = StateGame.MENU;
        initGameLoop(gameModel.getSpeed());
    }

    //KeyListener
    @Override
    public void keyPressed(KeyEvent e){
        //if the fame is not running we ignore the keys
        if (state !=StateGame.RUNNING){
            return;
        }
        int key = e.getKeyCode();

        //the keyboard bottoms becomes the snake's direction WASD
        switch (key){
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
    public void keyTyped(KeyEvent e){

    }

    @Override
    public void keyReleased(KeyEvent e){

    }

    @Override
    public void start() {
        timeLeft = 5;
        loadCurrentLevel();
        timerView.setValue(timeLeft);
        scoreView.setValue(gameModel.getScore());
        gameLoopTimer.start();
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
            gameLoopTimer.stop();
            state = StateGame.GAME_OVER;
            mainFrame.showMenu();
        } else if (gameModel.isLevelCompleted()) {
            handleLevelCompleted();
        }

        //view Render
        updateHUD();
        mainFrame.refresh();
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
    public List<Door> getDoors() {
        if (gameModel.getLevel() != null) {
            return gameModel.getLevel().getDoors();
        }
            return Collections.emptyList();
    }

    @Override
    public int getLevel() {
        return this.currentLevel;
    }

    @Override
    public int getScore(){
        return gameModel.getScore();
    }
    @Override
    public Direction getDirection() {
        return gameModel.getSnake().getCurrentDirection();
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
    
    @Override
    public void setHUD(BaseHUD timerView, BaseHUD scoreView) {
        this.timerView = timerView;
        this.scoreView = scoreView;
    }

    private void updateHUD() {
        timerView.setValue(timeLeft);
        scoreView.setValue(gameModel.getScore());
    }

    private void loadCurrentLevel() {
        gameModel.resetState();
        String filePath = "levels/level" + currentLevel + ".txt";
        loadLevelFromFile(filePath);
    }

    private void nextLevel() {
        currentLevel++;
        if (currentLevel > MAX_LEVEL) {
            currentLevel = 1; 
        }
    }

    private void initGameLoop(int delay) {
        gameLoopTimer = new Timer(delay, e -> {
            updateGame();
        });
    }

    // Metodo per aggiornare il delay del timer dopo aver raccolto un orologio
    private void setTimerDelay(int delay) {
        gameLoopTimer.setDelay(delay);
    }
    
    private void handleLevelCompleted() {
        gameLoopTimer.stop();
        nextLevel();
        loadCurrentLevel();
        gameLoopTimer.start();
    }
}
