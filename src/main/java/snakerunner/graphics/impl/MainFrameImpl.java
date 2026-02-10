package snakerunner.graphics.impl;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import snakerunner.graphics.MainFrame;
import snakerunner.graphics.panel.BasePanel;


public final class MainFrameImpl extends JFrame implements MainFrame {
    
    private static final long serialVersionUID = 1L;
    private static final String TITLE = "Snake Runner";
    private static final String WON_MESSAGE = "You Won!";
    private static final String LOSE_MESSAGE = "You Lose!";
    private static final double PROPORTION = 0.5;
    private BasePanel menuPanel;
    private BasePanel gamePanel;
    private BasePanel optionPanel;


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
        JOptionPane.showMessageDialog(this, WON_MESSAGE, TITLE, JOptionPane.INFORMATION_MESSAGE);
        showMenu();
    }

    @Override
    public void lose() {
        JOptionPane.showMessageDialog(this, LOSE_MESSAGE, TITLE, JOptionPane.INFORMATION_MESSAGE);
        showMenu();
    }

    @Override
    public void refresh() {
        this.repaint();
    }

    @Override
    public void addKeyListener(KeyListener l) {
    super.addKeyListener(l);
    }
 
   
}