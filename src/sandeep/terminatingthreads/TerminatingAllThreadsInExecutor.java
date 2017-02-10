package sandeep.terminatingthreads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import sandeep.returningvalues.CalculationTaskB;
import sandeep.returningvalues.ResultBean;
import sandeep.threadpools.LoopTaskA;

public class TerminatingAllThreadsInExecutor {

	public static void main (String [] args) throws InterruptedException, ExecutionException{
	
		String currentThreadName = Thread.currentThread().getName();
		
		System.out.println("["+currentThreadName+"]" + "Main thread Started");
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Future<?> future1 = executorService.submit(new LoopTaskA());
		//Future<?> future2 = executorService.submit(new LoopTaskF());
		//Future<ResultBean> future3 = executorService.submit(new CalculationTaskB(2,3,20000));
		//Future<?> future4 = executorService.submit(new LoopTaskF());
		executorService.shutdownNow();
		System.out.println("future1"+ future1.get());
		//System.out.println("future2"+ future2.get());
		//System.out.println("future3"+ future3.get());
		System.out.println("["+currentThreadName+"]" + "Main thread Ended");
	}
}
