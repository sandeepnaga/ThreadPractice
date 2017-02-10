package sandeep.daemonthreads;

public class LoopTaskD implements Runnable {



	public static int count = 0;
	public int instanceNumber;
	private String taskId;
	private Long sleepTime;

	public LoopTaskD(long sleepTime) {
		instanceNumber = ++count;
		taskId = "LoopTaskD"+instanceNumber;
		this.sleepTime = sleepTime;
	}

	@Override
	public void run() {
		
		 
		 String currentThreadName = Thread.currentThread().getName();
		System.out.println("#######["+ currentThreadName +"] STARTING THREAD <" + taskId + "> #######");

		for (int i = 10; i > 0; i--) {

			System.out.println("["+currentThreadName+"]<TASK " + instanceNumber + ">" + "TICK TICK" + i);
			try {
				Thread.sleep(this.sleepTime);
				//Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("*******[" +currentThreadName +"] DONE THREAD <" + taskId + "> *******");

	}




}
