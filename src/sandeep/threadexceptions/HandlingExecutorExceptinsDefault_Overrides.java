package sandeep.threadexceptions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HandlingExecutorExceptinsDefault_Overrides {

	public static void main (String [] args){
		
		Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("Default"));;
		
		ExecutorService executorService = Executors.newCachedThreadPool(new ThreadExceptionHandlerAlternator());
		
		executorService.execute(new ExceptionLeakingTask());
		executorService.execute(new ExceptionLeakingTask());
		executorService.execute(new ExceptionLeakingTask());
		executorService.execute(new ExceptionLeakingTask());
		
		

				
	}
}
