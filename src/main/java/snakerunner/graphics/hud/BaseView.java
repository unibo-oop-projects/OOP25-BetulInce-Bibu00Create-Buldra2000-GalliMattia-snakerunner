package snakerunner.graphics.hud;

import java.awt.Dimension;

import javax.swing.JLabel;

/**
 * Base Graphics for HUD element
 */
public abstract class BaseView extends JLabel implements BaseHUD {

    /**
     * 
     * @param WIDTH
     * @param HEIGHT
     */
    public BaseView(final int WIDTH, final int HEIGHT) {
        setOpaque(false);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
}
