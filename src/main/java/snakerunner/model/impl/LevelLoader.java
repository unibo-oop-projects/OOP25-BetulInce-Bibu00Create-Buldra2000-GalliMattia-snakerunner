package snakerunner.model.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import snakerunner.commons.Point2D;
import snakerunner.model.Collectible;
import snakerunner.model.Door;
import snakerunner.model.LevelData;

/**
 * The LevelLoader class is responsible for loading level data from a list of strings, 
 * which can be read from a file.
 */
public final class LevelLoader {

    private LevelLoader() { }

    /**
     * Loads level data from a list of strings from a file.
     * 
     * @param lines the lines read from the level file.
     * 
     * @return a LevelData object containing the obstacles and collectibles for the level.
     * 
     * @throws IOException if there is an error parsing the level data.
     */
    public static LevelData load(final List<String> lines) throws IOException {
        
        Set<Point2D<Integer, Integer>> obstacles = new HashSet<>();
        List<Collectible> collectibles = new ArrayList<>();
        List<Door> doors = new ArrayList<>();

        String section = null;

        for (final String raw : lines) {
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

            if (line.equalsIgnoreCase("[Doors]")) { //TEMPORARY FIX, USE TO TEST gameBoardPanel drawDoors()
                section = "doors";
                continue;
            }

            if (section == null) {
                continue; 
            }

            String[] parts = line.split(",");
            final int x = Integer.parseInt(parts[0].trim());
            final int y = Integer.parseInt(parts[1].trim());

            Point2D<Integer, Integer> p = new Point2D<>(x, y);

            if (section.equals("obstacles")) {
                obstacles.add(p);
            } else if (section.equals("collectibles")) {
                String type = parts[2].trim().toUpperCase();

                switch (type) {
                    case "FOOD" -> collectibles.add(new FoodImpl(p));

                    case "CLOCK" -> collectibles.add(new Clock(p));
                    
                    case "KEY" -> collectibles.add(new Key(p));

                    case "LIFE_BOOST" -> collectibles.add(new LifeBoost(p));
                        
                    default -> throw new IOException("Unknown collectible type: " + type);
                }
            } else if (section.equals("doors")) { //TEMPORARY FIX, USE TO TEST gameBoardPanel drawDoors()
                doors.add(new Door(x, y));
            }
        }

        return new LevelDataImpl(obstacles, collectibles, doors);
    }
}
