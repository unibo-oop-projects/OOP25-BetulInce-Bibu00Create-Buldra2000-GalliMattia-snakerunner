package snakerunner.model.impl;

import java.util.List;
import java.util.Set;

import snakerunner.commons.Point2D;
import snakerunner.model.LevelData;

public class LevelDataImpl implements LevelData {
    private final Set<Point2D<Integer, Integer>> obstacles;
    private final List<Point2D<Integer, Integer>> foodPositions;

    public LevelDataImpl(Set<Point2D<Integer, Integer>> obstacles, List<Point2D<Integer, Integer>> foodPositions) {
        this.obstacles = obstacles;
        this.foodPositions = foodPositions;
    }

    @Override
    public Set<Point2D<Integer, Integer>> getObstacles() {
        return this.obstacles;
    }

    @Override
    public List<Point2D<Integer, Integer>> getFoodPositions() {
        return this.foodPositions;
    }
    
}
