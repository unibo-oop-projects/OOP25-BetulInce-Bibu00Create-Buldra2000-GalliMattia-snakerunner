package snakerunner.graphics.panel;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import snakerunner.controller.Controller;
import snakerunner.graphics.hud.impl.LevelView;
import snakerunner.graphics.hud.impl.LifeView;
import snakerunner.graphics.hud.impl.ScoreView;
import snakerunner.graphics.hud.impl.TimerView;
import snakerunner.graphics.impl.BasePanelImpl;

public class GamePanel extends BasePanelImpl {

    private static final String PAUSE = "Pause";
    private static final String RESUME = "Resume";
    private static final String BACK = "Back to Menu";

    private final TimerView timerView;
    private final ScoreView scoreView;
    private final LevelView levelView;
    private final LifeView lifeView;

    private Controller controller;

    private final JPanel nPanel;
    private final JPanel sPanel;
    private final GameBoardPanel gameBoardPanel;
    private final JPanel ePanel;
    private final JPanel wPanel;
    private final JButton pause;
    private final JButton resume;
    private final JButton back;

    public GamePanel(Controller controller){
        super();
        this.controller = controller;
        nPanel = new JPanel();
        sPanel = new JPanel();
        gameBoardPanel = new GameBoardPanel();
        ePanel = new JPanel();
        wPanel = new JPanel();

        timerView = new TimerView();
        scoreView = new ScoreView();
        levelView = new LevelView();
        lifeView = new LifeView();

        setLayoutPanel();

        pause = createButton(PAUSE);
        resume = createButton(RESUME);
        back = createButton(BACK);

        nPanel.setOpaque(false);
        sPanel.setOpaque(false);
        ePanel.setOpaque(false);
        wPanel.setOpaque(false);

        add(nPanel, BorderLayout.NORTH);
        add(gameBoardPanel, BorderLayout.CENTER);
        add(ePanel, BorderLayout.EAST);
        add(wPanel, BorderLayout.WEST);
        add(sPanel, BorderLayout.SOUTH);

        nPanel.add(timerView);
        nPanel.add(levelView);
        ePanel.add(pause);
        ePanel.add(resume);
        wPanel.add(lifeView);
        
        sPanel.setLayout(new BoxLayout(sPanel, BoxLayout.X_AXIS));

        scoreView.setAlignmentX(Component.RIGHT_ALIGNMENT);
        back.setAlignmentX(Component.LEFT_ALIGNMENT);

        sPanel.add(scoreView);
        sPanel.add(back);

        this.addActionListeners();
    }

    @Override
    public void setLayoutPanel() {
        setLayout(new BorderLayout());
    }

    @Override
    public void addActionListeners(){
        System.out.println("GamePanel : Adding action listeners to GamePanel buttons");
        pause.addActionListener(e -> controller.onPause());
        resume.addActionListener(e -> controller.onResume());
        back.addActionListener(e -> controller.onBackToMenu());
    }

    //TimerView
    public void updateTimer(int timeLeft){
        timerView.setTimeLeft(timeLeft);
    }

    //LevelView
    public void updateLevel(int level){
        levelView.setLevel(level);
    }

    //ScoreView
    public void updateScore(int score){
        scoreView.setScore(score);
    }

    //LifeView
    public void updateLife(int life){
        lifeView.setLife(life);
    }
}