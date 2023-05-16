package kata.singleton;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    // TODO: How to make this thread safe with double-lock check algorithm?
    public static void main(String[] args) {
        // No longer need to declare new logger as instance as single instance is returned
        // Logger logger = new Logger();
        LoggerDoubleLockCheck logger = LoggerDoubleLockCheck.getInstance();
        logger.info("This is an info message");
        logger.debug("This is a debug message");
        logger.error("This is an error message");

        do_stuff();
        System.out.println(prove_thread_safe());
    }

    private static void do_stuff() {
        // Subsequent methods will only need this single instance as well
        // Logger logger = new Logger();
    	//DraconianSingletonLogger logger = DraconianSingletonLogger.getInstance();
        //logger.debug("Look I'm doing stuff");
    }
    
    // Proves we are thread safe if the hash code is printed the same without any errors (same dedicated memory address across threads)
    private static Boolean prove_thread_safe() {
        
    	Callable<Integer> c = () -> {
    		DraconianSingletonLogger logger = DraconianSingletonLogger.getInstance();
	        System.out.println(logger.hashCode());
	        return logger.hashCode();
        };
    	
    	ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<?> future1 = executorService.submit(c);
        Future<?> future2 = executorService.submit(c);
        
        int result1 = 0;
        int result2 = 0;
        
        try {
			result1 = (int) future1.get();
			result2 = (int) future2.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        executorService.shutdown();
        
        System.out.println(result1 + " == " + result2 + " ?");
        
        return result1 == result2;
    }
}
