package screens.component.panels;

import screens.Routes;
import screens.component.buttons.HoverButton;

import javax.swing.*;
import java.awt.*;

public class GamePlayPanel extends JPanel {

    public GamePlayPanel() {
        super(new GridLayout(1, 1, 0, 0));
        JButton mainMenu = new HoverButton("Main Menu", Routes.Route.MAIN_MENU).setBackgroundColour(Color.GREEN);
        PanelBuilder.create().setBackgroundColor(Color.GRAY).build(this);
        add(mainMenu);
    }
}
