package screens;

import core.BufferedImageWrapper;
import core.ImageObject;
import helper.PropertiesHelper;
import screens.component.panels.GamePlayPanel;
import screens.component.panels.MenuOptionPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainGui extends Gui {

    private MenuOptionPanel menuOptionPanel;
    private GamePlayPanel gamePlayPanel;

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

        add(menuOptionPanel,
                new GridBagConstraints(0, 0, 100, 100,
                        1, 1, GridBagConstraints.WEST,
                        GridBagConstraints.NONE, new Insets(200, 250,
                        0, 0), 100, 100));
        addActiveComponent(menuOptionPanel);
        addImagePanelComponent();
    }

    private void injectGameComponent() {

        add(gamePlayPanel,
                new GridBagConstraints(0, 0, 100, 100,
                        1, 1, GridBagConstraints.WEST,
                        GridBagConstraints.NONE, new Insets(200, 250,
                        0, 0), 100, 100));
        addActiveComponent(gamePlayPanel);
        addImagePanelComponent();
    }

    @Override
    public void start() {
    }
}
