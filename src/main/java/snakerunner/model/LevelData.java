package snakerunner.model;

import java.util.List;
import java.util.Set;

import snakerunner.commons.Point2D;

public interface LevelData {
    public Set<Point2D<Integer, Integer>> getObstacles();
    public List<Collectible> getCollectibles();
}
