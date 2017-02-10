package sandeep.threadpools;

public class LoopTaskB implements Runnable {


	public static int count = 0;
	public int instanceNumber;
	private String taskId;

	public LoopTaskB() {
		instanceNumber = ++count;
		taskId = "LoopTaskB"+instanceNumber;
	}

	@Override
	public void run() {
		
		 Thread.currentThread().setName("AmazingThread");
		 String currentThreadName = Thread.currentThread().getName();
		System.out.println("#######["+ currentThreadName +"] STARTING THREAD <" + taskId + "> #######");

		for (int i = 10; i > 0; i--) {

			System.out.println("<TASK " + instanceNumber + ">" + "TICK TICK" + i);
			try {
				Thread.sleep((long) Math.random() * 3000);
				//Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("*******[" +currentThreadName +"] DONE THREAD <" + taskId + "> *******");

	}



}
