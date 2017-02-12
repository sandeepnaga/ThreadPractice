package sandeep.schedulingthreads.executors;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ScheduledTaskB implements Runnable {



	public static int count = 0;
	public int instanceNumber;
	private String taskId;
	private Long sleepTime;
	private SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");

	public ScheduledTaskB(long sleepTime) {
		instanceNumber = ++count;
		taskId = "ScheduledTaskB"+instanceNumber;
		this.sleepTime = sleepTime;
	}

	@Override
	public void run() {
		
		 Date startTime = new Date();
		
		 String currentThreadName = Thread.currentThread().getName();
		 
		System.out.println("#######[" + currentThreadName
				+ "] STARTING THREAD <" + taskId + "> Start Time " + dateFormatter.format(startTime));

		
		
					try {
				Thread.sleep(this.sleepTime);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				
		
		}

		System.out.println("*******[" + currentThreadName + "]   <"
				+ taskId + "> FINISHED AT " + dateFormatter.format(new Date()) + "***************");

	}






	
}
