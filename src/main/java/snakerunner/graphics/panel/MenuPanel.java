package snakerunner.graphics.panel;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import snakerunner.controller.NavigationController;
import snakerunner.graphics.impl.BasePanelImpl;

public final class MenuPanel extends BasePanelImpl {

    private static final long serialVersionUID = 1L;
    private static final String START = "Start";
    private static final String OPTION = "Option";
    private static final String EXIT = "Exit";
    private final NavigationController navigationController;
    private final JButton start;
    private final JButton option;
    private final JButton exit;

    public MenuPanel(final NavigationController navigationController) {
        super();
        this.navigationController = navigationController;
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
            navigationController.startGame();
        });
        option.addActionListener(e -> navigationController.onOption());
        exit.addActionListener(e -> navigationController.exit());
    }
}