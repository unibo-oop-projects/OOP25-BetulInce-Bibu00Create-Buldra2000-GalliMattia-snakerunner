package snakerunner.model.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import snakerunner.commons.Point2D;
import snakerunner.model.LevelData;

public final class LevelLoader {

    private LevelLoader() {}

    public static LevelData load(List<String> lines) throws IOException {
        
        Set<Point2D<Integer, Integer>> obstacles = new HashSet<>();
        List<Point2D<Integer, Integer>> foodPositions = new ArrayList<>();

        String section = null;

        for (String raw : lines) {
            String line = raw.trim();

            if (line.isEmpty() || line.startsWith("#")) {
                continue;
            }

            if (line.equalsIgnoreCase("[Obstacles]")) {
                section = "obstacles";
                continue;
            }

            if (line.equalsIgnoreCase("[Food]")) {
                section = "food";
                continue;
            }

            if (section == null) {
                continue; // ignora righe fuori sezione
            }

            String[] parts = line.split(",");
            int x = Integer.parseInt(parts[0].trim());
            int y = Integer.parseInt(parts[1].trim());

            Point2D<Integer, Integer> p = new Point2D<>(x, y);

            if (section.equals("obstacles")) {
                obstacles.add(p);
            } else if (section.equals("food")) {
                foodPositions.add(p);
            }
        }

        return new LevelDataImpl(obstacles, foodPositions);
    }
}
