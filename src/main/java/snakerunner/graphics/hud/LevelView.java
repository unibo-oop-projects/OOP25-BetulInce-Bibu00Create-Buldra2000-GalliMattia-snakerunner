package snakerunner.graphics.hud;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/*TimerView is a HUD component and is used to show level in GamePanel*/
public class LevelView extends JPanel {

    private static final String LEVEL_TEXT = "Level : %1d";
    private static final int WIDTH = 60;
    private static final int HEIGHT = 30;
    private static final int X = 5;
    private static final int Y = 15;

    private int level;

    public LevelView() {
        setOpaque(false);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    public void setLevel(final int level) {
        this.level = level;
        repaint();
    }

    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);

        final String levelText = String.format(LEVEL_TEXT, level);

        g.setColor(Color.BLACK);
        g.drawString(levelText, X, Y);
    }
    
}
