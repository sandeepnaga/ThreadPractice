package sandeep.schedulingthreads;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

public class ScheduledTaskA extends TimerTask {



	public static int count = 0;
	public int instanceNumber;
	private String taskId;
	private Long sleepTime;
	private SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");

	public ScheduledTaskA(long sleepTime) {
		instanceNumber = ++count;
		taskId = "ScheduledTaskA"+instanceNumber;
		this.sleepTime = sleepTime;
	}

	@Override
	public void run() {
		
		 Date startTime = new Date();
		 Date scheduledToRun = new Date(super.scheduledExecutionTime());
		 
		 String currentThreadName = Thread.currentThread().getName();
		 
		System.out.println("#######[" + currentThreadName
				+ "] STARTING THREAD <" + taskId + "> SCHEDULED TO RUN AT"
				+ dateFormatter.format(scheduledToRun)
				+ "But Actual Start Time " + dateFormatter.format(startTime));

		//for (int i = 10; i > 0; i--) {

			//System.out.println("["+currentThreadName+"]<TASK " + instanceNumber + ">" + "TICK TICK" + i);
			try {
				Thread.sleep(this.sleepTime);
				//Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			//}
		}

		System.out.println("*******[" + currentThreadName + "] DONE THREAD <"
				+ taskId + "> FINISHED AT " + dateFormatter.format(new Date()));

	}




}
