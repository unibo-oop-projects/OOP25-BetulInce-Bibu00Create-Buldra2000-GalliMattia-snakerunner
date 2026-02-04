package snakerunner.controller.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import snakerunner.controller.Controller;
import snakerunner.core.StateGame;
import snakerunner.graphics.MainFrame;
import snakerunner.model.GameModel;
import snakerunner.model.LevelData;
import snakerunner.model.impl.LevelLoader;

public class ControllerImpl implements Controller {
    private StateGame state;
    private final MainFrame mainFrame;
    private final GameModel gameModel;

    public ControllerImpl(MainFrame mainFrame, GameModel gameModel) {
        this.mainFrame = mainFrame; //view
        this.gameModel = gameModel; //model
        this.state = StateGame.MENU;
    }

    @Override
    public void init() {
        mainFrame.showMenu();
        mainFrame.display();
    }

    @Override
    public void start() {
        // Implementation to start the game loop
        state = StateGame.RUNNING;
        mainFrame.startGameLoop(this::updateGame);
        System.out.println("StateGame.RUNNING , StartTimer");
    }

    @Override
    public void pause(){

        if(state == StateGame.RUNNING){
            state = StateGame.PAUSED;
        }

        System.out.println("StateGame.PAUSED , StopTimer");
    }


    //tick di gioco 
    @Override
    public void updateGame() {
        if (state != StateGame.RUNNING){
            return;
        }

        gameModel.update();

        if (gameModel.isGameOver()) {
            System.out.println("Controller: Game Over!");
            mainFrame.stopGameLoop();
            state = StateGame.GAME_OVER;
            mainFrame.showMenu();
        }

        //view Render
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
    public void loadLevelFromFile(String filePath) {
        // Legge il file dal classpath (resources)
        try (InputStream is = LevelLoader.class
                .getClassLoader()
                .getResourceAsStream(filePath)) {

            if (is == null) {
                throw new IllegalArgumentException("File livello non trovato: " + filePath);
            }

            List<String> lines = new BufferedReader(new InputStreamReader(is))
                    .lines()
                    .toList();

            LevelData level = LevelLoader.load(lines);
            gameModel.loadLevel(level);

        } catch (IOException e) {
            throw new RuntimeException("Errore caricamento livello", e);
        }
    }
}
