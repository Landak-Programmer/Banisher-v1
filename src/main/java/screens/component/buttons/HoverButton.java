package screens.component.buttons;

import screens.Routes;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HoverButton extends RouteButton {

    private Color defaultBackgroundColour = Color.WHITE;

    public HoverButton(String label) {
        super(label);
        init();
    }

    public HoverButton(String label, Routes.Route route) {
        super(label, route);
        init();
    }

    public void init() {
        ButtonBuilder.create().build(this);
        super.addMouseListener(new HoverAdapter(this));
    }

    public HoverButton setMargin(int top, int left, int bottom, int right) {
        super.setMargin(new Insets(top, left, bottom, right));
        return this;
    }

    public HoverButton setBackgroundColour(Color color) {
        super.setBackground(color);
        defaultBackgroundColour = color;
        return this;
    }

    private static class HoverAdapter extends MouseAdapter {

        private HoverButton hoverButton;

        public HoverAdapter(HoverButton hoverButton) {
            this.hoverButton = hoverButton;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            super.mouseEntered(e);
            hoverButton.setBackground(Color.RED);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            super.mouseExited(e);
            hoverButton.setBackground(hoverButton.defaultBackgroundColour);
        }
    }
}
