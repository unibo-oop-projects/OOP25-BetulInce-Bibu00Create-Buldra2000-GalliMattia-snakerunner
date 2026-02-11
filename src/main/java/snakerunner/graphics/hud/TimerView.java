package snakerunner.graphics.hud;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

/**
 * TimerView is a HUD component and is used to show the remaining game time in GamePanel.
 */
public final class TimerView extends AbstractBaseView {

    private static final long serialVersionUID = 1L;
    private static final int WIDTH = 150;
    private static final int HEIGHT = 30;
    private static final int TIME = 60;
    private static final String TIMER_TEXT = "%02d : %02d";
    private static final Integer TIMER_COUNTDOWN = 10;
    private static final int X = 20;
    private static final int Y = 15;

    private int timeLeft;

    /**
     * Constructor for TimerView.
     */
    public TimerView() {
        initBaseView();
        setOpaque(false);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    @Override
    public void setValue(final int value) {
        this.timeLeft = value;
        repaint();
    }

    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);

        final int min = timeLeft / TIME;
        final int sec = timeLeft % TIME;
        final String timerText = String.format(TIMER_TEXT, min, sec);

        if (timeLeft <= TIMER_COUNTDOWN && timeLeft > 0) {
            g.setColor(Color.RED);
        } else {
            g.setColor(Color.BLACK);
        }

        g.drawString("Timer : " + timerText, X, Y);
    }
}
