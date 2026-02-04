package snakerunner.graphics;

import snakerunner.controller.Controller;

public interface MainFrame {

    public void display();

    public void showMenu();

    public void showGame();

    public void showOption();

    public void pause();

    public void setController(Controller controller);

    public void startGameLoop(Runnable onTick);

    public void stopGameLoop();

    public void setSoundEnabled(boolean isEnable);
}
