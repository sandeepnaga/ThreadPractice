package sandeep.namingThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import sandeep.threadpools.LoopTaskC;

public class NamingExecutorThreads {

	public static void main (String [] args){
		
		ExecutorService executorService = Executors.newCachedThreadPool(new NamingThreadFactory());
		
		executorService.execute(new LoopTaskC());
		executorService.execute(new LoopTaskC());
		executorService.execute(new LoopTaskC());
		
		
	}
}
