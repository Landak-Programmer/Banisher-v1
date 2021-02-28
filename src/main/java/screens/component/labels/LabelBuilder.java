package screens.component.labels;

import screens.component.FontBuilder;

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

    public void build(JLabel jLabel) {
        jLabel.setText(label);

        jLabel.setFont(font);
        jLabel.setForeground(color);

        if (horizontalAligment != null) {
            jLabel.setHorizontalAlignment(horizontalAligment);
        }
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
