package snakerunner.model.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import snakerunner.commons.Point2D;
import snakerunner.model.Collectible;
import snakerunner.model.LevelData;

public class LevelDataImpl implements LevelData {
    private final Set<Point2D<Integer, Integer>> obstacles;
    private final List<Collectible> collectibles;

    public LevelDataImpl(Set<Point2D<Integer, Integer>> obstacles, List<Collectible> collectibles) {
        this.obstacles = new HashSet<>(obstacles);
        this.collectibles = new ArrayList<>(collectibles);
    }

    // ritorna copia per sicurezza e non il set originale
    @Override
    public Set<Point2D<Integer, Integer>> getObstacles() {
        return new HashSet<>(obstacles);
    }

    // ritorna copia per sicurezza e non la lista originale
    @Override
    public List<Collectible> getCollectibles() {
        return new ArrayList<>(collectibles);
    }
    
}
