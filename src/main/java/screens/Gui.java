package screens;

import helper.PropertiesHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class Gui extends JFrame implements ActionListener {

    public Gui() {
        //don't mess up the order or it might initialize wrongly
        setup();
        init();
        addComponent();
        addActionListener();
    }

    public abstract void setup();

    private void init() {
        //basically base jFrame
        setTitle(PropertiesHelper.getString("title"));
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 750);
        setLocation(300, 40);
        setVisible(true);
    }

    public abstract void addComponent();

    public abstract void addActionListener();
}
