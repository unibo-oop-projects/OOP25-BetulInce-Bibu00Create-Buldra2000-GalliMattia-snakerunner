package snakerunner.graphics.hud.impl;

import java.awt.Color;
import java.awt.Graphics;

import snakerunner.graphics.hud.BaseView;

/*ScoreView is a HUD component and is used to show score in GamePanel*/
public class ScoreView extends BaseView{

    private static final int WIDTH = 100;
    private static final int HEIGHT = 30;
    private static final String SCORE_TEXT = "Score : %03d";
    private static final int X = 1;
    private static final int Y = 15;
    
    private int score;

    public ScoreView(){
        super(WIDTH, HEIGHT);
        setMaximumSize(getPreferredSize());
    }
    
    @Override
    public void setValue(int score){
        this.score = score;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        String scoreText = String.format(SCORE_TEXT, score);

        g.setColor(Color.BLACK);
        g.drawString(scoreText, X, Y);
    }
    
}
