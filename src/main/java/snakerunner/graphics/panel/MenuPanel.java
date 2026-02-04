package snakerunner.graphics.panel;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import snakerunner.controller.Controller;
import snakerunner.graphics.impl.BasePanelImpl;

public class MenuPanel extends BasePanelImpl {

    private static final String START = "Start";
    private static final String OPTION = "Option";
    private static final String EXIT = "Exit";

    private Controller controller;

    private final JButton start;
    private final JButton option;
    private final JButton exit;

    public MenuPanel(Controller controller){
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
        System.out.println("MenuPanel : Adding action listeners to MenuPanel buttons");
        start.addActionListener(e -> controller.start());
        option.addActionListener(e -> controller.onOption());
        exit.addActionListener(e -> {
                int n = JOptionPane.showConfirmDialog(
                    (JFrame) new JFrame(),
                    "Are you sure to quit?",
                    "Quit?",
                    JOptionPane.YES_NO_OPTION 
                );

                if( n == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
        });
    }
}