package snakerunner.graphics;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

//All panels, instead of extending JPanel, extend BasePanel
//In this way I define common characteristics for the panels
//Remember to add the background, fonts, and anything else they might have in common.
public abstract class BasePanel extends JPanel {
    
    protected final Color defaultBackground = new Color(100,238,100);
    protected final Color brown = new Color(139, 69, 19);
    protected final Font arial = new Font("Arial", Font.BOLD, 32);

    public BasePanel(){
        super();
        setBackground(defaultBackground);
    }

    //Add Listener to button
    protected abstract void addActionListeners();

    //Create the title of the panels
    protected JLabel createTitle(String text){
        JLabel title = new JLabel(text);
        title.setFont(arial);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        return title;
    }

    protected JButton styleButton(JButton button){
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setBorderPainted(true);
        button.setContentAreaFilled(false);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        return button;
    }
}
