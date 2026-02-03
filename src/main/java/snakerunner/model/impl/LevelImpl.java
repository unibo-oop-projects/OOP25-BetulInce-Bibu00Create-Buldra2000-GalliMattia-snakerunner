package snakerunner.model.impl;

import java.util.Set;
import snakerunner.commons.Point2D;
import snakerunner.model.Grid;

import snakerunner.model.Level;

public class LevelImpl implements Level{
    // GRANDEZZA LIVELLO
    private final Grid grid;
    private final Set<Point2D<Integer, Integer>> obstacles;

    // private final int width;
    // private final int height;

    private final int baseSpeed;
    private final int ItemCount;
    private final int levelDuration;

    public LevelImpl(Grid grid, Set<Point2D<Integer, Integer>> obstacles) {
        this.grid = grid;
        this.baseSpeed = baseSpeed;
        this.ItemCount = itemCount;
        this.levelDuration = levelDuration;
        this.obstacles = obstacles;
    }

    @Override
    public Grid getGrid() {
        return grid;
    }

    @Override
    public Set<Point2D<Integer, Integer>> getObstacles() {
        return obstacles;
    }

    @Override
    public boolean IsBlocked(Point2D<Integer, Integer> position) {
        return !grid.isInsideGrid(position) || obstacles.contains(position);
    }
}
