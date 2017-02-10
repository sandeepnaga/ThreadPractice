package sandeep.threadpools;

public class LoopTaskC implements Runnable {


	public static int count = 0;
	public int instanceNumber;
	private String taskId;

	public LoopTaskC() {
		instanceNumber = ++count;
		taskId = "LoopTaskC"+instanceNumber;
	}

	@Override
	public void run() {
		
		 //Thread.currentThread().setName("AmazingThread");
		 
		System.out.println("#######["+  Thread.currentThread().getName() +"] STARTING THREAD <" + taskId + "> #######");

		for (int i = 10; i > 0; i--) {

			System.out.println("["+Thread.currentThread().getName()+"]"+"<TASK " + instanceNumber + ">" + "TICK TICK" + i);
			try {
				Thread.sleep(100);
				//Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("*******[" + Thread.currentThread().getName() +"] DONE THREAD <" + taskId + "> *******");

	}



}
