package screens.component.panels;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelBuilder {

    private Color backgroundColor;

    public static PanelBuilder create() {
        return new PanelBuilder();
    }

    public void build(JPanel panel) {

        if (backgroundColor != null) {
            panel.setBackground(backgroundColor);
        }
    }

    public PanelBuilder setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }
}
