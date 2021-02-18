package screens;

import core.BufferedImageWrapper;
import core.ImageObject;
import helper.PropertiesHelper;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainGui extends Gui {

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

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addComponent() {
        imagePanel.repaint();
        add(imagePanel, BorderLayout.CENTER);
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
                imagePanel.triggerFadeImageEvent("homepage", 15, ImageObject.Command.FADE_OUT);
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
