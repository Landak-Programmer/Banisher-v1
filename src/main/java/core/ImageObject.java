package core;

import java.awt.*;

public class ImageObject {

    private Image image;
    private Integer pos_x;
    private Integer pos_y;
    private String referenceKey;
    private Boolean isMovable;

    public ImageObject(Image image, Integer pos_x, Integer pos_y, String referenceKey) {
        this(image, pos_x, pos_y, referenceKey, false);
    }

    public ImageObject(Image image, Integer pos_x, Integer pos_y, String referenceKey, Boolean isMovable) {
        this.image = image;
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.referenceKey = referenceKey;
        this.isMovable = isMovable;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
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
}

