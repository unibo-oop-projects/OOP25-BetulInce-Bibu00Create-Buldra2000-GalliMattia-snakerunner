package snakerunner.graphics;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends BasePanel {

    private final JPanel nPanel;
    private final JPanel sPanel;
    private final GameBoardPanel gameBoardPanel;
    private final JPanel ePanel;
    private final JPanel wPanel;
    private final JButton pause;
    private final JButton restart;
    private final JLabel timer;
    private final JLabel life;
    private final JLabel score;

    public GamePanel(){
        super();
        nPanel = new JPanel();
        sPanel = new JPanel();
        gameBoardPanel = new GameBoardPanel();
        ePanel = new JPanel();
        wPanel = new JPanel();
        life = new JLabel("Lives remaining: 3");
        timer = new JLabel("0:00");
        pause = new JButton("Pause");
        restart = new JButton("Restart");
        score = new JLabel("Score : 0");

        styleButton(pause);
        styleButton(restart);

        nPanel.setOpaque(false);
        sPanel.setOpaque(false);
        ePanel.setOpaque(false);
        wPanel.setOpaque(false);

        setLayout(new BorderLayout());
        add(nPanel, BorderLayout.NORTH);
        add(sPanel, BorderLayout.SOUTH);
        add(gameBoardPanel, BorderLayout.CENTER);
        add(ePanel, BorderLayout.EAST);
        add(wPanel, BorderLayout.WEST);

        nPanel.add(timer);
        ePanel.add(pause);
        ePanel.add(restart);
        wPanel.add(life);
        sPanel.add(score);

        addActionListeners();
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
        System.out.println("Restart button pressed");
    }

    protected void addActionListeners(){
        getPause().addActionListener(e -> pauseButton());
        getRestart().addActionListener(e -> resumeButton());
    }
}