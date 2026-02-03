package snakerunner.graphics.hud;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import snakerunner.model.GameModel;

/*TimerView is a HUD component and is used to show level in GamePanel*/
public class LevelView extends JPanel{

    private static final String LEVEL_TEXT = "Level : %1d";
    private static final int WIDTH = 60;
    private static final int HEIGHT = 30;
    private static final int X = 5;
    private static final int Y = 15;

    private final GameModel gameModel;

    public LevelView(GameModel gameModel){
        this.gameModel = gameModel;
        setOpaque(false);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.drawString("Level :" + gameModel.getLevel(), X, Y);
    }
    
}
