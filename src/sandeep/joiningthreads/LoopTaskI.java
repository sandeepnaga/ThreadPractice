package sandeep.joiningthreads;

import java.util.concurrent.CountDownLatch;

public class LoopTaskI implements Runnable{



	public static int count = 0;
	public int instanceNumber;
	private String taskId;
	private Long sleepTime;
	private CountDownLatch countDownLatch;

	public LoopTaskI(long sleepTime, CountDownLatch countDownLatch) {
		instanceNumber = ++count;
		taskId = "LoopTaskI"+instanceNumber;
		this.sleepTime = sleepTime;
		this.countDownLatch = countDownLatch;
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

		
		if(countDownLatch !=null){
			countDownLatch.countDown();
		}
		
		System.out.println("*******[" +currentThreadName +"] DONE THREAD <" + taskId + "> *******");

	}






}
