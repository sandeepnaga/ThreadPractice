package sandeep.schedulingthreads;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import sandeep.utils.TimeUtils;

public class SchedulingTaskForFixedDelayRepeatedExecutions {

	private static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss.SSS");
	
	public static void main (String [] args) throws InterruptedException{
		
	String currentThreadName =  Thread.currentThread().getName();
	
	System.out.println("["+ currentThreadName + "]" + "Main thread starts here");
	
	Date currentDate = new Date();
	
	Timer timer = new Timer("MyThread",  false);
	
	Date firstExecution =  TimeUtils.getFutureTime(currentDate, 5000);
	
	timer.schedule(new ScheduledTaskA(2000), firstExecution, 4000);
	
	TimeUnit.MILLISECONDS.sleep(20000);
	
	timer.cancel();
	
	System.out.println("["+ currentThreadName + "]" + "Main thread ends here");
	
	}
}
