package snakerunner.graphics.impl;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import snakerunner.graphics.MainFrame;
import snakerunner.graphics.panel.GamePanel;
import snakerunner.graphics.panel.MenuPanel;
import snakerunner.graphics.panel.OptionPanel;
import snakerunner.graphics.panel.PanelFactory;

public class MainFrameImpl extends JFrame implements MainFrame {
    
    private static final String TITLE = "Snake Runner";
    private static final double PROPORTION = 0.5;
    private MenuPanel menuPanel;
    private GamePanel gamePanel;
    private OptionPanel optionPanel;

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
    public void setPanels(MenuPanel menuPanel, GamePanel gamePanel, OptionPanel optionPanel) {
       this.menuPanel = menuPanel;
       this.gamePanel = gamePanel;
       this.optionPanel = optionPanel;
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
    }

    @Override
    public void showOption() {
        setContentPane(optionPanel);
        revalidate();
        repaint();
    }

    @Override
    public void won(){
        JOptionPane.showMessageDialog(
        this,
        "You Won!",
        "Victory",
        JOptionPane.INFORMATION_MESSAGE
    );
    }

    @Override
    public void lose() {
        JOptionPane.showMessageDialog(
            this, 
            "You Lose!",
            "Lose",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}