package sandeep.terminatingthreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import sandeep.namingThreads.NamingThreadFactory;

public class TerminatingExecutorTasksFirstWay {

	public static void main (String [] args){
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("["+ currentThreadName + "]" + "Main thread starts here");
		ExecutorService executorService = Executors.newCachedThreadPool(new NamingThreadFactory());
		
		LoopTaskE loopTaskE = new LoopTaskE();
		executorService.execute(loopTaskE);
		
		 FactorialTaskA factorialTaskA =   new FactorialTaskA(10, 3000L);
		executorService.submit(factorialTaskA);
		
		executorService.shutdown();
		loopTaskE.cancel();
		factorialTaskA.cancel();
		
		
		
		
		
		System.out.println("["+ currentThreadName + "]" + "Main thread ends here...");
		
	}
}
