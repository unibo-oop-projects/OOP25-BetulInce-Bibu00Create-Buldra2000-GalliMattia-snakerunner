package snakerunner.model.impl;

import snakerunner.audio.AudioPlayer;
import snakerunner.commons.Point2D;
import snakerunner.model.Collectible;
import snakerunner.model.CollectibleType;
import snakerunner.model.GameModel;

/**
 * Implementation of the Food collectible in the Snake Runner game.
 * When consumed, it increases the player's score.
 */
public class FoodImpl implements Collectible {
    private static final String FOOD = "sounds/eat.wav";
    private final int scorePoints = 10;
    private final Point2D<Integer, Integer> position;

    /**
     * Constructor for FoodImpl.
     * 
     * @param position The position of the food item in the game world.
     */
    public FoodImpl(final Point2D<Integer, Integer> position) {
        this.position = position;
    }

    /**
     * Consumes the food item, applying its effect to the game model by increasing the player's score.
     *
     * @param model The game model to which the food's effect will be applied.
     */
    @Override
    public void consume(final GameModel model) {
        AudioPlayer.playSound(FOOD);
        model.addScore(scorePoints);
    }

    /**
     * Gets the position of the food item in the game world.
     *
     * @return A Point2D representing the (x, y) coordinates of the food item.
     */
    @Override
    public Point2D<Integer, Integer> getPosition() {
        return position;
    }

    /**
     * Gets the type of the collectible, which is FOOD for this implementation.
     * 
     * @return The CollectibleType of this collectible, which is FOOD.
     */
    @Override
    public CollectibleType getType() {
        return CollectibleType.FOOD;
    }
}
