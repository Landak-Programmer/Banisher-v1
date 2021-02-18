package screens;

import core.ImagePanel;
import helper.PropertiesHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class Gui extends JFrame implements ActionListener {

    protected ImagePanel imagePanel;
    private int frameWidth = 1000;
    private int frameHeight = 750;

    public Gui() {
        //don't mess up the order or it might initialize wrongly
        imagePanel = ImagePanel.getInstance();
        setup();
        init();
        addComponent();
        addActionListener();
        start();
    }

    public abstract void setup();

    protected void init() {
        //basically base jFrame
        setTitle(PropertiesHelper.getString("title"));
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(frameWidth, frameHeight);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public abstract void addComponent();

    public abstract void addActionListener();

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
}
