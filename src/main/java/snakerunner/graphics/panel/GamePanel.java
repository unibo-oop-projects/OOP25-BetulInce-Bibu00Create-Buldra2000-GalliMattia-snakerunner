package snakerunner.graphics.panel;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import snakerunner.controller.GameController;
import snakerunner.controller.WorldController;
import snakerunner.graphics.hud.BaseHUD;
import snakerunner.graphics.hud.LevelView;
import snakerunner.graphics.hud.LifeView;
import snakerunner.graphics.hud.ScoreView;
import snakerunner.graphics.hud.TimerView;
import snakerunner.graphics.impl.BasePanelImpl;

public final class GamePanel extends BasePanelImpl {

    private static final long serialVersionUID = 1L;
    private static final String PAUSE = "Pause";
    private static final String RESUME = "Resume";
    private final BaseHUD timerView;
    private final BaseHUD scoreView;
    private final BaseHUD levelView;
    private final BaseHUD lifeView;
    private final GameController controller;
    private final JPanel nPanel;
    private final JPanel sPanel;
    private GameBoardPanel gameBoardPanel;
    private final JPanel ePanel;
    private final JPanel wPanel;
    private final JButton pause;
    private final JButton resume;

    public GamePanel(final GameController controller) {
        super();
        this.controller = controller;
        nPanel = new JPanel();
        sPanel = new JPanel();
        ePanel = new JPanel();
        wPanel = new JPanel();
        timerView = new TimerView();
        scoreView = new ScoreView();
        levelView = new LevelView();
        lifeView = new LifeView();
        setLayoutPanel();
        pause = createButton(PAUSE);
        resume = createButton(RESUME);
        nPanel.setOpaque(false);
        sPanel.setOpaque(false);
        ePanel.setOpaque(false);
        wPanel.setOpaque(false);
        add(nPanel, BorderLayout.NORTH);
        add(ePanel, BorderLayout.EAST);
        add(wPanel, BorderLayout.WEST);
        add(sPanel, BorderLayout.SOUTH);
        nPanel.add((JLabel)timerView);
        ePanel.add(pause);
        ePanel.add(resume);
        wPanel.add((JLabel)lifeView);
        sPanel.add(Box.createVerticalGlue());
        nPanel.add((JLabel)levelView);
        nPanel.add((JLabel)scoreView);
        this.addActionListeners();
    }

    public void setWorldController(WorldController worldController) {
    
        if (gameBoardPanel == null) {
            gameBoardPanel = PanelFactory.createGameBoardPanel(worldController);
            add(gameBoardPanel, BorderLayout.CENTER);
        }
    
        revalidate();
        repaint();
    }

    @Override
    public void setLayoutPanel() {
        setLayout(new BorderLayout());
    }

    @Override
    public void addActionListeners() {
        pause.addActionListener(e -> controller.pause());
        resume.addActionListener(e -> controller.resume());
    }

    public void updateTimer(final int timeLeft) {
        //timerView.setValue(timeLeft);
        repaint();
    }

    public BaseHUD getTimerView() {
        return timerView;
    }

    public BaseHUD getScoreView() {
        return scoreView;
    }

    public BaseHUD getLevelView() {
        return levelView;
    }

    public BaseHUD getLifeView() {
        return lifeView;
    }
}