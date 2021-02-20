import helper.GlobalHolderHelper;
import helper.PropertiesHelper;
import screens.Gui;
import screens.GuiFactory;

public class Apps {

    public static void main(String[] args) {
        try {
            PropertiesHelper.init();
            new GlobalHolderHelper();
        } catch (Exception e) {
            System.out.println(String.format("Exception fail to start due to: %s", e.getLocalizedMessage()));
        } finally {
            final String guiName = "main";
            GuiFactory factory = new GuiFactory();
            Gui gui = factory.createGui(guiName);
        }
    }
}
