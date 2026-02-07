package snakerunner.graphics.hud;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

/*LifeView is a HUD component and is used to show the remaining life in GamePanel*/
public final class LifeView extends BaseView {

    private static final long serialVersionUID = 1L;
    private static final String LIFE_TEXT = "Life : %1d";
    private static final int X = 5;
    private static final int Y = 15;
    private static final int WIDTH = 60;
    private static final int HEIGHT = 30;

    private int life;

    public LifeView() {
        setOpaque(false);
         setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    @Override
    public void setValue(int value) {
        this.life = value;
        repaint();
    }

    public void setLife(int life) {
        this.life = life;
        repaint();
    }

    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);

        final String lifeText = String.format(LIFE_TEXT, life);

        g.setColor(Color.BLACK);
        g.drawString(lifeText, X, Y);
    }
    
}
