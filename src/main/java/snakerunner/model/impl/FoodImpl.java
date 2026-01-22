package snakerunner.model.impl;

import snakerunner.model.Food;
import snakerunner.model.FoodEffect;
import snakerunner.model.Snake;

public class FoodImpl implements Food{
    private FoodEffect effect;

    public FoodImpl(FoodEffect effect) {
        this.effect = effect;
    }

    @Override
    public void consume(Snake snake) {
        effect.apply(snake);
    }
}
