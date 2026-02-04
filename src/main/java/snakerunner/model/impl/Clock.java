package snakerunner.model.impl;

import snakerunner.commons.Point2D;
import snakerunner.model.Collectible;
import snakerunner.model.Snake;

public class Clock implements Collectible{
    private final Point2D<Integer, Integer> position;

    public Clock(Point2D<Integer, Integer> position){
        this.position = position;
    }

    @Override
    public void consume(Snake snake) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'consume'");
    }

    @Override
    public Point2D<Integer, Integer> getPosition() {
        return position;
    }
    
}
