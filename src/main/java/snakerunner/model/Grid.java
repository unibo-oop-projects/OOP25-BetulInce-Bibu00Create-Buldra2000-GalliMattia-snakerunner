package snakerunner.model;

import snakerunner.commons.Point2D;

/**
 * Interface representing the grid of the game.
 */
public interface Grid {
    /**
     * Checks if the given position is inside the grid boundaries.
     * 
     * @param position to check.
     * @return true if the position is inside the grid, false otherwise.
     */
    boolean isInsideGrid(Point2D<Integer, Integer> position);

    int getWidth();

    int getHeight();

}
