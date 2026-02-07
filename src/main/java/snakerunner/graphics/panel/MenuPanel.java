package snakerunner.graphics.panel;

import javax.swing.BoxLayout;
import javax.swing.JButton;

import snakerunner.controller.Controller;
import snakerunner.graphics.impl.BasePanelImpl;

public class MenuPanel extends BasePanelImpl {

    private static final String START = "Start";
    private static final String OPTION = "Option";
    private static final String EXIT = "Exit";
    private final Controller controller;
    private final JButton start;
    private final JButton option;
    private final JButton exit;

    public MenuPanel(final Controller controller) {
        super();
        this.controller = controller;
        setLayoutPanel();
        start = createButton(START);
        option = createButton(OPTION);
        exit = createButton(EXIT);
        add(start);
        add(option);
        add(exit);
        this.addActionListeners();
    }

    @Override
    public void setLayoutPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    @Override
    public void addActionListeners() {
        start.addActionListener(e -> {
            controller.loadLevelFromFile("levels/level1.txt");
            controller.start();
        });
        option.addActionListener(e -> controller.onOption());
        exit.addActionListener(e -> controller.exit());
    }
}