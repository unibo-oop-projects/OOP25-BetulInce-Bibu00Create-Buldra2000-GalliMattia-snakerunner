package snakerunner.model.impl;

import snakerunner.audio.AudioPlayer;
import snakerunner.commons.Point2D;
import snakerunner.model.Collectible;
import snakerunner.model.CollectibleType;
import snakerunner.model.GameModel;

/**
 * Bomb represent a colletible that kill the snake.
 */
public class Bomb implements Collectible {

    private final Point2D<Integer, Integer> position;

    public Bomb(final Point2D<Integer, Integer> position) {
        this.position = position;
    }

    /**
     * Constructor for the Bomb collectible.
     * 
     * @param position the position of the bomb on the grid.
     */
    @Override
    public void consume(GameModel model) {
        AudioPlayer.playSound("sounds/bomb.wav");
        model.killSnake();
    }

    /**
     * Gets the position of the bomb collectible in the game world.
     *
     * @return A Point2D representing the (x, y) coordinates of the bomb.
     */
    @Override
    public Point2D<Integer, Integer> getPosition() {
        return position;
    }

    /**
     * Gets the type of the collectible.
     *
     * @return The CollectibleType of this collectible, which is BOMB.
     */
    @Override
    public CollectibleType getType() {
        return CollectibleType.BOMB;
    }
    
}
