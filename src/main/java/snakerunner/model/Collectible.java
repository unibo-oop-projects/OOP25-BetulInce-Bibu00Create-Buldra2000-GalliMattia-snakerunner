package snakerunner.model;

import snakerunner.commons.Point2D;

public interface Collectible {
    public void consume(Snake snake);

    public Point2D<Integer, Integer> getPosition();
}
