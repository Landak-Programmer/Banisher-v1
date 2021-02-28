package screens.component.labels;

import screens.component.FontBuilder;

import java.awt.*;

public class GameTextLabel extends FadeLabel {

    public GameTextLabel() {
        // fixme
        Font font = FontBuilder.create().setSize(55).build();
        LabelBuilder.create().setFont(font).setColor(Color.WHITE).build(this);
    }

    @Override
    protected void fadebleSequence(Object object) {
        this.setText((String) object);
    }

    public void changeText(String text) {
        super.setText(text);
    }

}
