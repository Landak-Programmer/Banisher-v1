package screens;

import core.ImagePanel;
import helper.GlobalHolderHelper;
import helper.PropertiesHelper;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Gui extends JFrame {

    // hack
    private ArrayList<Component> activeComponent = new ArrayList<>();

    protected ImagePanel imagePanel;
    private int frameWidth = 1000;
    private int frameHeight = 750;

    public Gui() {
        //don't mess up the order or it might initialize wrongly
        imagePanel = ImagePanel.getInstance();
        GlobalHolderHelper.setRoutes(new Routes(this));
        setup();
        init();
        addComponent();
        start();
    }

    public abstract void setup();

    protected void init() {
        //basically base jFrame
        setTitle(PropertiesHelper.getString("title"));
        setLayout(new GridBagLayout());
        setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(frameWidth, frameHeight);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public abstract void addComponent();

    public abstract void addComponent(Routes.Route route);

    // FIXME: temp for testing
    public abstract void start();

    public int getFrameWidth() {
        return frameWidth;
    }

    public void setFrameWidth(int frameWidth) {
        this.frameWidth = frameWidth;
    }

    public int getFrameHeight() {
        return frameHeight;
    }

    public void setFrameHeight(int frameHeight) {
        this.frameHeight = frameHeight;
    }

    protected void removeActiveComponent() {
        for (Component component : activeComponent) {
            remove(component);
        }
    }

    protected void addActiveComponent(Component component) {
        activeComponent.add(component);
    }

    protected void addImagePanelComponent() {
        add(imagePanel,
                new GridBagConstraints(0, 0, 100, 100,
                        1, 1, GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH, new Insets(0, 0,
                        0, 0), 0, 0));
        activeComponent.add(imagePanel);
    }
}
