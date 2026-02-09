package snakerunner.model.impl;

import java.util.Set;

import snakerunner.commons.Point2D;
import snakerunner.model.Grid;
import snakerunner.model.Level;
import snakerunner.model.LevelData;

/**
 * Implementation of the Level interface representing a level in the game.
 */
public class LevelImpl implements Level {
    private static final int WIDTH = 20;
    private static final int HEIGHT = 20;

    private final Grid grid;
    private final Set<Point2D<Integer, Integer>> obstacles;
    private final java.util.List<snakerunner.model.Door> doors;

    /**
     * Constructs a LevelImpl with the specified level data.
     * 
     * @param data The level data which contains obstacles and collectibles.
     */
    public LevelImpl(final LevelData data) {
        this.grid = new GridImpl(WIDTH, HEIGHT);
        this.obstacles = data.getObstacles();
        this.doors = data.getDoors();
    }

    /**
     * Returns the grid associated with the level.
     * 
     * @return the grid of the level.
     */
    @Override
    public Grid getGrid() {
        return grid;
    }

    /**
     * Returns the set of obstacles present in the level.
     * 
     * @return a set of points representing the obstacles.
     */
    @Override
    public Set<Point2D<Integer, Integer>> getObstacles() {
        return obstacles;

    }
    @Override
    public java.util.List getDoors() {
        return doors;
    }



    /**
     * Checks if the given position is blocked by an obstacle or is outside the grid.
     * 
     * @param position to check.
     * 
     * @return true if the position is blocked, false otherwise.
     */
    @Override
    public boolean isBlocked(final Point2D<Integer, Integer> position) {
        return !grid.isInsideGrid(position) || obstacles.contains(position);
    }
}
