package sandeep.threadexceptions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HandlingExecutorUncaughtExceptionsForEveryThread {

	public static void main(String[] args) {
		
		
		Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("Default Handler"));

		ExecutorService executorService1 = Executors.newCachedThreadPool();

		executorService1.execute(new ExceptionLeakingTask());
		executorService1.execute(new ExceptionLeakingTask());
		executorService1.execute(new ExceptionLeakingTask());

		ExecutorService executorService2 = Executors.newCachedThreadPool();

		executorService2.execute(new ExceptionLeakingTask());
		executorService2.execute(new ExceptionLeakingTask());
		executorService2.execute(new ExceptionLeakingTask());
		
		executorService1.shutdown();
		executorService2.shutdown();

	}
}
