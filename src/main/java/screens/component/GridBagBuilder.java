package screens.component;

import java.awt.*;

public class GridBagBuilder {

    public static GridBagBuilder create() {
        return new GridBagBuilder();
    }

    /**
     * NOTE:
     * ipadx = width
     * ipady = height
     * <p>
     * Insets = Margin
     *
     * @return
     */
    public GridBagConstraints build(Integer anchor, Integer fill, int width, int height, int paddingHorizontal, int paddingVeritcal, int marginLeft, int marginRight, int marginTop, int marginBottom) {
        return new GridBagConstraints(0, 0, width, height,
                1, 1, anchor,
                fill, new Insets(marginTop, marginLeft,
                marginBottom, marginRight), paddingHorizontal, paddingVeritcal);
    }
}
