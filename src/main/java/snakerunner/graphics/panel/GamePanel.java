package snakerunner.graphics.panel;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import snakerunner.graphics.MainFrame;
import snakerunner.graphics.hud.LevelView;
import snakerunner.graphics.hud.LifeView;
import snakerunner.graphics.hud.ScoreView;
import snakerunner.graphics.hud.TimerView;
import snakerunner.graphics.impl.BasePanelImpl;

public class GamePanel extends BasePanelImpl {

    private static final String PAUSE = "Pause";
    private static final String RESUME = "Resume";
    private static final String BACK = "Back to Menu";

    private TimerView timerView;
    private ScoreView scoreView;
    private LevelView levelView;
    private LifeView lifeView;

    private MainFrame mainFrame;

    private final JPanel nPanel;
    private final JPanel sPanel;
    private final GameBoardPanel gameBoardPanel;
    private final JPanel ePanel;
    private final JPanel wPanel;
    private final JButton pause;
    private final JButton resume;
    private final JButton back;

    public GamePanel(MainFrame mainFrame){
        super();
        this.mainFrame = mainFrame;
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

    private JButton getPause() {
        return pause;
    }

    private JButton getResume() {
        return resume;
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
        getPause().addActionListener(e -> mainFrame.pause());
        getResume().addActionListener(e -> {});
        getBacktoMenu().addActionListener(e -> mainFrame.showMenu());
    }

    public void updateTimer(int timeLeft){
        timerView.setTimeLeft(timeLeft);
    }
}