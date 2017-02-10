package sandeep.returningvalues;

import java.util.concurrent.TimeUnit;

import javax.xml.bind.Marshaller.Listener;

public class AdditionClassB implements Runnable {



	private int a;
	private int b;
	private int sum;
	private long sleep;
	public static int count;
	private int instanceNumber;
	private String taskId;
	private ResultListener<Integer> resultListener;
	

	public AdditionClassB(int a, int b, long sleep , ResultListener<Integer> listner) {
		this.a = a;
		this.b = b;
		this.sleep = sleep;
        this.resultListener = listner;
		this.instanceNumber = ++count;
		this.taskId = "AdditionClassB" + instanceNumber;
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
	
	    resultListener.notifyResult(this.sum);
      
	}

	
	
	public synchronized int getSum() throws InterruptedException {
		
		
		return sum;
	}

	
}
