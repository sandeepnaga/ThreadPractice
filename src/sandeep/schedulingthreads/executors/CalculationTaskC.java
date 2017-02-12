package sandeep.schedulingthreads.executors;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CalculationTaskC implements Callable<Integer> {


	private int a;
	private int b;
	private int sum;
	private int sleepTime;
	private int count;
	private int instanceNumber;
	private String taskId;
	private SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
	
	
	public CalculationTaskC(int a, int b, int sleepTime) {
		this.a = a;
		this.b = b;
		this.sleepTime = sleepTime;

		this.instanceNumber = ++count;
		this.taskId = "CalcTaskC" + instanceNumber;
	}

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		String currentThreadName = Thread.currentThread().getName();
		Date currentDate = new  Date();
		
		
		System.out.println("####["+currentThreadName+"]"+ "<"+ taskId+">" + "started at"+  dateFormatter.format(currentDate)  + "######");
		TimeUnit.MILLISECONDS.sleep(sleepTime);
		this.sum = this.a+ this.b;
		
		System.out.println("****["+currentThreadName+"]"+ "<"+ taskId+">" + "Finished at"+ dateFormatter.format(currentDate) +"******");
		return this.sum;	
		
		
	}


}
