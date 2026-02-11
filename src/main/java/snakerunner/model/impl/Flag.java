package snakerunner.model.impl;

import snakerunner.audio.AudioPlayer;
import snakerunner.commons.Point2D;
import snakerunner.model.Collectible;
import snakerunner.model.CollectibleType;
import snakerunner.model.GameModel;

/**
 * MISSING JAVADOC.
 */
public final class Flag implements Collectible {
    private static final String FLAG = "sounds/flag.wav";
    private final Point2D<Integer, Integer> position;

    /**
     * Constructs a Flag collectible at the specified position.
     *
     * @param position The (x, y) coordinates where the flag is located in the game world.
     */
    public Flag(final Point2D<Integer, Integer> position) {
        this.position = position;
    }

    @Override
    public void consume(final GameModel model) {
        AudioPlayer.playSound(FLAG);
        model.completeLevel(); /* A level is completed when the flag is consumed */
    }

    @Override
    public CollectibleType getType() {
    return CollectibleType.FLAG;

    }

    @Override
    public Point2D<Integer, Integer> getPosition() {
        return position;
    }
}
