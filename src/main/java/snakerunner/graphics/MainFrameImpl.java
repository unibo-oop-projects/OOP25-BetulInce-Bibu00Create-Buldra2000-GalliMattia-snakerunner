package snakerunner.graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class MainFrameImpl extends JFrame implements MainFrame {
    
    private static final String TITLE = "Snake Runner";
    private static final double PROPORTION = 0.5;
    private final MenuPanel menuPanel = new MenuPanel();

    public MainFrameImpl(){
        super(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(menuPanel, BorderLayout.CENTER);
        setDimensionFrame();
    }

    @Override
    public void setDimensionFrame(){
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)(screensize.width * PROPORTION);
        int height = (int)(screensize.height * PROPORTION);
        setSize(width,height);
    }

    @Override
    public void display() {
        setLocationRelativeTo(null);
        setVisible(true);
    }
}