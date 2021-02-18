package screens.component;

import javax.swing.*;
import java.awt.*;

public class LabelBuilder {

    private String label;
    private Font font = FontBuilder.create().build();
    private Color color = Color.BLACK;
    private Integer horizontalAligment = null;

    public static LabelBuilder create() {
        return new LabelBuilder();
    }

    public JLabel build() {
        JLabel labelObject = new JLabel(label);

        labelObject.setFont(font);
        labelObject.setForeground(color);

        if (horizontalAligment != null) {
            labelObject.setHorizontalAlignment(horizontalAligment);
        }

        return labelObject;
    }

    public LabelBuilder setLabel(String label) {
        this.label = label;
        return this;
    }

    public LabelBuilder setFont(Font font) {
        this.font = font;
        return this;
    }

    public LabelBuilder setColor(Color color) {
        this.color = color;
        return this;
    }

    public LabelBuilder setHorizontalAligment(Integer horizontalAligment) {
        this.horizontalAligment = horizontalAligment;
        return this;
    }
}
