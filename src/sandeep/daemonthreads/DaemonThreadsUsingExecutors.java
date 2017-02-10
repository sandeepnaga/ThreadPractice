package sandeep.daemonthreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DaemonThreadsUsingExecutors {

	public static void main (String [] args){
		String currentThreadName = Thread.currentThread().getName();
		
		System.out.println("#############["+ currentThreadName + "]" + "thread started ###############");
		
		ExecutorService executorService = Executors.newCachedThreadPool( new DaemonThreadsFactory());
		
		executorService.execute(new LoopTaskD(100));
		executorService.execute(new LoopTaskD(200));
		executorService.execute(new LoopTaskD(300));
		executorService.execute(new LoopTaskD(1000));
		
		executorService.shutdown();
		
		
		System.out.println("**********["+ currentThreadName + "]" + "thread started ************");
	}
}
