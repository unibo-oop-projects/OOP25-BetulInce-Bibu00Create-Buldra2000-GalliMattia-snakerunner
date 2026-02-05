package snakerunner.graphics.hud;

import java.awt.Dimension;

import javax.swing.JLabel;

//Base Graphics for HUD element
public abstract class BaseView extends JLabel implements BaseHUD{

    public BaseView(int WIDTH, int HEIGHT){
        setOpaque(false);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
}
