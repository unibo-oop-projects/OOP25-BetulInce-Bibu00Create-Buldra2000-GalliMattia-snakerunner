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
    
    // Controller
    private Controller controller;
    private Timer timer;
    private MenuPanel menuPanel;
    private GamePanel gamePanel;
    private OptionPanel optionPanel;

    public MainFrameImpl() {
        super(TITLE);
        menuPanel = PanelFactory.createMenuPanel(this);
        gamePanel = PanelFactory.createGamePanel(this);
        optionPanel = PanelFactory.createOptionPanel(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDimensionFrame();
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
        System.out.println("MainFrame : showMenu()");
        setContentPane(menuPanel);
        revalidate();
        repaint();
    }

    @Override
    public void showGame() {
        System.out.println("MainFrame : showGame()");
        setContentPane(gamePanel);
        revalidate();
        repaint();

        controller.start();
        System.out.println("Controller.start()");
    }

    @Override
    public void showOption() {
        System.out.println("MainFrame : showOption()");
        setContentPane(optionPanel);
        revalidate();
        repaint();
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void startGameLoop() {
        //Game Loop 
        timer = new Timer(200, e -> {
            controller.updateGame(); 
            //repaint();
            gamePanel.updateTimer(controller.getModel().getTimeLeft());
        });
        timer.start();
    }

    @Override
    public void stopGameLoop() {
    if (timer != null) {
            timer.stop();
        }
    }
}