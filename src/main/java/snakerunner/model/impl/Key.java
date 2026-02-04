package snakerunner.model.impl;

import snakerunner.commons.Point2D;
import snakerunner.model.Collectible;
import snakerunner.model.Snake;

public class Key implements Collectible{
    private final Point2D<Integer, Integer> position;

    public Key(Point2D<Integer, Integer> position){
        this.position = position;
    }

    @Override
    public void consume(Snake snake) {
        //model.openDoor();
    }

    @Override
    public Point2D<Integer, Integer> getPosition() {
        return position;
    }
    
}
