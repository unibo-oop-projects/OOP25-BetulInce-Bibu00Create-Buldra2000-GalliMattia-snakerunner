package snakerunner.graphics.panel;

import javax.swing.BoxLayout;
import javax.swing.JButton;

import snakerunner.graphics.MainFrame;
import snakerunner.graphics.impl.BasePanelImpl;

public class MenuPanel extends BasePanelImpl {

    private static final String START = "Start";
    private static final String OPTION = "Option";
    private static final String EXIT = "Exit";

    private MainFrame mainFrame;

    private final JButton start;
    private final JButton option;
    private final JButton exit;

    public MenuPanel(MainFrame mainFrame){
        super();
        this.mainFrame = mainFrame;

        setLayoutPanel();

        start = createButton(START);
        option = createButton(OPTION);
        exit = createButton(EXIT);

        add(start);
        add(option);
        add(exit);

        this.addActionListeners();
    }

    private JButton getStartButton() {
        return start;
    }

    private JButton getOptionButton() {
        return option;
    }

    private JButton getExitButton() {
        return exit;
    }

    @Override
    public void setLayoutPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    @Override
    public void addActionListeners() {
        System.out.println("MenuPanel : Adding action listeners to MenuPanel buttons");
        getStartButton().addActionListener(e -> mainFrame.showGame());
        getOptionButton().addActionListener(e -> mainFrame.showOption());
        getExitButton().addActionListener(e -> System.exit(0));
    }
}