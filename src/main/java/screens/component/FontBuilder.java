package screens.component;

import java.awt.*;

public class FontBuilder {

    private String font = "ARIAL";
    private Integer size = 12;
    private Integer style = Font.PLAIN;

    public static FontBuilder create() {
        return new FontBuilder();
    }

    public Font build() {
        return new Font(font, style, size);
    }

    public FontBuilder setFont(String font) {
        this.font = font;
        return this;
    }

    public FontBuilder setSize(Integer size) {
        this.size = size;
        return this;
    }

    public FontBuilder setStyle(Integer style) {
        this.style = style;
        return this;
    }
}
