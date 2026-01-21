package snakerunner.graphics.hud;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/*TimerView is a HUD component and is used to show the remaining game time*/
public class TimerView extends JPanel {
    
    private int timeLeft;

    public TimerView(){
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(60, 30));
    }

    public void setTimeLeft(int timeLeft){
        this.timeLeft = timeLeft;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        int min = timeLeft / 60;
        int sec = timeLeft % 60;

        String timerText = String.format("%02d : %02d", min, sec);

        g.setColor(Color.BLACK);
        g.drawString(timerText, 10, 15);
    }


}
