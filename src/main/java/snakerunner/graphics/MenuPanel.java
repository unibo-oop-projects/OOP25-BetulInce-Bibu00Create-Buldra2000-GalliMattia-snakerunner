package snakerunner.graphics;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class MenuPanel extends BasePanel {

    private static final String LABEL = " Welcome to Snake Runner";
    private static final String START = "Start";
    private static final String TUTORIAL = "Tutorial";
    private static final String EXIT = "Exit";

    private final JButton start;
    private final JButton tutorial;
    private final JButton exit;

    public MenuPanel(){
        super();
        start = new JButton(START);
        tutorial = new JButton(TUTORIAL);
        exit = new JButton(EXIT);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        styleButton(start);
        styleButton(tutorial);
        styleButton(exit);

        add(Box.createVerticalStrut(50));
        add(createTitle(LABEL));
        add(Box.createVerticalStrut(100));
        add(start);
        add(tutorial);
        add(exit);
        add(Box.createVerticalGlue());
        
        addActionListeners();
    }

    public JButton getStartButton() {
        return start;
    }

    public JButton getTutorialButton() {
        return tutorial;
    }

    public JButton getExitButton() {
        return exit;
    }

    public void pressedStartbutton(){
        System.out.println("Start button pressed");
    }

    public void pressedTutorialbutton(){
        System.out.println("Tutorial button pressed");
    }

    public void pressedExitbutton(){
        System.out.println("Exit button pressed");
        System.exit(0);
    }

    protected void addActionListeners(){
        getStartButton().addActionListener(e -> pressedStartbutton());
        getTutorialButton().addActionListener(e -> pressedTutorialbutton());
        getExitButton().addActionListener(e -> pressedExitbutton());
    }
}