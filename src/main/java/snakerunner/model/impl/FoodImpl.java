package snakerunner.model.impl;

import snakerunner.commons.Point2D;
import snakerunner.model.Collectible;
import snakerunner.model.CollectibleType;
import snakerunner.model.GameModel;

public class FoodImpl implements Collectible{
    private final static int SCORE_POINTS = 10;
    private final Point2D<Integer, Integer> position;

    public FoodImpl(Point2D<Integer, Integer> position){
        this.position = position;
    }

    @Override
    public void consume(GameModel model) {
        model.addScore(SCORE_POINTS);
    }

    @Override
    public Point2D<Integer, Integer> getPosition() {
        return position;
    }

    @Override
    public CollectibleType getType() {
        return CollectibleType.FOOD;
    }
}
