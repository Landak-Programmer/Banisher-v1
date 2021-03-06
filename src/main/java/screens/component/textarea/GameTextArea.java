package screens.component.textarea;

import screens.component.FontBuilder;

import java.awt.*;

public class GameTextArea extends FadeTextArea {

    public GameTextArea() {
        // fixme
        Font font = FontBuilder.create().setSize(30).build();
        setFont(font);
        setLineWrap(true);
        setWrapStyleWord(true);
        setOpaque(false);
        setEditable(false);
        setForeground(Color.WHITE);
    }

    @Override
    protected void fadebleSequence(Object object) {
        this.setText((String) object);
    }

    public void changeText(String text) {
        super.setText(text);
    }
}
