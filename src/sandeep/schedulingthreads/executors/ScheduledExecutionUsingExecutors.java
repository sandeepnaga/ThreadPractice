package sandeep.schedulingthreads.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import sandeep.namingThreads.NamingThreadFactory;

public class ScheduledExecutionUsingExecutors {

	
	public static void main (String [] args) throws InterruptedException, ExecutionException{
		
		String currentThreadName =  Thread.currentThread().getName();
		
		System.out.println("["+currentThreadName+"]"+ "Main Thread started here" );
		
		ScheduledExecutorService executorService =  Executors.newSingleThreadScheduledExecutor(new NamingThreadFactory());
		
		//ScheduledFuture<?> fut1 =   executorService.schedule(new ScheduledTaskB(8000), 0, TimeUnit.SECONDS);
		ScheduledFuture<Integer> fut2 = executorService.schedule(new CalculationTaskC(3, 4, 20000), 4, TimeUnit.SECONDS);
		 
		TimeUnit.MILLISECONDS.sleep(5000);
		
		System.out.println("fut1 .canceling.... is"+ fut2.cancel(true));
		System.out.println("fut1 .get before"+ fut2.get());
		executorService.shutdown();
		//System.out.println("fut1 .get is"+ fut1.get());
		
		
		System.out.println("["+currentThreadName+"]"+ "Main Thread ended here" );
	}
}
