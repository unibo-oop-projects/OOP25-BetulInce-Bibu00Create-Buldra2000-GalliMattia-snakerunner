package snakerunner.test.model;
import snakerunner.model.impl.GameModelImpl;
import snakerunner.commons.Point2D;
import snakerunner.model.Collectible;
import snakerunner.model.LevelData;
import snakerunner.model.VictoryCondition;
import snakerunner.model.Direction;
import snakerunner.model.impl.Key;
import snakerunner.model.Door;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;


/*
Verifies collisions between:
*Snake and an obstacle(walls)
*Snake and doors (Closed door case and open door case)
*Snake itself
*Snake and door when the key opens the door
*/

class CollisionTest {
    private GameModelImpl gameModel;
    private TestLevelData levelData;

 /*This is a setup that "cleans" the game before every test*/
    @BeforeEach
    void setUp() {
        gameModel = new GameModelImpl(); 
        levelData = new TestLevelData(); /* New Level  */
    }

    @Test
    /*Walls */
    void wallCollision() {
        /*We add an obstacle to 6,10. Since the snake is moving towards right it should hit */
        levelData.addObstacle(6,10);
        gameModel.loadLevel(levelData); /* Empty level */

    /*Initial state: game should be running */
        assertFalse(gameModel.isGameOver(), "Game shouldn't be over initally");
        gameModel.update();
    /*When the snake runs into a wall it triggers Game over */
        assertTrue(gameModel.isGameOver(), "Snake should die when it hits a wall");


    }

    @Test
    /*Snake itself */
    void selfCollision() {
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
    void doorCollision() {
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
        /* Opening a door */
        gameModel.openDoor();
        assertTrue(levelData.getDoors().get(0).isOpen());

        gameModel.update();
        assertFalse(gameModel.isGameOver(), "Snake should pass through an open door");
    }

      @Test
      /*Key that opens a door */
        void keyOpensDoor() {
            
            levelData.addKey(6,10);
            levelData.addDoor(7,10);
            gameModel.loadLevel(levelData); /*Empty level */
            
            /*Initally the door is closed */
            assertFalse(levelData.getDoors().get(0).isOpen(), "Initially door should be closed");
            gameModel.update(); /*We update and the snake collects the key */
            assertTrue(gameModel.getCollectibles().isEmpty(), "Key should be collected");
            assertTrue(levelData.getDoors().get(0).isOpen(), "Door should be open once the key is collected");
            gameModel.update(); 

            assertFalse(gameModel.isGameOver(), "Snake should pass through an open door");

        }



        /* Mocking for testing */
    static class TestLevelData implements LevelData {
        
        private final Set <Point2D<Integer,Integer>> obstacles= new HashSet<>();
        private final List <Collectible> collectibles= new ArrayList<>();
        private final List <Door> doors= new ArrayList<>();


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

    @Override
    public VictoryCondition getVictoryCondition() {
        return VictoryCondition.COLLECT_ALL_FOOD;
    }

    public void addDoor(final int x, final int y) {
        doors.add(new Door(x,y));
    }

    public void addObstacle(final int x, final int y) {
        obstacles.add(new Point2D<>(x,y));
    }
    public void addKey(final int x, final int y) {
        collectibles.add(new Key(new Point2D<>(x,y)));
    }

    }
}
