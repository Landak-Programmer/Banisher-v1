package screens.component.textarea;

import screens.component.Fadeable;

import javax.swing.*;
import java.awt.*;

public abstract class FadeTextArea extends JTextArea {

    private Fadeable fadeable;

    public FadeTextArea() {
        super();
        fadeable = new Fadeable(this, this::fadebleSequence);
    }

    public FadeTextArea(LayoutManager layout) {
        this();
        super.setLayout(layout);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, fadeable.getOpacity()));
        super.paintComponent(g);
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
