package screens;

import core.BufferedImageWrapper;
import core.ImageObject;
import helper.PropertiesHelper;
import screens.component.GridBagBuilder;
import screens.component.panels.GamePlayPanel;
import screens.component.panels.GameTextPanel;
import screens.component.panels.MenuOptionPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainGui extends Gui {

    // ugly...
    private JPanel menuOptionPanel;
    private JPanel gamePlayPanel;
    private JPanel gameTextPanel;

    public MainGui() {
        super();
    }

    @Override
    public void setup() {
        try {
            // TODO : more to resources manager
            BufferedImageWrapper img = new BufferedImageWrapper(ImageIO.read(new File(PropertiesHelper.getString("apps.homepage.img.path"))));
            BufferedImage bg = img.get();
            imagePanel.addImage(img.get(), "homepage");
            super.setFrameWidth(bg.getWidth());
            super.setFrameHeight(bg.getHeight());
            menuOptionPanel = new MenuOptionPanel();
            gamePlayPanel = new GamePlayPanel();
            gameTextPanel = new GameTextPanel();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addComponent() {
        addComponent(Routes.Route.MAIN_MENU);
    }

    /*
        Ugly....
    */
    @Override
    public void addComponent(Routes.Route route) {
        removeActiveComponent();
        imagePanel.repaint();
        // TODO : ugly
        switch (route) {
            case MAIN_MENU:
                injectMainMenuComponent();
                break;
            case GAME:
                injectGameComponent();
                break;
        }
        repaint();
        revalidate();
    }

    private void injectMainMenuComponent() {

        add(menuOptionPanel, GridBagBuilder.create().build(
                GridBagConstraints.WEST, GridBagConstraints.NONE,
                0, 0, 100, 100,
                250, 0, 200, 0));

        // don't forgot
        addActiveComponent(menuOptionPanel);
        addImagePanelComponent();
    }

    private void injectGameComponent() {

        add(gamePlayPanel, GridBagBuilder.create().build(
                GridBagConstraints.WEST, GridBagConstraints.NONE, 1, 1,
                100, 100,
                250, 0, 200, 250));

        add(gameTextPanel, GridBagBuilder.create().build(
                GridBagConstraints.PAGE_START, GridBagConstraints.NONE,
                3, 1, getFrameWidth(), getFrameHeight(),
                0, 0, 600, 30)); // fixme: don't hardcode height/width padding

        // don't forgot
        addActiveComponent(gamePlayPanel);
        addActiveComponent(gameTextPanel);
        addImagePanelComponent();
    }

    @Override
    public void start() {
    }
}
