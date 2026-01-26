package snakerunner.graphics.hud.impl;

import java.awt.Color;
import java.awt.Graphics;

import snakerunner.graphics.hud.BaseView;

/*TimerView is a HUD component and is used to show level in GamePanel*/
public class LevelView extends BaseView{

    private static final String LEVEL_TEXT = "Level : %1d";
    private static final int WIDTH = 60;
    private static final int HEIGHT = 30;
    private static final int X = 5;
    private static final int Y = 15;

    private int level;

    public LevelView(){
        super(WIDTH, HEIGHT);
    }

    @Override
    public void setValue(int level){
        this.level = level;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        String levelText = String.format(LEVEL_TEXT, level);

        g.setColor(Color.BLACK);
        g.drawString(levelText, X, Y);
    }
    
}
