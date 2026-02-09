package snakerunner.model.impl;

import snakerunner.audio.AudioPlayer;
import snakerunner.commons.Point2D;
import snakerunner.model.Collectible;
import snakerunner.model.CollectibleType;
import snakerunner.model.GameModel;

public class LifeBoost implements Collectible {
    private final Point2D<Integer, Integer> position;

    public LifeBoost(final Point2D<Integer, Integer> position) {
        this.position = position;
    }

    @Override
    public void consume(GameModel model) {
        AudioPlayer.playSound("lifeup.wav");
        //model.addLife(); //TODO implementare addLife() in GameModelImpl
    }

    @Override
    public Point2D<Integer, Integer> getPosition() {
        return position;
    }

    @Override
    public CollectibleType getType() {
        return CollectibleType.LIFE_BOOST;
    }
}
