package snakerunner.graphics.impl;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import snakerunner.graphics.panel.BasePanel;

//Factory Pattern

//All panels, instead of extending JPanel, extend BasePanel
//In this way I define common characteristics for the panels
//Remember to add the background, fonts, and anything else they might have in common.
public abstract class BasePanelImpl extends JPanel implements BasePanel {

    private static final String TITLE = "Snake Runner";
    
    protected final Color defaultBackground = new Color(100,238,100);
    protected final Color brown = new Color(139, 69, 19);
    protected final Font arial = new Font("Arial", Font.BOLD, 32);
    protected final int f_height = 50;
    protected final int s_height = 150;

    public BasePanelImpl(){
        setBackground(defaultBackground);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createVerticalStrut(f_height));
        add(createTitle(TITLE));
        add(Box.createVerticalStrut(s_height));
    }

    //Create the title of the panels
    protected JLabel createTitle(String text){
        JLabel title = new JLabel(text);
        title.setFont(arial);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        return title;
    }

    protected JLabel createLabel(String text){
        JLabel label = new JLabel(text);
        return label;
    }

    //Rivedere questo metodo
    protected JButton createButton(String name){
        JButton button = new JButton(name);
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setBorderPainted(true);
        button.setContentAreaFilled(false);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        return button;
    }
}