package screens;

import core.ImageObject;
import screens.component.buttons.RouteButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Routes implements ActionListener {

    public enum Route {
        MAIN_MENU,
        GAME,
        LOADGAME,
        DEFAULT
    }

    private static Gui gui;

    public Routes(Gui gui) {
        Routes.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof RouteButton) {
            RouteButton source = (RouteButton) e.getSource();
            if (Route.GAME.equals(source.getRoute())) {
                goToGame();
            } else if (Route.MAIN_MENU.equals(source.getRoute())) {
                goToMainMenu();
            } else if (Route.LOADGAME.equals(source.getRoute())) {
                goToLoadGame();
            }
        }

    }

    private static void fadeCurrent() {
        gui.imagePanel.triggerFadeImageEvent(5, ImageObject.Command.FADE_OUT);
    }

    /**
     * Return action to go to game
     */
    public static void goToGame() {
        fadeCurrent();
        // render image - TODO: load based on save file
        // fixme: dont hardcode game - based on load file
        gui.imagePanel.triggerFadeImageEvent("school", 5, ImageObject.Command.FADE_IN, true);
        // fixme
        gui.imagePanel.triggerFadeImageEvent("textbox", 5, ImageObject.Command.FADE_IN, false);
        gui.addComponent(Route.GAME);
    }

    /**
     * Return action to go to main menu
     */
    public static void goToMainMenu() {
        fadeCurrent();
        gui.imagePanel.triggerFadeImageEvent("homepage", 5, ImageObject.Command.FADE_IN, true);
        gui.addComponent(Route.MAIN_MENU);
    }

    /**
     * Return action to go to main menu
     */
    public static void goToLoadGame() {
        fadeCurrent();
        gui.imagePanel.triggerFadeImageEvent("loadgame", 5, ImageObject.Command.FADE_IN, true);
        gui.addComponent(Route.LOADGAME);
    }
}
