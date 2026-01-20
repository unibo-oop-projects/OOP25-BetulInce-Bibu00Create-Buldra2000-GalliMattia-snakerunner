package snakerunner.model.impl;

<<<<<<< HEAD
import java.util.Set;
import snakerunner.commons.Point2D;
import snakerunner.model.Grid;
=======
>>>>>>> ab5c8e9 (added the level implementation)
import snakerunner.model.Level;

public class LevelImpl implements Level{
    // GRANDEZZA LIVELLO
<<<<<<< HEAD
    private final Grid grid;
    private final Set<Point2D<Integer, Integer>> obstacles;

    public LevelImpl(Grid grid, Set<Point2D<Integer, Integer>> obstacles) {
        this.grid = grid;
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
=======
    // private final int width;
    // private final int height;
    private final int baseSpeed;
    private final int ItemCount;
    private final int levelDuration;

    public LevelImpl(int baseSpeed, int itemCount, int levelDuration) {
        this.baseSpeed = baseSpeed;
        this.ItemCount = itemCount;
        this.levelDuration = levelDuration;
>>>>>>> ab5c8e9 (added the level implementation)
    }
}
