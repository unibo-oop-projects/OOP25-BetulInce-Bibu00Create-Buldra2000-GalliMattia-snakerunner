package snakerunner.graphics.hud.impl;

import java.awt.Color;
import java.awt.Graphics;

import snakerunner.graphics.hud.BaseView;

/*LifeView is a HUD component and is used to show the remaining life in GamePanel*/
public class LifeView extends BaseView{

    private static final String LIFE_TEXT = "Life : %1d";
    private static final int X = 5;
    private static final int Y = 15;
    private static final int WIDTH = 60;
    private static final int HEIGHT = 30;

    private int life;

    public LifeView(){
        super(WIDTH, HEIGHT);
    }

    @Override
    public void setValue(int life){
        this.life = life;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        String lifeText = String.format(LIFE_TEXT, life);

        g.setColor(Color.BLACK);
        g.drawString(lifeText, X, Y);
    }
    
}
