package sandeep.schedulingthreads;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

import sandeep.utils.TimeUtils;

public class SchedulingTaskForOneTimeExecution {

	private static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss.SSS");
	
	public static void main (String [] args) throws InterruptedException{
		String currentThreadName = Thread.currentThread().getName();
		
		System.out.println("#####["+ currentThreadName +"]" + "Main Thread Starts here");
		
		Timer timer = new Timer("Timer-thread",false);
		Date currentTime =  new Date();
		Date scheduledTime = TimeUtils.getFutureTime(currentTime, 5000);
		
		System.out.println("["+ currentThreadName + "] Current time"+ dateFormatter.format(currentTime));
		
		timer.schedule(new ScheduledTaskA(2000), scheduledTime);
		
		System.out.println("["+ currentThreadName + "]" + "TASK 1 SCHEDULE TO RUN AT"+ scheduledTime);
		
		Thread.sleep(9000);
		timer.schedule(new ScheduledTaskA(2000), TimeUtils.getFutureTime(currentTime, 20000));
		timer.cancel();
		//********************************************************************************************
		
		
		
		System.out.println("["+ currentThreadName +"]" + "Main Thread ENDS here.....");
	}
}
