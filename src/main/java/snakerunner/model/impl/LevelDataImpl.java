package snakerunner.model.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import snakerunner.commons.Point2D;
import snakerunner.model.Collectible;
import snakerunner.model.LevelData;

/**
 * The LevelDataImpl class implements the LevelData interface 
 * and provides the data for a level, including obstacles and collectibles.
 */
public class LevelDataImpl implements LevelData {
    private final Set<Point2D<Integer, Integer>> obstacles;
    private final List<Collectible> collectibles;

    /**
     * Constructs a LevelDataImpl with the specified obstacles and collectibles.
     * 
     * @param obstacles of the level.
     * @param collectibles of the level.
     */
    public LevelDataImpl(final Set<Point2D<Integer, Integer>> obstacles, final List<Collectible> collectibles) {
        this.obstacles = new HashSet<>(obstacles);
        this.collectibles = new ArrayList<>(collectibles);
    }

    /**
     * Returns the set of obstacles in the level.
     * 
     * @return A set of Point2D representing the positions of the obstacles.
     */
    @Override
    public Set<Point2D<Integer, Integer>> getObstacles() {
        return new HashSet<>(obstacles);
    }

    /**
     * Returns the list of collectibles in the level.
     * 
     * @return A list of Collectible objects.
     */
    @Override
    public List<Collectible> getCollectibles() {
        return new ArrayList<>(collectibles);
    }
}
