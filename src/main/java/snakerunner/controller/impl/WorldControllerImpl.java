package snakerunner.controller.impl;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import snakerunner.commons.Point2D;
import snakerunner.controller.WorldController;
import snakerunner.model.Collectible;
import snakerunner.model.Direction;
import snakerunner.model.Door;
import snakerunner.model.GameModel;
import snakerunner.model.Snake;

public class WorldControllerImpl implements WorldController {

    private GameModel gameModel;

    public WorldControllerImpl(final GameModel gameModel) {
        this.gameModel = gameModel;
    }

    @Override
    public Snake getSnake() {
        return gameModel.getSnake();
    }

    @Override
    public Set<Point2D<Integer, Integer>> getObstacles() {
        return gameModel.getLevel().getObstacles();
    }

    @Override
    public List<Collectible> getCollectibles() {
        return gameModel.getCollectibles();
    }

    @Override
    public List<Door> getDoors() {
        if (gameModel.getLevel() != null) {
            return gameModel.getLevel().getDoors();
        }
            return Collections.emptyList();
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public int getScore() {
        return gameModel.getScore();
    }

    @Override
    public Direction getDirection() {
        return gameModel.getSnake().getCurrentDirection();
    }
    
}
