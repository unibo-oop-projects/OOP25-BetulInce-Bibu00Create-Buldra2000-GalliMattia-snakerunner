package snakerunner.graphics.hud;

import javax.swing.JLabel;

/**
 * Base Graphics for HUD element
 */
public abstract class BaseView extends JLabel implements BaseHUD {

    private static final long serialVersionUID = 1L;

    /**
     * 
     * @param width
     * @param height
     */
    public BaseView() {
        setOpaque(false);
    }
}
