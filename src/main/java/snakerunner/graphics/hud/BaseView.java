package snakerunner.graphics.hud;

import java.awt.Dimension;

import javax.swing.JLabel;

public abstract class BaseView extends JLabel{

    public BaseView(int WIDTH, int HEIGHT){
        setOpaque(false);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    public abstract void setValue(int value);

}
