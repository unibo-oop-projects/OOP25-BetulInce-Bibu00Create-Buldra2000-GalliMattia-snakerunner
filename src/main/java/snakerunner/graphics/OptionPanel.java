package snakerunner.graphics;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OptionPanel extends BasePanel {

    private static final String APPLY = "Apply";
    private static final String BACK = "Back";
    private static final String OPTION = "Option";
    private static final String SOUND = "Sound On / Off";

    private final JPanel soundPanel;
    private final JButton apply;
    private final JButton back;
    private final JCheckBox checkbox;
    private final JLabel label;

    public OptionPanel(){
        super();
        soundPanel = new JPanel();
        apply = new JButton(APPLY);
        back = new JButton(BACK);
        checkbox = new JCheckBox();
        label = new JLabel(SOUND);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        styleButton(apply);
        styleButton(back);
        
        soundPanel.setLayout(new BoxLayout(soundPanel, BoxLayout.X_AXIS));
        soundPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        soundPanel.setOpaque(false);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        checkbox.setAlignmentX(Component.CENTER_ALIGNMENT);

        soundPanel.add(label);
        soundPanel.add(checkbox);

        add(Box.createVerticalStrut(50));
        add(createTitle(OPTION));
        add(Box.createVerticalStrut(100));
        add(soundPanel);
        add(Box.createVerticalGlue());
        add(apply);
        add(back);

        getApply().addActionListener(e -> applyButton());
        getBack().addActionListener(e -> backButton());
    }

    public JButton getApply() {
        return apply;
    }

    public JButton getBack() {
        return back;
    }

    public JCheckBox getCheckbox() {
        return checkbox;
    }

    public void applyButton(){
        System.out.println("Apply button pressed");
    }

    public void backButton(){
        System.out.println("Back button pressed");
    }
}