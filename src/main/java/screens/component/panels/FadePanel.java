package screens.component.panels;

import screens.component.Fadeable;

import javax.swing.*;
import java.awt.*;

public abstract class FadePanel extends JPanel {

    private Fadeable fadeable;

    public FadePanel() {
        super();
        fadeable = new Fadeable(this, this::fadebleSequence);
    }

    public FadePanel(LayoutManager layout) {
        this();
        super.setLayout(layout);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, fadeable.getOpacity()));
    }

    public void fade(int delay, String command) {
        fadeable.addArgs("delay", delay);
        fadeable.addArgs("command", command);
        fadeable.fade();
    }

    public Boolean isHidden() {
        return fadeable.isHidden();
    }

    public void setOpacity(float opacity) {
        this.fadeable.setOpacity(opacity);
    }

    protected abstract void fadebleSequence(Object object);

    public void loadPromiseObject(Object object) {
        fadeable.loadPromiseObject(object);
    }
}
