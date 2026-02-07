package snakerunner.model;

import java.util.List;

import snakerunner.commons.Point2D;

public interface  Snake {
    public void move();

    public void setDirection(Direction direction);

    public Point2D<Integer, Integer> getHead();

    public List<Point2D<Integer, Integer>> getBody();

    public boolean isCollidingWithItself();
        
}
