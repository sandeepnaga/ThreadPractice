package sandeep.threadalive;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import sandeep.namingThreads.NamingThreadFactory;
import sandeep.returningvalues.CalculationTaskA;
import sandeep.threadpools.LoopTaskC;

public class ExecutorThreadsAliveCheck {

	public static void main (String [] args) throws InterruptedException, ExecutionException{
		String currentThreadName = Thread.currentThread().getName();
		
		System.out.println("["+ currentThreadName +"]" +"started");
		
		
		ExecutorService executorService = Executors.newCachedThreadPool(new NamingThreadFactory());
		
		Future<?> future1 = executorService.submit(new LoopTaskC());
		Future<Integer> future2 = executorService.submit(new CalculationTaskA(2, 3, 10000));
		
		
		FutureTask<Integer> ft3 = new FutureTask<Integer>(new CalculationTaskA(4, 5, 2000));
		executorService.submit(ft3);
		
		for(int i=0; i < 5; i++){
			TimeUnit.MILLISECONDS.sleep(600);
			
			System.out.println("["+ currentThreadName + "] ITR" + i + "- >" + "Is LOOP TASK C-1 done?"+future1.isDone() ) ;
			
			System.out.println("["+ currentThreadName + "] ITR" + i + "- >" + "Is CalculationTask A-1 done?"+future2.isDone() ) ;
			
			System.out.println("["+ currentThreadName + "] ITR" + i + "- >" + "Is CalculationTask A-2 done?"+ft3.isDone() ) ;
		
		}
		
		try {
			System.out.println("\n $$$$$$$$$$$["+ currentThreadName + "] " + "- >" + "result LOOP TASK C-1 "+future1.get() ) ;
			System.out.println("\n $$$$$$$$$$$["+ currentThreadName + "] " + "- >" + "result CalculationTask A-1 "+future2.get() ) ;
			
			System.out.println("\n $$$$$$$$$$$["+ currentThreadName + "] " + "- >" + "result CalculationTask A-2 "+ft3.get() ) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
