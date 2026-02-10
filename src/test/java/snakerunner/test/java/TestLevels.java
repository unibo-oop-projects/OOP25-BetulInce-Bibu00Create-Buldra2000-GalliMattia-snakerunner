package snakerunner.test.java;

import java.util.List;
import java.util.Set;

import snakerunner.model.LevelData;
import snakerunner.model.impl.LevelDataImpl;

public final class TestLevels {

    private TestLevels() {}

    public static LevelData simpleLevel() {
        return new LevelDataImpl(
            Set.of(), // nessun ostacolo
            List.of(),
            null
        );
    }
}
