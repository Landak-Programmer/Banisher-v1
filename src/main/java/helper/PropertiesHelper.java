package helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Singleton
 * overkill but for sake of example only :P
 */
public class PropertiesHelper {

    private static Properties properties = null;
    // overkill
    private static boolean pessimisticLock = false;

    public synchronized static void init() {

        if (properties != null || pessimisticLock) {
            return;
        }

        lock();
        properties = new Properties();
        try {
            load();
        } catch (IOException e) {
            e.printStackTrace();
            // will be handle by the client
            throw new RuntimeException(String.format("Failed to load application.properties due to %s", e.getLocalizedMessage()));
        }
        unlock();

    }

    private static void load() throws IOException {
        properties.load(new FileInputStream("src/main/resources/application.properties"));
    }


    private static void lock() {
        pessimisticLock = true;
    }

    private static void unlock() {
        pessimisticLock = false;
    }

    public static String getString(String key) {
        return properties.getProperty(key, String.format("No such key config as %s", key));
    }

    public static Integer getInteger(String key) {
        // checking
        return Integer.parseInt(properties.getProperty(key));
    }

}

