package screens.component.buttons;

import helper.GlobalHolderHelper;
import screens.Routes;

import javax.swing.*;

public class RouteButton extends JButton {

    private Routes.Route route;

    public RouteButton(String label) {
        this(label, Routes.Route.DEFAULT);
    }

    public RouteButton(String label, Routes.Route route) {
        super(label);
        this.route = route;
        set();
    }

    public void set() {
        super.addActionListener(GlobalHolderHelper.getRoutes());
    }

    public Routes.Route getRoute() {
        return route;
    }
}
