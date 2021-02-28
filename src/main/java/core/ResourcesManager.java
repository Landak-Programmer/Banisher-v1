package core;

import helper.PropertiesHelper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ResourcesManager {

    private static ResourcesManager resourcesManager = null;

    // sounds not good to me...
    // should clean up
    /*    private static HashMap<String, BufferedImage> ingameMemoryCache = new HashMap<>();*/

    public ResourcesManager() {
    }

    public static void init() {
        if (resourcesManager == null) {
            resourcesManager = new ResourcesManager();
        }
        injectIngameResouces();
    }

    private static void injectIngameResouces() {
/*        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(PropertiesHelper.getString("apps.textbox.img.path")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ingameMemoryCache.put("textbox", img);*/
    }

/*    public static BufferedImage get(String key) {
        return ingameMemoryCache.get(key);
    }*/

    /**
     * Todo: inject whatever needed only, not all
     */
    public static void injectImagePanelResources(ImagePanel imagePanel) {
        BufferedImage img = null;
        try {
            // TODO: dedicated resources properties
            // fixme: not explicitly tell which one should render first
            img = ImageIO.read(new File(PropertiesHelper.getString("apps.homepage.img.path")));
            imagePanel.addImage(img, "homepage");
            img = ImageIO.read(new File(PropertiesHelper.getString("apps.school.img.path")));
            imagePanel.addImage(img, "school", true);
            img = ImageIO.read(new File(PropertiesHelper.getString("apps.textbox.img.path")));
            imagePanel.addImage(img, -50, 150, "textbox", 0.00f);

            // --- Default ---
            img = ImageIO.read(new File(PropertiesHelper.getString("apps.default.img.path")));
            imagePanel.addImage(img, "default", true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
