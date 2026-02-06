package snakerunner.graphics.panel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import snakerunner.commons.Point2D;
import snakerunner.controller.Controller;
import snakerunner.model.Collectible;

public final class GameBoardPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final int CELL = 15;
    private final Controller controller;

    public GameBoardPanel(final Controller controller) {
        this.controller = controller;
        setOpaque(true);
        setBackground(Color.GRAY);
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
        /**
         * TODO
         */
    }

    /**
     * Draw obstacle
     * @param g
     */
    private void drawObstacle(final Graphics g) {
        g.setColor(Color.RED);

        for (final Point2D<Integer, Integer> p : controller.getObstacles()) {
            final int x = p.getX();
            final int y = p.getY();

            g.fillRect(x * CELL, y * CELL, CELL, CELL);
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
            case FOOD:
                g.setColor(Color.PINK);
                g.fillOval(x, y, CELL, CELL);
                break;

            case CLOCK:
                g.setColor(Color.BLUE);
                g.fillOval(x, y, CELL, CELL);
                break;

            case KEY:
                g.setColor(Color.ORANGE);
                g.fillOval(x, y, CELL, CELL);
                break;
        
            default:
                g.setColor(Color.YELLOW);
                g.fillOval(x, y, CELL, CELL);
                break;
        }
       }
    }
}
