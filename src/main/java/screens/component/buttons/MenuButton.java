package screens.component.buttons;

import javax.swing.*;
import java.awt.*;

public class MenuButton extends JButton {

    public MenuButton(String name) {
        super(name);
        ButtonBuilder.create().build(this);
    }
}
