package snakerunner.graphics.hud;

import java.awt.Dimension;

import javax.swing.JLabel;

public abstract class BaseView extends JLabel{

    private static final long serialVersionUID = 1L;

    public BaseView(final int width, final int height){
        init(width,height);
    }

    private void init(final int width, final int height){
        setOpaque(false);
        setPreferredSize(new Dimension(width, height));
    }

    public abstract void setValue(int value);

}
