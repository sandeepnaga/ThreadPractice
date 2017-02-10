package sandeep.terminatingthreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import sandeep.namingThreads.NamingThreadFactory;

public class TerminatingBlockedExecutorTasks {

	public static void main(String[] args) throws InterruptedException {
		String currentThreadName =  Thread.currentThread().getName();
		System.out.println("["+ currentThreadName +"]" + "Main Thread Starts here....");
		
		LoopTaskG task1 = new LoopTaskG();
         
         
		
		ExecutorService executorService = Executors
				.newCachedThreadPool(new NamingThreadFactory());
		Future<?> future1 = executorService.submit(task1);
		
		
		Thread.sleep(3000);
		System.out.println("[" + currentThreadName + "]" + "Interrupting task LoopTaskG -1....");
		System.out.println("[" + currentThreadName + "] Return value for cancelation" +  future1.cancel(true));
		
		
		System.out.println("["+ currentThreadName +"]" + "Main Thread ends here....");
	}
}
