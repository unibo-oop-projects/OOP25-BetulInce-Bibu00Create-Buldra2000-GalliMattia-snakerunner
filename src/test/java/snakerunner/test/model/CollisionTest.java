package snakerunner.test.model;
import snakerunner.model.impl.GameModelImpl;
import snakerunner.commons.Point2D;
import snakerunner.model.Obstacle;
import snakerunner.model.Collectible;
import snakerunner.model.LevelData;
import snakerunner.model.Direction;
import snakerunner.model.Snake;
import snakerunner.model.Door;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;


/*
Verifies collisions between:
*Snake and an obstacle(walls)
*Snake and doors
*Snake itself
*/

class CollisionTest {
    private GameModelImpl gameModel;
    private TestLevelData levelData;

 /*This is a setup that "cleans" the game */
 @BeforeEach
    void setUp() {
        gameModel = new GameModelImpl();
        levelData = new TestLevelData();
    }

    @Test
    /*Walls */
    void WallCollision() {
        /*We add an obstacle to 6,10. Since the snake is moving towards right it should hit */
        levelData.addObstacle(6,10);
        gameModel.loadLevel(levelData); /*Empty level */

    /*Initial state: game should be running */
        assertFalse(gameModel.isGameOver(), "Game shouldn't be over initally");
        gameModel.update();
/*When the snake runs into a wall it loses */
        assertTrue(gameModel.isGameOver(), "Snake should die when it hits a wall");


    }

    @Test
    /*Snake itself */
    void SelfCollision() {
        gameModel.loadLevel(levelData); /*Empty level */

        /*Snake moves into a circle to collide with itself*/
        gameModel.getSnake().setDirection(Direction.RIGHT);
        gameModel.update();

        gameModel.getSnake().setDirection(Direction.DOWN);
        gameModel.update();

        gameModel.getSnake().setDirection(Direction.LEFT);
        gameModel.update();

        gameModel.getSnake().setDirection(Direction.UP);
        gameModel.update();

    assertTrue(gameModel.isGameOver(), "Snake should die when it hits itself");

    }

    @Test
    /*Doors */
    void DoorCollision() {
        /* Case door closed */
        levelData.addDoor(6,10);
        gameModel.loadLevel(levelData); /*Empty level */

        assertFalse(levelData.getDoors().get(0).isOpen());
        gameModel.update();

        assertTrue(gameModel.isGameOver(), "Snake should die when hitting a closed door");
        
        /* Case door open */
        setUp();
        levelData.addDoor(6,10);
        gameModel.loadLevel(levelData); /*Empty level */

        gameModel.openDoor();
        assertTrue(levelData.getDoors().get(0).isOpen());

        gameModel.update();
        assertFalse(gameModel.isGameOver(), "Snake should pass through an open door");
    }


    static class TestLevelData implements LevelData {
        
        private Set <Point2D<Integer,Integer>> obstacles= new HashSet<>();
        private List <Collectible> collectibles= new ArrayList<>();
        private List <Door> doors= new ArrayList<>();


    @Override
    public Set<Point2D<Integer, Integer>> getObstacles() {
    return obstacles;
    }

    @Override
    public List<Door> getDoors() {
    return doors;
    }

    @Override
    public List<Collectible> getCollectibles() {
        return collectibles;
    }

    public void addDoor(int x, int y) {
        doors.add(new Door(x,y));
    }
    public void addObstacle(int x, int y) {
        obstacles.add(new Point2D<>(x,y));
    }

    }
}
