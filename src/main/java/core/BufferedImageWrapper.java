package core;

import java.awt.image.BufferedImage;

public class BufferedImageWrapper implements Component<BufferedImage> {

    private BufferedImage bufferedImage;

    public BufferedImageWrapper(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    @Override
    public BufferedImage get() {
        return bufferedImage;
    }
}
