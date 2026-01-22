package snakerunner.model.impl;

import snakerunner.commons.Point2D;
import snakerunner.model.Grid;

public class GridImpl implements Grid{
    private final int width;
    private final int height;

    public GridImpl(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean isInsideGrid(Point2D<Integer, Integer> position) {
        int x = position.getX();
        int y = position.getY();
        return x >= 0 && x < width && y >= 0 && y < height;
    }
    
}
