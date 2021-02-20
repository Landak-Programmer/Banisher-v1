package helper;

import screens.Routes;

public class GlobalHolderHelper {

    private static Routes routes;

    public GlobalHolderHelper() {
    }

    public static Routes getRoutes() {
        return routes;
    }

    public static void setRoutes(Routes routes) {
        GlobalHolderHelper.routes = routes;
    }
}
