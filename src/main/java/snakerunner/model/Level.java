package snakerunner.model;

import java.util.Set;

import snakerunner.commons.Point2D;

public interface Level {
    public Grid getGrid();

    public Set<Point2D<Integer, Integer>> getObstacles();

    public  boolean IsBlocked(Point2D<Integer, Integer> position);
}
