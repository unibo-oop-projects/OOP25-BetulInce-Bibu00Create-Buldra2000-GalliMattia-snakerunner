package snakerunner.graphics.impl;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import snakerunner.graphics.MainFrame;
import snakerunner.graphics.panel.GamePanel;
import snakerunner.graphics.panel.MenuPanel;
import snakerunner.graphics.panel.OptionPanel;

public class MainFrameImpl extends JFrame implements MainFrame {

    private static final long serialVersionUID = 1L;
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

    private void setDimensionFrame(){
        final Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        final int width = (int)(screensize.width * PROPORTION);
        final int height = (int)(screensize.height * PROPORTION);
        setSize(width,height);
    }

    @Override
    public void setPanels(final MenuPanel menuPanel, final GamePanel gamePanel, final OptionPanel optionPanel){
        this.menuPanel = menuPanel;
        this.gamePanel = gamePanel;
        this.optionPanel = optionPanel;
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