package snakerunner.graphics.panel;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import snakerunner.audio.AudioPlayer;
import snakerunner.graphics.MainFrame;
import snakerunner.graphics.impl.BasePanelImpl;

public class OptionPanel extends BasePanelImpl {

    private static final String APPLY = "Apply";
    private static final String BACK = "Back";
    private static final String SOUND = "Sound On / Off";

    private MainFrame mainFrame;

    private final JButton apply;
    private final JButton back;
    private final JCheckBox checkbox;
    private final JLabel label;

    public OptionPanel(MainFrame mainFrame){
        super();
        this.mainFrame = mainFrame;
        checkbox = new JCheckBox();
        label = new JLabel(SOUND);

        setLayoutPanel();
        
        checkbox.setAlignmentX(Component.CENTER_ALIGNMENT);

        setSoundPanel();
        add(Box.createVerticalGlue());
        apply = createButton(APPLY);
        back = createButton(BACK);

        add(apply);
        add(back);

        this.addActionListeners();
    }

    private JPanel setSoundPanel(){
        JPanel soundPanel = new JPanel();
        soundPanel.setLayout(new BoxLayout(soundPanel, BoxLayout.X_AXIS));
        soundPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        soundPanel.setOpaque(false);
        soundPanel.add(label);
        soundPanel.add(checkbox);
        add(soundPanel);
        return soundPanel;
    }

    private JButton getApply() {
        return apply;
    }

    private JButton getBack() {
        return back;
    }

    private JCheckBox getCheckbox() {
        return checkbox;
    }

    @Override
    public void setLayoutPanel(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    @Override
    public void addActionListeners(){
        System.out.println("OptionPanel : Adding action listeners to OptionPanel buttons");
        getApply().addActionListener(e -> mainFrame.showMenu());
        getBack().addActionListener(e -> mainFrame.showMenu());
        getCheckbox().addActionListener(e -> {
            boolean enable = getCheckbox().isSelected();
            AudioPlayer.setSoundEnabled(enable);
            System.out.println("AudioPlayer setSoundEnabled():" + enable);
        });
    }
}