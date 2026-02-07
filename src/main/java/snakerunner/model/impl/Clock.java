package snakerunner.model.impl;

import snakerunner.commons.Point2D;
import snakerunner.model.Collectible;
import snakerunner.model.CollectibleType;
import snakerunner.model.GameModel;

public class Clock implements Collectible{
    private final Point2D<Integer, Integer> position;

    public Clock(Point2D<Integer, Integer> position){
        this.position = position;
    }

    @Override
    public void consume(GameModel model) {
        model.applySlowEffect();
    }

    @Override
    public Point2D<Integer, Integer> getPosition() {
        return position;
    }

    @Override
    public CollectibleType getType() {
        return CollectibleType.CLOCK;
    }
    
}
