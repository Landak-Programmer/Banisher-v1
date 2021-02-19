package screens.component.panels;

import screens.component.buttons.MenuButton;

import javax.swing.*;
import java.awt.*;

public class MenuOptionPanel extends JPanel {

    public MenuOptionPanel() {
        // super(new BorderLayout());
        JButton startButton = new MenuButton("Start Game");
        PanelBuilder.create().setBackgroundColor(Color.GRAY).build(this);
        add(startButton);

    }
}
