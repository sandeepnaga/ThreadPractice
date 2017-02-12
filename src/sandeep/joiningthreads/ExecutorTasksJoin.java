package sandeep.joiningthreads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import sandeep.namingThreads.NamingThreadFactory;

public class ExecutorTasksJoin {

	public static void main (String [] args){
	
		
		String currentThreadName =  Thread.currentThread().getName();
		System.out.println("["+ currentThreadName + "]" + "Main thread starts here");
		CountDownLatch doneSignalAwait = new CountDownLatch(2);
		
		ExecutorService executorService = Executors.newCachedThreadPool(new NamingThreadFactory());
		executorService.submit( new LoopTaskI(100, doneSignalAwait));
		executorService.submit( new LoopTaskI(200, doneSignalAwait));
		executorService.submit( new LoopTaskI(300, doneSignalAwait));
		executorService.submit( new LoopTaskI(400, doneSignalAwait));
		
		
		try{
			doneSignalAwait.await();
			System.out.println("["+ currentThreadName + "]" + "got the singal to continue");
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
		executorService.shutdown();
		
		System.out.println("[" + currentThreadName + "]" + "Main thread ends here");
		
		
	}
}
