package snakerunner.graphics;

import snakerunner.controller.Controller;

public interface MainFrame {

    public void display();
    
    //Set automatically the dimension of the MainFrame
    public void setDimensionFrame();

    public void showMenu();

    public void showGame();

    public void showOption();

    public void setController(Controller controller);

    public void startGameLoop();

    public void stopGameLoop();
}
