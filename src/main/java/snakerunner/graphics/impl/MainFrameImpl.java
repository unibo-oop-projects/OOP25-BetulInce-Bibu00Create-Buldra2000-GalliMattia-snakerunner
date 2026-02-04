package snakerunner.graphics.impl;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.Timer;

import snakerunner.controller.Controller;
import snakerunner.graphics.MainFrame;
import snakerunner.graphics.panel.GamePanel;
import snakerunner.graphics.panel.MenuPanel;
import snakerunner.graphics.panel.OptionPanel;
import snakerunner.graphics.panel.PanelFactory;

public class MainFrameImpl extends JFrame implements MainFrame {
    
    private static final String TITLE = "Snake Runner";
    private static final double PROPORTION = 0.5;
    private Controller controller;
    private Timer timer;
    private int timeLeft;
    private MenuPanel menuPanel;
    private GamePanel gamePanel;
    private OptionPanel optionPanel;

    public MainFrameImpl() {
        super(TITLE);
        //setIcon();
        menuPanel = PanelFactory.createMenuPanel(this);
        gamePanel = PanelFactory.createGamePanel(this);
        optionPanel = PanelFactory.createOptionPanel(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDimensionFrame();
        //timer = new Timer(DELAY, e -> updateTimer());
        //timeLeft = START_TIME;
    }

     private void updateTimer(){
        timeLeft--;

        if(timeLeft<=0){
            timer.stop();
        }
    }

    @Override
    public void display() {
        setVisible(true);
    }

    private void setDimensionFrame(){
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)(screensize.width * PROPORTION);
        int height = (int)(screensize.height * PROPORTION);
        setSize(width,height);
    }

    @Override
    public void showMenu() {
        setContentPane(menuPanel);
        revalidate();
        repaint();
    }

    @Override
    public void showGame() {
        setContentPane(gamePanel);
        revalidate();
        repaint();

        controller.start();
        System.out.println("Controller.start()");
    }

    @Override
    public void pause(){
        controller.pause();
    }

    @Override
    public void showOption() {
        setContentPane(optionPanel);
        revalidate();
        repaint();
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void startGameLoop(Runnable onTick) {
        timer = new Timer(200, e -> onTick.run()); 
        //gamePanel.updateTimer(getTimeLeft());
        timer.start();
    }

    @Override
    public void stopGameLoop() {
    if (timer != null) {
            timer.stop();
        }
    }

    @Override
    public void setSoundEnabled(boolean isEnable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setSoundEnabled'");
    }
}