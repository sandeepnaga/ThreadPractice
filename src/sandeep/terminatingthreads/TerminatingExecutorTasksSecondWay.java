package sandeep.terminatingthreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import sandeep.namingThreads.NamingThreadFactory;

public class TerminatingExecutorTasksSecondWay {

	public static void main (String [] args){
		
		String currentThread =  Thread.currentThread().getName();
		
		ExecutorService executorService = Executors.newCachedThreadPool(new NamingThreadFactory());
		
		LoopTaskF task1 = new LoopTaskF();
		LoopTaskF task2 = new LoopTaskF();
		LoopTaskF task3 = new LoopTaskF();
		
		Future<?> future1 = executorService.submit(task1);
		Future<?> future2 =	executorService.submit(task2);
		Future<?> future3 = executorService.submit(task3);
		
		System.out.println("["+ currentThread + "]" + "Interrupting LoopTaskF -1");
		System.out.println("["+ currentThread + "]" + "Canceling f1 ="+ future1.cancel(true));
		
		System.out.println("["+ currentThread + "]" + "Interrupting LoopTaskF -2");
		System.out.println("["+ currentThread + "]" + "Canceling f2 ="+ future2.cancel(true));
		
		System.out.println("["+ currentThread + "]" + "Interrupting LoopTaskF -3");
		System.out.println("["+ currentThread + "]" + "Canceling f3 ="+ future3.cancel(true));
		
		System.out.println("["+ currentThread + "]" + "Main Thread Ends Here");
		
		
		
		
		
		
	}
}
