package snakerunner.graphics;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends BasePanel {

    private final JPanel nPanel;
    private final JPanel sPanel;
    private final JButton pause;
    private final JButton restart;
    private final JLabel timer;
    private final JLabel life;
    private final JLabel point;

    public GamePanel(){
        super();
        nPanel = new JPanel();
        sPanel = new JPanel();
        life = new JLabel("Lives remaining: 3");
        timer = new JLabel("0:00");
        pause = new JButton("Pause");
        restart = new JButton("Restart");
        point = new JLabel("Point : 0");

        styleButton(pause);
        styleButton(restart);

        nPanel.setOpaque(false);
        sPanel.setOpaque(false);

        setLayout(new BorderLayout());
        add(nPanel, BorderLayout.NORTH);
        add(sPanel, BorderLayout.SOUTH);

        nPanel.add(timer);
        nPanel.add(pause);
        nPanel.add(restart);
        sPanel.add(life);
        sPanel.add(point);

        getPause().addActionListener(e -> pauseButton());
        getRestart().addActionListener(e -> resumeButton());
    }

    public JButton getPause() {
        return pause;
    }

    public JButton getRestart() {
        return restart;
    }

    public void pauseButton(){
        System.out.println("Pause button pressed");
    }

    public void resumeButton(){
        System.out.println("Resume button pressed");
    }
}
