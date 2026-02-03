package snakerunner.graphics.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import snakerunner.model.Position;

public class GameBoardPanel extends JPanel {

    private static final int CELL = 10;

    private Point apple;
    private List<Position> snakeBody = new ArrayList<>();


    public GameBoardPanel(){
        setOpaque(true);
        setBackground(Color.GRAY);
    }

    private java.util.Set<snakerunner.commons.Point2D<Integer, Integer>> obstacles;

    public void setObstacles(java.util.Set<snakerunner.commons.Point2D<Integer, Integer>> obstacles){
    this.obstacles= obstacles;
    }


    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);


        //Drawing obstacles
        //If obstacles are ≠ null
        if (obstacles != null) {

        g.setColor(Color.ORANGE);//We set the color to orange 
        for(snakerunner.commons.Point2D<Integer,Integer> p : obstacles){
            g.fillRect(p.getX() * CELL, p.getY() * CELL, CELL, CELL); //Moltiplication * CELL because of cell dimension
        }
        }

        g.setColor(Color.GREEN);
        for(Position p : snakeBody){
            g.fillRect(p.getX() * CELL, p.getY() * CELL, CELL, CELL);
        }

        if(apple != null){
            g.setColor(Color.RED);
            g.fillOval(apple.x * CELL, apple.y * CELL, CELL, CELL);
        }
    }

    public void setApple(Point apple) {
        this.apple = apple;
    }

    public void setSnakeBody(List<Position> snakeBody) {
        this.snakeBody = snakeBody;
    }
}
