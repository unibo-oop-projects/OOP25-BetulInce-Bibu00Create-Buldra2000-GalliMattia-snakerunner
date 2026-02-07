package snakerunner.model.impl;

import snakerunner.commons.Point2D;
import snakerunner.model.Collectible;
import snakerunner.model.CollectibleType;
import snakerunner.model.GameModel;

/**
 * Class representing a clock collectible that slows down the snake's speed when consumed.
 */
public class Clock implements Collectible {
    private final Point2D<Integer, Integer> position;

    /**
     * Constructor for the Clock collectible.
     * 
     * @param position the position of the clock on the grid.
     */
    public Clock(final Point2D<Integer, Integer> position) {

        this.position = position;
    }

    /**
     * Consumes the clock collectible, applying its effect to the game model.
     *
     * @param model The game model to which the clock's effect will be applied.
     */
    @Override
    public void consume(final GameModel model) {
        model.applySlowEffect();
    }

    /**
     * Gets the position of the clock collectible in the game world.
     *
     * @return A Point2D representing the (x, y) coordinates of the clock.
     */
    @Override
    public Point2D<Integer, Integer> getPosition() {
        return position;
    }

    /**
     * Gets the type of the collectible.
     *
     * @return The CollectibleType of this collectible, which is CLOCK.
     */
    @Override
    public CollectibleType getType() {
        return CollectibleType.CLOCK;
    }
}
