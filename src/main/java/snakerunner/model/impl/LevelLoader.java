package snakerunner.model.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import snakerunner.commons.Point2D;
import snakerunner.model.Collectible;
import snakerunner.model.LevelData;

public final class LevelLoader {

    private LevelLoader() {}

    public static LevelData load(List<String> lines) throws IOException {
        
        Set<Point2D<Integer, Integer>> obstacles = new HashSet<>();
        List<Collectible> collectibles = new ArrayList<>();

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

            if (line.equalsIgnoreCase("[Collectibles]")) {
                section = "collectibles";
                continue;
            }

            if (section == null) {
                continue; 
            }

            String[] parts = line.split(",");
            int x = Integer.parseInt(parts[0].trim());
            int y = Integer.parseInt(parts[1].trim());

            Point2D<Integer, Integer> p = new Point2D<>(x, y);

            if (section.equals("obstacles")) {
                obstacles.add(p);
            } else if (section.equals("collectibles")) {
                String type = parts[2].trim().toUpperCase();

                switch (type) {
                    case "FOOD" -> collectibles.add(new FoodImpl(p));

                    case "CLOCK" -> collectibles.add(new Clock(p));
                    
                    case "KEY" -> collectibles.add(new Key(p));
                        
                    default -> throw new IOException("Unknown collectible type: " + type);
                }
            }
        }

        return new LevelDataImpl(obstacles, collectibles);
    }
}
