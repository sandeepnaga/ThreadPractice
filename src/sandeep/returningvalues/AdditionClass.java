package sandeep.returningvalues;

import java.util.concurrent.TimeUnit;

public class AdditionClass implements Runnable {



	private int a;
	private int b;
	private int sum;
	private long sleep;
	public static int count;
	private int instanceNumber;
	private String taskId;
	
	private  Boolean isDone = false;

	public AdditionClass(int a, int b, long sleep) {
		this.a = a;
		this.b = b;
		this.sleep = sleep;

		this.instanceNumber = ++count;
		this.taskId = "MyThread" + instanceNumber;
	}

	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		try {
			TimeUnit.MILLISECONDS.sleep(sleep);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.sum = this.a + this.b;
		isDone = true;
		notify();
      
	}

	
	
	public synchronized int getSum() throws InterruptedException {
		
		while(!isDone){
			wait();
			
		}
		
		return sum;
	}

	
}
