package snakerunner.graphics.hud;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/*TimerView is a HUD component and is used to show the remaining game time in GamePanel*/
public class TimerView extends JPanel {
    
    private static final int WIDTH = 60;
    private static final int HEIGHT = 30;
    private static final int TIME = 60;
    private static final String TIMER_TEXT = "%02d : %02d";
    private static final int X = 10;
    private static final int Y = 15;

    private int timeLeft;

    public TimerView(){
        setOpaque(false);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    public void setTimeLeft(int timeLeft){
        this.timeLeft = timeLeft;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        int min = timeLeft / TIME;
        int sec = timeLeft % TIME;

        String timerText = String.format(TIMER_TEXT, min, sec);

        g.setColor(Color.BLACK);
        g.drawString(timerText, X, Y);
    }


}
