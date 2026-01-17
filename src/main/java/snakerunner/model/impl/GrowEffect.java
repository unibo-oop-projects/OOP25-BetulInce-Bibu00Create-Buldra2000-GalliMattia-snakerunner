package snakerunner.model.impl;

import snakerunner.model.FoodEffect;
import snakerunner.model.Snake;

public class GrowEffect  implements FoodEffect{
    private int segment;

    public GrowEffect(int segment) {
        this.segment = segment;
    }

    @Override
    public void apply(GameModel model, Snake snake) {
        for (int i = 0; i < segments; i++) {
            snake.grow();
        }
    }
}
