package kata.singleton;

public class Main {
    // TODO: How to make this thread safe with double-lock check algorithm?
    public static void main(String[] args) {
        // No longer need to declare new logger as instance as single instance is returned
        // Logger logger = new Logger();
        Logger logger = Logger.getInstance();
        logger.info("This is an info message");
        logger.debug("This is a debug message");
        logger.error("This is an error message");

        do_stuff();
    }

    private static void do_stuff() {
        // Subsequent methods will only need this single instance as well
        // Logger logger = new Logger();
        Logger logger = Logger.getInstance();
        logger.debug("Look I'm doing stuff");
    }
}
