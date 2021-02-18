package screens.component;

import javax.swing.*;
import java.awt.*;

public class PanelBuilder {

    // hack
    private JPanel panel = new JPanel();
    private Color backgroundColor;

    public static PanelBuilder create() {
        return new PanelBuilder();
    }

    public JPanel build() {

        if (backgroundColor != null) {
            panel.setBackground(backgroundColor);
        }

        return panel;
    }

    public PanelBuilder setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public PanelBuilder add(Component component) {
        panel.add(component);
        return this;
    }
}
