package snakerunner.controller;

import snakerunner.graphics.MainFrameImpl;
import snakerunner.graphics.MenuPanel;

public class MenuController implements Controller {

    private final MainFrameImpl mainFrame;
    private final MenuPanel menuPanel;

    public MenuController(MainFrameImpl mainFrame,MenuPanel menuPanel){
        this.mainFrame = mainFrame;
        this.menuPanel = menuPanel;
    }

    @Override
    public void init() {
        menuPanel.getStartButton().addActionListener(null);
        menuPanel.getTutorialButton().addActionListener(null);
        menuPanel.getExitButton().addActionListener(null);
    }

    @Override
    public void show() {
        mainFrame.setContentPane(menuPanel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    @Override
    public void hide() {
        menuPanel.setVisible(false);
    }

}
