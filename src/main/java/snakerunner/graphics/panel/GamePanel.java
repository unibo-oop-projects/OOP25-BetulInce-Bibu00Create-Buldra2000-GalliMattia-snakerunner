package snakerunner.graphics.panel;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import snakerunner.controller.GameController;
import snakerunner.controller.WorldController;
import snakerunner.graphics.hud.BaseHUD;
import snakerunner.graphics.hud.HUDFactory;
import snakerunner.graphics.impl.AbstractBasePanel;

/**
 * GamePanel define the GameView when the user click "start".
 */
public final class GamePanel extends AbstractBasePanel {

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

    /**
     * GamePanel Constructor.
     * 
     * @param controller GameController.
     */
    public GamePanel(final GameController controller) {
        super();
        initPanel();
        this.controller = controller;
        nPanel = new JPanel();
        sPanel = new JPanel();
        ePanel = new JPanel();
        wPanel = new JPanel();
        timerView = HUDFactory.createTimerView();
        scoreView = HUDFactory.createScoreView();
        levelView = HUDFactory.createLevelView();
        lifeView = HUDFactory.createLifeView();
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
        nPanel.add((JLabel) timerView);
        nPanel.add(Box.createHorizontalStrut(20));
        ePanel.add(pause);
        ePanel.add(resume);
        wPanel.add((JLabel) lifeView);
        nPanel.add((JLabel) levelView);
        nPanel.add(Box.createHorizontalStrut(25));
        nPanel.add((JLabel) scoreView);
        this.addActionListeners();
    }

    /**
     * Sets the worldController and initialize the gameBoardPanel.
     * 
     * @param worldController the worldController for game state.
     */
    public void setWorldController(final WorldController worldController) {

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

    /**
     * Getter for TimerView.
     * 
     * @return TimerView.
     */
    public BaseHUD getTimerView() {
        return timerView;
    }

    /**
     * Getter for ScoreView.
     * 
     * @return ScoreView.
     */
    public BaseHUD getScoreView() {
        return scoreView;
    }

    /**
     * Getter for LevelView.
     * 
     * @return LevelView.
     */
    public BaseHUD getLevelView() {
        return levelView;
    }

    /**
     * Getter for LifeView.
     * 
     * @return LifeView.
     */
    public BaseHUD getLifeView() {
        return lifeView;
    }
}
