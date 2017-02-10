package sandeep.threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingFixedThreadPool {

	public static void main (String [] args){
		
		ExecutorService execService = Executors.newFixedThreadPool(6);
		execService.submit(new LoopTaskA());
		execService.submit(new LoopTaskA());
		execService.submit(new LoopTaskA());
		
		execService.submit(new LoopTaskA());
		execService.submit(new LoopTaskA());
		execService.submit(new LoopTaskA());
		
		
		//TO TEST THREAD ADDITION AFTER SHUTDOWN
		//execService.shutdown();
		//execService.submit(new LoopTaskA());
		
	}
}
