package screens;

import core.ImageObject;
import core.ResourcesManager;
import screens.component.GridBagBuilder;
import screens.component.panels.GamePlayPanel;
import screens.component.panels.GameTextPanel;
import screens.component.panels.MenuOptionPanel;

import javax.swing.*;
import java.awt.*;

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
        ResourcesManager.injectImagePanelResources(imagePanel);
        // move!
        ImageObject imageObject = imagePanel.find("homepage");
        super.setFrameWidth(imageObject.getImage().getWidth());
        super.setFrameHeight(imageObject.getImage().getHeight());
        menuOptionPanel = new MenuOptionPanel();
        gamePlayPanel = new GamePlayPanel();
        gameTextPanel = new GameTextPanel();
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

        /*add(gamePlayPanel, GridBagBuilder.create().build(
                GridBagConstraints.WEST, GridBagConstraints.NONE, 1, 1,
                100, 100,
                250, 0, 200, 250));*/

        add(gameTextPanel, GridBagBuilder.create().build(
                GridBagConstraints.PAGE_START, GridBagConstraints.NONE,
                3, 1, getFrameWidth(), getFrameHeight(),
                210, 150, 547, 30)); // fixme: don't hardcode height/width padding

        // don't forgot
        addActiveComponent(gamePlayPanel);
        addActiveComponent(gameTextPanel);
        addImagePanelComponent();
    }

    @Override
    public void start() {
    }
}
