package snakerunner.model;

import snakerunner.commons.Point2D;

/* Doors can be open when the user collects the key */
public class Door extends Obstacle {

    private boolean open; //Checking if the door is open

    public Door(final int x, final int y) {
        super(x, y, 1, 1); /*Default size is 1x1*/
        this.open = false; //At the beginning the door is closed

    }

    //Getter
    public boolean isOpen() {
        return open;
    }

    //Setter
    public void setOpen(final boolean open) {
        this.open = open;
    }

    //Getting door's positions
    public Point2D<Integer, Integer> getPosition() {
    return new Point2D<>(getX(), getY());
    }

}
