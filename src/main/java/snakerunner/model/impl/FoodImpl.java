package snakerunner.model.impl;

import snakerunner.commons.Point2D;
import snakerunner.model.Food;
import snakerunner.model.FoodEffect;
import snakerunner.model.Snake;

public class FoodImpl implements Food{
    private final FoodEffect effect;
    private final Point2D<Integer, Integer> position;

    public FoodImpl(FoodEffect effect, Point2D<Integer, Integer> position){
        this.position = position;
        this.effect = effect;
    }

    @Override
    public void consume(Snake snake) {
        effect.apply(snake);
    }

    @Override
    public Point2D<Integer, Integer> getPosition() {
        return position;
    }
}
