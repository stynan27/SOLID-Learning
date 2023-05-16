package kata.singleton;

public class DraconianSingletonLogger {
	 // Make constructor private, to prevent outside declaration
    private DraconianSingletonLogger() {

    }

    // static fields and blocks are initialized one after another (Synchronization!)
    // statics belong to EVERY instance of a class (Global class variable)
    // Initialized to null
    private static DraconianSingletonLogger INSTANCE;

    // Get Logger Instance/global class context
    public static DraconianSingletonLogger getInstance() {
        if (INSTANCE == null) {
        	System.out.println("new logger");
        	INSTANCE = new DraconianSingletonLogger();
        	
        }
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
