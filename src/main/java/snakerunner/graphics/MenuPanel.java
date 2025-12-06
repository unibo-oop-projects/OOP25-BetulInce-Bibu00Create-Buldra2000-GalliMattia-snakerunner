package snakerunner.graphics;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class MenuPanel extends BasePanel {

    private static final String LABEL = " Welcome to Snake Runner";
    private static final String START = "Start";
    private static final String OPTION = "Option";
    private static final String EXIT = "Exit";

    private final JButton start;
    private final JButton option;
    private final JButton exit;

    public MenuPanel(){
        super();
        start = new JButton(START);
        option = new JButton(OPTION);
        exit = new JButton(EXIT);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        styleButton(start);
        styleButton(option);
        styleButton(exit);

        add(Box.createVerticalStrut(50));
        add(createTitle(LABEL));
        add(Box.createVerticalStrut(100));
        add(start);
        add(option);
        add(exit);
        add(Box.createVerticalGlue());
        
        getStartButton().addActionListener(e -> pressedStartbutton());
        getOptionButton().addActionListener(e -> pressedOptionbutton());
        getExitButton().addActionListener(e -> pressedExitbutton());
    }

    public JButton getStartButton() {
        return start;
    }

    public JButton getOptionButton() {
        return option;
    }

    public JButton getExitButton() {
        return exit;
    }

    public void pressedStartbutton(){
        System.out.println("Start button pressed");
    }

    public void pressedOptionbutton(){
        System.out.println("Option button pressed");
    }

    public void pressedExitbutton(){
        System.out.println("Exit button pressed");
        System.exit(0);
    }
}