package snakerunner.model;

import snakerunner.commons.Point2D;

public interface Collectible {

    /**
     * Consumes the collectible, applying its effect to the game model.
     *
     * @param model The game model to which the collectible's effect will be applied.
     */
    public void consume(GameModel model);

    /**
     * Gets the position of the collectible in the game world.
     *
     * @return A Point2D representing the (x, y) coordinates of the collectible.
     */
    public Point2D<Integer, Integer> getPosition();

    /**
     * Gets the type of the collectible.
     *
     * @return The CollectibleType of this collectible.
     */
    public CollectibleType getType();
}
