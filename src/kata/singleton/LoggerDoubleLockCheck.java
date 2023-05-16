package kata.singleton;


// Resources: https://www.baeldung.com/java-singleton-double-checked-locking

// Made thread-safe by using the double-lock check algorithm
public class LoggerDoubleLockCheck {
    // Make constructor private, to prevent outside declaration
    private LoggerDoubleLockCheck() {

    }

    // static fields and blocks are initialized one after another (Synchronization!)
    // statics belong to EVERY instance of a class (Global class variable)
    // volatile keyword indicates a thread-safe access of this variable main in-memory (vs flash cache memory)
    private static volatile LoggerDoubleLockCheck INSTANCE;
    
    // Lock to be acquired First Come First Serve
    private static Object mutex = new Object();

    // Get Logger Instance/global class context
    public static LoggerDoubleLockCheck getInstance() {
    	LoggerDoubleLockCheck result = INSTANCE;
        if (result == null) {
        	// ALL threads to wait here until mutex is released by owning thread
            synchronized (mutex) {
                result = INSTANCE;
                if (result == null) {
                	INSTANCE = result = new LoggerDoubleLockCheck();
                }
            }
        }
        return result;
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
