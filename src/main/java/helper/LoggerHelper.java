package helper;

/**
 * TODO: support class logging
 */
public class LoggerHelper {


    public enum Log {
        DEBUG,
        INFO,
        ERROR
    }

    public static void log(Log log, String message) {
        System.out.println(String.format("%s:%s", log, message));
    }

    public static void log(Log log, String message, Exception e) {
        System.out.println(String.format("%s:%s\n%s", log, message, e));
    }

}
