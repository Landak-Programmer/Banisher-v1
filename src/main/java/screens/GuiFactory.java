package screens;

public class GuiFactory {

    public Gui createGui(String name) {
        if ("main".equalsIgnoreCase(name)) {
            return new MainGui();
        }
        throw new IllegalArgumentException("Gui not exist! Name:" + name);
    }
}
