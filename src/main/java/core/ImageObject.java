package core;

import java.awt.image.BufferedImage;

public class ImageObject {

    public static enum Command {
        DEFAULT,
        FADE_IN,
        FADE_OUT
    }

    private BufferedImage image;
    private Integer pos_x;
    private Integer pos_y;
    private String referenceKey;
    private Boolean isMovable;
    private Integer fadeDelay;
    private Float opacity;
    private Command command = Command.DEFAULT;

    public ImageObject(BufferedImage image, Integer pos_x, Integer pos_y, String referenceKey) {
        this(image, pos_x, pos_y, referenceKey, 1.0f);
    }

    public ImageObject(BufferedImage image, Integer pos_x, Integer pos_y, String referenceKey, Float opacity) {
        this(image, pos_x, pos_y, referenceKey, opacity, false);
    }

    public ImageObject(BufferedImage image, Integer pos_x, Integer pos_y, String referenceKey, Float opacity, Boolean isMovable) {
        this.image = image;
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.referenceKey = referenceKey;
        this.isMovable = isMovable;
        this.opacity = opacity;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public Integer getPos_x() {
        return pos_x;
    }

    public void setPos_x(Integer pos_x) {
        this.pos_x = pos_x;
    }

    public Integer getPos_y() {
        return pos_y;
    }

    public void setPos_y(Integer pos_y) {
        this.pos_y = pos_y;
    }

    public String getReferenceKey() {
        return referenceKey;
    }

    public void setReferenceKey(String referenceKey) {
        this.referenceKey = referenceKey;
    }

    public Boolean getMovable() {
        return isMovable;
    }

    public void setMovable(Boolean movable) {
        isMovable = movable;
    }

    public Integer getFadeDelay() {
        return fadeDelay;
    }

    public void setFadeDelay(Integer fadeDelay) {
        this.fadeDelay = fadeDelay;
    }

    public Float getOpacity() {
        return opacity;
    }

    public void setOpacity(Float opacity) {
        this.opacity = opacity;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}

