package snakerunner.graphics.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import snakerunner.commons.Point2D;
import snakerunner.controller.GameController;
import snakerunner.model.Collectible;
import snakerunner.model.Direction;
import snakerunner.model.Door;
import snakerunner.model.Snake;
import snakerunner.model.SnakeSegment;

public final class GameBoardPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final int CELL = 20;
    private final GameController controller;
    private Image foodImage, clockImage, keyImage, obstacleImage;
    private Image snakeHeadUp, snakeHeadDown, snakeHeadLeft, snakeHeadRight;
    private Image snakeTailUp, snakeTailDown, snakeTailLeft, snakeTailRight;
    private Image /*snakeBodyTopLeft, snakeBodyBottomLeft, snakeBodyBottomRight,*/ snakeBodyVertical, snakeBodyHorizontal;
    private Image doorClose, doorOpen;

    public GameBoardPanel(final GameController controller) {
        this.controller = controller;
        setOpaque(true);
        setBackground(Color.GRAY);
        loadImages();
    }

    /**
     * Draw all Components
     * @param g Graphics g
     */
    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);

        drawGrid(g);
        drawSnake(g);
        drawObstacle(g);
        drawCollectibles(g);
        drawDoors(g);
    }

    private void loadImages() {
        doorClose = loadImage("images/door_close.png");
        doorOpen = loadImage("images/door_open.png");
        foodImage = loadImage("images/food.png");
        clockImage = loadImage("images/clock.png");
        keyImage = loadImage("images/key.png");
        obstacleImage =loadImage("images/obstacle.png");
        snakeHeadUp = loadImage("images/head_up.png");
        snakeHeadDown = loadImage("images/head_down.png");
        snakeHeadLeft = loadImage("images/head_left.png");
        snakeHeadRight = loadImage("images/head_right.png");
        snakeTailUp = loadImage("images/tail_up.png");
        snakeTailDown = loadImage("images/tail_down.png");
        snakeTailLeft = loadImage("images/tail_left.png");
        snakeTailRight = loadImage("images/tail_right.png");
        //snakeBodyTopLeft = loadImage("images/body_topleft.png");
        //snakeBodyBottomLeft = loadImage("images/body_bottomleft.png");
        //snakeBodyBottomRight = loadImage("images/body_bottomright.png");
        snakeBodyVertical = loadImage("images/body_vertical.png");
        snakeBodyHorizontal = loadImage("images/body_horizontal.png");
    }

    private Image loadImage(String path) {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(path)) {
            if (is == null) {
                return null;
            }
            
            Image img = ImageIO.read(is);
            return img;
            
        } catch (IOException e) {
            throw new RuntimeException("Load Images Error", e);
        }
    }

    /**
     * Draw Grid
     * @param g Graphics g
     */
    private void drawGrid(final Graphics g) {
        g.setColor(Color.BLACK);

        final int panelWidth = getWidth();
        final int panelHeight = getHeight();

        final int cols = panelWidth / CELL;
        final int rows = panelHeight / CELL;

        final int gridWidth = cols * CELL;
        final int gridHeight = rows * CELL;

        for (int x = 0; x <= cols; x++) {
            g.drawLine(x * CELL, 0, x * CELL, gridHeight);
        }

        for (int y = 0; y <= rows; y++) {
            g.drawLine(0, y * CELL,gridWidth, y * CELL);
        }
    }

    /**
     * Draw snake
     * @param g
     */
    private void drawSnake(final Graphics g) {
        final Snake snake = controller.getSnake();

        if (snake == null || snake.getFullBody().isEmpty()) {
            return;
        }

        final List<SnakeSegment> body = snake.getFullBody();

        for (int i = 0; i < body.size(); i++) {
            final SnakeSegment segment = body.get(i);
            final Point2D<Integer, Integer> pos = segment.pos;
            final int x = pos.getX() * CELL;
            final int y = pos.getY() * CELL;

            final Image segmentImage;

            if (i == 0) {
                segmentImage = getHeadImage(controller.getDirection());
            } else if (i == body.size() - 1) {
                final Direction tailDirection = getDirection(body.get(i - 1).pos, pos);
                segmentImage = getTailImage(tailDirection);
            } else {
                final Point2D<Integer, Integer> prevPos = body.get(i - 1).pos;
                segmentImage = getBodyImage(prevPos, pos);
            }

                g.drawImage(segmentImage, x, y, CELL, CELL, this);
        }
    }

    /**
     * Get head image based on direction
     */
    private Image getHeadImage(final Direction direction) {
        return switch (direction) {
            case UP -> snakeHeadUp;
            case DOWN -> snakeHeadDown;
            case LEFT -> snakeHeadLeft;
            case RIGHT -> snakeHeadRight;
            default -> snakeHeadRight;
        };
    }

    /**
     * Get tail image based on direction
     */
    private Image getTailImage(final Direction direction) {
        return switch (direction) {
            case UP -> snakeTailUp;
            case DOWN -> snakeTailDown;
            case LEFT -> snakeTailLeft;
            case RIGHT -> snakeTailRight;
            default -> snakeTailRight;
        };
    }

    /**
     * Get body image (only vertical/horizontal)
     */
    private Image getBodyImage(final Point2D<Integer, Integer> prev, final Point2D<Integer, Integer> current) {
        
        final int dx = current.getX() - prev.getX();
        final int dy = current.getY() - prev.getY();

        if (dx == 0) {
            return snakeBodyVertical;
        }
        
        if (dy == 0) {
            return snakeBodyHorizontal;
        }

        return snakeBodyHorizontal;
    }

    /**
     * Calculate direction from one point to another
     */
    private Direction getDirection(final Point2D<Integer, Integer> from, final Point2D<Integer, Integer> to) {
        final int dx = to.getX() - from.getX();
        final int dy = to.getY() - from.getY();

        if (dx > 0) return Direction.RIGHT;
        if (dx < 0) return Direction.LEFT;
        if (dy > 0) return Direction.DOWN;
        if (dy < 0) return Direction.UP;

        return Direction.RIGHT;
    }

    /**
     * Draw obstacle
     * @param g
     */
    private void drawObstacle(final Graphics g) {
        g.setColor(Color.RED);

        for (final Point2D<Integer, Integer> p : controller.getObstacles()) {
            final int x = p.getX() * CELL;
            final int y = p.getY() * CELL;

            //g.fillRect(x * CELL, y * CELL, CELL, CELL);
            g.drawImage(obstacleImage, x, y, CELL, CELL, this);
        }
    }

    /**
     * Draw collectibles
     * @param g
     */
    private void drawCollectibles(final Graphics g) {
       for (final Collectible collectible : controller.getCollectibles()) {
        final Point2D<Integer, Integer> p = collectible.getPosition();
        final int x = p.getX() * CELL;
        final int y = p.getY() * CELL;

        switch (collectible.getType()) {
            case FOOD -> g.drawImage(foodImage, x, y, CELL, CELL, this);
            case CLOCK -> g.drawImage(clockImage, x, y, CELL, CELL, this);
            case KEY -> g.drawImage(keyImage, x, y, CELL, CELL, this);
            default -> {
                g.setColor(Color.YELLOW);
                g.fillOval(x, y, CELL, CELL);
            }
        }
       }
    }

    private void drawDoors(final Graphics g) {
        final List<Door> doors = controller.getDoors();

        if (doors == null) {
            return;
        }

        for (final Door door : doors) {
            Point2D<Integer, Integer> p = door.getPosition();
            final int x = p.getX() * CELL;
            final int y = p.getY() * CELL;

            final Image doorImage = door.isOpen() ? doorOpen : doorClose;

            if (doorImage != null) {
                g.drawImage(doorImage, x, y, CELL, CELL, this);
            }

        }
    }
}
