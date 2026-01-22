package snakerunner.graphics.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class GameBoardPanel extends JPanel {

    private static final int CELL = 10;

    private Point apple;
    private List<Point> snakeBody = new ArrayList<>();


    public GameBoardPanel(){
        setOpaque(true);
        setBackground(Color.GRAY);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.GREEN);
        for(Point p : snakeBody){
            g.fillRect(p.x * CELL, p.y * CELL, CELL, CELL);
        }

        if(apple != null){
            g.setColor(Color.RED);
            g.fillOval(apple.x * CELL, apple.y * CELL, CELL, CELL);
        }
    }

    public void setApple(Point apple) {
        this.apple = apple;
    }

    public void setSnakeBody(java.util.List<Point> snakeBody) {
        this.snakeBody = snakeBody;
    }
}
