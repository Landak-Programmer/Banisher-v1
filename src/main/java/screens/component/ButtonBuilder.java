package screens.component;

import javax.swing.*;
import java.awt.*;

public class ButtonBuilder {

    private String text;
    private Color backgroundColor = Color.WHITE;
    private Color foregroundColor = Color.BLACK;
    private Font font = FontBuilder.create().build();

    public static ButtonBuilder create() {
        return new ButtonBuilder();
    }

    public JButton build() {

        JButton button = new JButton();

        if (text != null) {
            button.setText(text);
        }

        button.setBackground(backgroundColor);
        button.setFont(font);
        button.setForeground(foregroundColor);

        return button;
    }

    public ButtonBuilder setText(String text) {
        this.text = text;
        return this;
    }

    public ButtonBuilder setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public ButtonBuilder setForegroundColor(Color foregroundColor) {
        this.foregroundColor = foregroundColor;
        return this;
    }

    public ButtonBuilder setFont(Font font) {
        this.font = font;
        return this;
    }
}
