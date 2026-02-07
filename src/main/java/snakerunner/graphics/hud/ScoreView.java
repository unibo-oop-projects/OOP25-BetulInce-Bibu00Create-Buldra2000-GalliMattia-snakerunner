package snakerunner.graphics.hud;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

/*ScoreView is a HUD component and is used to show score in GamePanel*/
public final class ScoreView extends BaseView {

    private static final long serialVersionUID = 1L;
    private static final int WIDTH = 60;
    private static final int HEIGHT = 30;
    private static final String SCORE_TEXT = "Score : %03d";
    private static final int X = 1;
    private static final int Y = 15;
    
    private int score;

    public ScoreView() {
        setOpaque(false);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
    
    @Override
    public void setValue(int value) {
        this.score = value;
        repaint();
    }

    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);

        final String scoreText = String.format(SCORE_TEXT, score);

        g.setColor(Color.BLACK);
        g.drawString(scoreText, X, Y);
    }
    
}
