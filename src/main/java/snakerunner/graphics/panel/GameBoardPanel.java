package snakerunner.graphics.panel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameBoardPanel extends JPanel {

    private static final int ROWS = 20;
    private static final int COLS = 20;

    private final JLabel label = new JLabel("Snake runner");

    public GameBoardPanel(){
        add(label, Color.WHITE);
        setBackground(Color.BLACK);
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        for (int y = 0; y < ROWS; y++){
            for (int x = 0; x < COLS; x++){
                g.setColor(new Color(19,18,18));
                g.fillRect(x * COLS, y * ROWS, y * ROWS, x * COLS);
            }
        }
    }
}
