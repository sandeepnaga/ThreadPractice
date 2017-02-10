package sandeep.returningvalues;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import sandeep.namingThreads.NamingThreadFactory;
import sandeep.threadpools.LoopTaskA;

public class ReturingValuesUsingExecutorsFirstWay {

	public static void main (String [] args){
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("["+ currentThreadName + "] Main Thread Starts here" );
		
		ExecutorService executorService =  Executors.newCachedThreadPool(new NamingThreadFactory());
		Future<Integer> future1 = executorService.submit(new CalculationTaskA(2, 3, 5000));
		Future<Integer> future2 = executorService.submit(new CalculationTaskA(3, 4, 0));
		Future<Integer> future3 = executorService.submit(new CalculationTaskA(4, 5, 6000));
		Future<?> future4 =  executorService.submit(new LoopTaskA());
		Future<Boolean> future5 =  executorService.submit(new LoopTaskA(),true);
		
		
		try {
			System.out.println(future1.get());
			System.out.println(future2.get());
			System.out.println(future3.get());
			System.out.println(future4.get());
			System.out.println(future5.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
