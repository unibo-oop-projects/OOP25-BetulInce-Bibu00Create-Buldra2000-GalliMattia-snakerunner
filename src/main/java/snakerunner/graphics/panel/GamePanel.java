package snakerunner.graphics.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import snakerunner.graphics.MainFrame;
import snakerunner.graphics.hud.TimerView;
import snakerunner.graphics.impl.BasePanelImpl;

public class GamePanel extends BasePanelImpl {

    private static final String PAUSE = "Pause";
    private static final String RESTART = "Restart";
    private static final String BACK = "Back to Menu";

    private TimerView timerView;
    private MainFrame mainFrame;

    private final JPanel nPanel;
    private final JPanel sPanel;
    private final GameBoardPanel gameBoardPanel;
    private final JPanel ePanel;
    private final JPanel wPanel;
    private final JButton pause;
    private final JButton restart;
    private final JButton back;
    private final JLabel life;
    private final JLabel score;
    private final JLabel level;

    public GamePanel(MainFrame mainFrame){
        super();
        this.mainFrame = mainFrame;
        nPanel = new JPanel();
        sPanel = new JPanel();
        gameBoardPanel = new GameBoardPanel();
        ePanel = new JPanel();
        wPanel = new JPanel();

        timerView = new TimerView();

        life = createLabel("Lives remaining: 3");
        level = createLabel("Level 1");
        score = createLabel("Score : 0");

        setLayoutPanel();

        pause = createButton(PAUSE);
        restart = createButton(RESTART);
        back = createButton(BACK);

        nPanel.setOpaque(false);
        sPanel.setOpaque(false);
        ePanel.setOpaque(false);
        wPanel.setOpaque(false);

        add(nPanel, BorderLayout.NORTH);
        add(sPanel, BorderLayout.SOUTH);
        add(gameBoardPanel, BorderLayout.CENTER);
        add(ePanel, BorderLayout.EAST);
        add(wPanel, BorderLayout.WEST);

        nPanel.add(timerView);
        nPanel.add(level);
        ePanel.add(pause);
        ePanel.add(restart);
        wPanel.add(life);
        sPanel.add(score);
        sPanel.add(back);

        this.addActionListeners();
    }

    private JButton getPause() {
        return pause;
    }

    private JButton getRestart() {
        return restart;
    }

    private JButton getBacktoMenu(){
        return back;
    }

    @Override
    public void setLayoutPanel() {
        setLayout(new BorderLayout());
    }

    @Override
    public void addActionListeners(){
        System.out.println("GamePanel : Adding action listeners to GamePanel buttons");
        getPause().addActionListener(e -> {});
        getRestart().addActionListener(e -> {});
        getBacktoMenu().addActionListener(e -> mainFrame.showMenu());
    }

    public void updateTimer(int timeLeft){
        timerView.setTimeLeft(timeLeft);
    }
}