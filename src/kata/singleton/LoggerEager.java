package kata.singleton;


// Resources: https://www.baeldung.com/java-singleton-double-checked-locking

// TODO Refactor the logging service so that there is only one instance throughout the application.
//      Make sure this operation is thread-safe by using the double-lock check algorithm
public class LoggerEager {
    // Make constructor private, to prevent outside declaration
    private LoggerEager() {

    }

    // Constant/Global logger INSTANCE to be shared
    // static fields and blocks are initialized one after another (Synchronization!)
    private static final LoggerEager INSTANCE = new LoggerEager();

    // Get Logger Instance/global class context
    public static LoggerEager getInstance() {
        return INSTANCE;
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }
    public void info(String message) {
        log(LogLevel.INFO, message);
    }
    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    public void log(LogLevel level, String message) {
        switch (level) {
            case INFO:
                System.out.println("[INFO] " + message);
                break;
            case DEBUG:
                System.out.println("[DEBUG] " + message);
                break;
            case ERROR:
                System.out.println("[ERROR] " + message);
                break;
            default:
                throw new IllegalArgumentException("Invalid log level: " + level);
        }
    }
}
