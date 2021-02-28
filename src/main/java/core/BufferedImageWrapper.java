package core;

import java.awt.image.BufferedImage;

public class BufferedImageWrapper {

    private BufferedImage bufferedImage;

    public BufferedImageWrapper(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public BufferedImage get() {
        return bufferedImage;
    }
}
