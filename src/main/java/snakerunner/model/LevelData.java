package snakerunner.model;

import java.util.List;
import java.util.Set;

import snakerunner.commons.Point2D;

public interface LevelData {
    /**
     * Returns the set of obstacles present in the level.
     * @return a set of points representing the obstacles.
     */
    Set<Point2D<Integer, Integer>> getObstacles();

    /**
     * Returns the list of collectibles present in the level.
     * @return a list of collectibles.
     */
    List<Collectible> getCollectibles();
}
