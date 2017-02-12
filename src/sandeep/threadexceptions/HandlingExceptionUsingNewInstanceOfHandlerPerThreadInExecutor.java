package sandeep.threadexceptions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HandlingExceptionUsingNewInstanceOfHandlerPerThreadInExecutor {

	public static void  main (String [] args){
		
	  ExecutorService executorService = Executors.newCachedThreadPool( new ThreadFactoryWithExceptionHandler());
	  
	  executorService.execute(new ExceptionLeakingTask());
	  executorService.execute(new ExceptionLeakingTask());
	  executorService.execute(new ExceptionLeakingTask());
	  executorService.execute(new ExceptionLeakingTask());
	  
	  executorService.shutdown();
	  
	}
}
