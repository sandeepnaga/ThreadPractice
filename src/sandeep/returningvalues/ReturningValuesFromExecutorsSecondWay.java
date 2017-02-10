package sandeep.returningvalues;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.util.concurrent.TimeUnit;

import sandeep.namingThreads.NamingThreadFactory;


public class ReturningValuesFromExecutorsSecondWay {

	public static void main (String [] args) throws InterruptedException{
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("["+ currentThreadName + "] Main Thread Starts here" );
		
		ExecutorService executorService =  Executors.newCachedThreadPool(new NamingThreadFactory());
		CompletionService<ResultBean> tasks = new ExecutorCompletionService<ResultBean>(executorService);
		
		tasks.submit(new CalculationTaskB(2, 3, 10000));
		tasks.submit(new CalculationTaskB(3, 4, 100));
		tasks.submit(new CalculationTaskB(4, 5, 0));
		
		//tasks.submit(new LoopTaskA(),new ResultBean(3, "sample"));
		
		executorService.shutdown();
		
		TimeUnit.MILLISECONDS.sleep(2000);
		
		for(int i=0; i<3; i++){
			try {
				//System.out.println(tasks.take().get());
				System.out.println("i value is "+i);
				String res = tasks.take().get().toString();
				
				System.out.println(res);
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("main thread ended*********************");
	}


}
