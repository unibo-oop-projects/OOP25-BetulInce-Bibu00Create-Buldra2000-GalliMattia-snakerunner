package snakerunner.graphics.impl;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import snakerunner.controller.Controller;
import snakerunner.graphics.MainFrame;
import snakerunner.graphics.panel.BasePanel;

public final class MainFrameImpl extends JFrame implements MainFrame {
    
    private static final long serialVersionUID = 1L;
    private static final String TITLE = "Snake Runner";
    private static final double PROPORTION = 0.5;
    private Controller controller;
    private BasePanel menuPanel;
    private BasePanel gamePanel;
    private BasePanel optionPanel;
    private Timer timer;


    public MainFrameImpl() {
        super(TITLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDimensionFrame();
        setResizable(false);
    }

    @Override
    public void display() {
        setVisible(true);
    }

    @Override
    public void setPanels(final BasePanel menuPanel, final BasePanel gamePanel, final BasePanel optionPanel) {
       this.menuPanel = menuPanel;
       this.gamePanel = gamePanel;
       this.optionPanel = optionPanel;
    }

    private void setDimensionFrame() {
        final Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        final int width = (int)(screensize.width * PROPORTION);
        final int height = (int)(screensize.height * PROPORTION);
        setSize(width,height);
    }

    @Override
    public void showMenu() {
        setContentPane((JPanel)menuPanel);
        revalidate();
        repaint();
    }

    @Override
    public void showGame() {
        setContentPane((JPanel)gamePanel);
        revalidate();
        repaint();
    }

    @Override
    public void showOption() {
        setContentPane((JPanel)optionPanel);
        revalidate();
        repaint();
    }

    @Override
    public void won(){
        JOptionPane.showMessageDialog(
        this,
        "You Won!",
        "Snake Runner",
        JOptionPane.INFORMATION_MESSAGE
    );
    }

    @Override
    public void lose() {
        JOptionPane.showMessageDialog(
            this, 
            "You Lose!",
            "Snake Runner",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    @Override
    public void startGameLoop(int delay) {
        timer = new Timer(delay, e -> controller.updateGame()); 
        timer.start();
    }

    @Override
    public void stopGameLoop() {
    if (timer != null) {
            timer.stop();
        }
    }

    @Override
    public void setTimerDelay(int delay) {
        timer.setDelay(delay);
    }
}