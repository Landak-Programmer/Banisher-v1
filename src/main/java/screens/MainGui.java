package screens;

import core.BufferedImageWrapper;
import core.ImageObject;
import helper.PropertiesHelper;
import screens.component.panels.MenuOptionPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainGui extends Gui {

    private MenuOptionPanel menuOptionPanel;

    public MainGui() {
        super();
    }

    @Override
    public void setup() {
        try {
            BufferedImageWrapper img = new BufferedImageWrapper(ImageIO.read(new File(PropertiesHelper.getString("apps.homepage.img.path"))));
            BufferedImage bg = img.get();
            imagePanel.addImage(img.get(), "homepage");
            super.setFrameWidth(bg.getWidth());
            super.setFrameHeight(bg.getHeight());
            menuOptionPanel = new MenuOptionPanel();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addComponent() {
        imagePanel.repaint();
        /*
            TODO: refactor
            NOTE:
            ipadx = width
            ipady = height

            Insets = Margin
         */
        add(menuOptionPanel,
                new GridBagConstraints(0, 0, 100, 100,
                        1, 1, GridBagConstraints.WEST,
                        GridBagConstraints.NONE, new Insets(200, 200,
                        0, 0), 200, 400));
        // must be last!
        add(imagePanel,
                new GridBagConstraints(0, 0, 100, 100,
                        1, 1, GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH, new Insets(0, 0,
                        0, 0), 0, 0));

    }

    @Override
    public void addActionListener() {

    }

    @Override
    public void start() {
        // do stuff
        boolean test = false;
        while (true) {
            if (!test) {
                test = true;
                // imagePanel.triggerFadeImageEvent("homepage", 15, ImageObject.Command.FADE_OUT);
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
