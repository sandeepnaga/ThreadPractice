package sandeep.returningvalues;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CalculationTaskA implements Callable<Integer> {

	private int a;
	private int b;
	private int sum;
	private int sleepTime;
	private int count;
	private int instanceNumber;
	private String taskId;

	public CalculationTaskA(int a, int b, int sleepTime) {
		this.a = a;
		this.b = b;
		this.sleepTime = sleepTime;

		this.instanceNumber = ++count;
		this.taskId = "CalcTaskA" + instanceNumber;
	}

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		String currentThreadName = Thread.currentThread().getName();
		
		System.out.println("####["+currentThreadName+"]"+ "<"+ taskId+">" + "started" +"######");
		TimeUnit.MILLISECONDS.sleep(sleepTime);
		this.sum = this.a+ this.b;
		
		System.out.println("****["+currentThreadName+"]"+ "<"+ taskId+">" + "ended" +"******");
		return this.sum;	
		
		
	}
}
