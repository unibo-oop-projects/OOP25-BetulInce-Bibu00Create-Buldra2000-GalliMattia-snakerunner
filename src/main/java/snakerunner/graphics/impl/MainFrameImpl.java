package snakerunner.graphics.impl;

import java.awt.Dimension;
import java.awt.Toolkit;

//import java.net.URL;
//import javax.swing.ImageIcon;
import javax.swing.JFrame;

import snakerunner.graphics.MainFrame;
import snakerunner.graphics.panel.GamePanel;
import snakerunner.graphics.panel.MenuPanel;
import snakerunner.graphics.panel.OptionPanel;

public class MainFrameImpl extends JFrame implements MainFrame {
    
    private static final String TITLE = "Snake Runner";
    private static final double PROPORTION = 0.5;

    private MenuPanel menuPanel;
    private GamePanel gamePanel;
    private OptionPanel optionPanel;

    public MainFrameImpl() {
        super(TITLE);
        //setIcon();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDimensionFrame();
    }

    @Override
    public void display() {
        setVisible(true);
    }
    /*
    private void setIcon(){
        URL iconURL = getClass().getResource("/icon.png");
        System.out.println("Icon URL: " + iconURL);
        ImageIcon icon = new ImageIcon(iconURL);
        setIconImage(icon.getImage());
    }
    */

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
    public void setMenuPanel(MenuPanel menuPanel) {
        this.menuPanel = menuPanel;
    }

    @Override
    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void setOptionPanel(OptionPanel optionPanel) {
        this.optionPanel = optionPanel;
    }

    @Override
    public void won() {
        System.out.println("you won");
    }

    @Override
    public void lose() {
        System.out.println("you lost");
    }
}