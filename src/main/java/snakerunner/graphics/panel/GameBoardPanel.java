package snakerunner.graphics.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GameBoardPanel extends JPanel {

    private static final int CELL = 10;

    private int rows = 60;
    private int cols = 60;

    public GameBoardPanel(){
        setOpaque(true);
        setBackground(Color.GRAY);
        setPreferredSize(new Dimension(cols * CELL, rows * CELL));
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        drawGrid(g);
        drawSnake(g);
        drawObstacle(g);
        //Food
    }

    private void drawGrid(Graphics g){
        g.setColor(Color.BLACK);

        int width = cols * CELL;
        int height = rows * CELL;

        for (int x = 0; x <= cols; x++){
            g.drawLine(x * CELL, 0, x * CELL, height);
        }

        for (int y = 0; y <= rows; y++){
            g.drawLine(0, y * CELL,width, y * CELL);
        }
    }

    private void drawSnake(Graphics g){}
    private void drawObstacle(Graphics g){}

}
