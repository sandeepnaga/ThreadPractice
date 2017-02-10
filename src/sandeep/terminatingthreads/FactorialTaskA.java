package sandeep.terminatingthreads;

import java.util.concurrent.Callable;

public class FactorialTaskA implements Callable<Long> {


	public static int count = 0;
	public int instanceNumber;
	private String taskId;
	private boolean shutdown = false;
	private int input;
	private Long sleepTime;
	private Long factorial;

	public FactorialTaskA(int input, Long sleepTime) {
		instanceNumber = ++count;
		this.input = input;
		this.sleepTime =  sleepTime;
		taskId = "FactorialTaskA -"+instanceNumber;
		
	}

	@Override
	public  Long call() {
		
		 String currentThreadName = Thread.currentThread().getName();
		System.out.println("#######["+ currentThreadName +"] STARTING THREAD <" + taskId + "> #######");
		factorial = 1L;
		for (int i = 1; i <= input; i++) {

			factorial =  factorial* i;
			System.out.println("[" + currentThreadName + "] < " + taskId + ">"
					+ "iteration " + i + "IntermediateResult = " + factorial);
			
			
			try {
				Thread.sleep(this.sleepTime);
				//Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			synchronized (this) {
				if(shutdown){
					factorial = -1L;
					break;
				}	
			}
			
		}

		System.out.println("********["+ currentThreadName +"] Ending THREAD Done <" + taskId + "> ********");
return factorial;
	}

	
	public void cancel(){
		System.out.println("********["+ Thread.currentThread().getName() +"] Shutting down <" + taskId + "> ********");
		
		synchronized (this) {
			this.shutdown = true;
		}
		
	}





}
