package screens.component.panels;

import screens.Routes;
import screens.component.buttons.HoverButton;
import screens.component.buttons.RouteButton;

import javax.swing.*;
import java.awt.*;

public class MenuOptionPanel extends JPanel {

    public MenuOptionPanel() {
        // dynamic plz
        super(new GridLayout(4, 1, 0, 40));
        JButton startButton = new HoverButton("Start Game", Routes.Route.GAME);
        JButton loadButton = new HoverButton("Load Game");
        JButton settingButton = new HoverButton("Setting");
        JButton quitButton = new HoverButton("Quit");
        PanelBuilder.create().setBackgroundColor(Color.GRAY).build(this);
        add(startButton);
        add(loadButton);
        add(settingButton);
        add(quitButton);

    }
}
