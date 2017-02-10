package sandeep.terminatingthreads;

public class LoopTaskE implements Runnable {

	public static int count = 0;
	public int instanceNumber;
	private String taskId;
	private boolean shutdown = false;

	public LoopTaskE() {
		instanceNumber = ++count;
		taskId = "LoopTaskE -"+instanceNumber;
	}

	@Override
	public void run() {
		
		 String currentThreadName = Thread.currentThread().getName();
		System.out.println("#######["+ currentThreadName +"] STARTING THREAD <" + taskId + "> #######");

		for (int i = 10;; i--) {

			System.out.println("<TASK " + instanceNumber + ">" + "TICK TICK" + i);
			try {
				Thread.sleep((long) Math.random() * 3000);
				//Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			synchronized (this) {
				if(shutdown){
					break;
				}	
			}
			
		}

		System.out.println("********["+ currentThreadName +"] Ending THREAD Done <" + taskId + "> ********");

	}

	
	public void cancel(){
		System.out.println("********["+ Thread.currentThread().getName() +"] Shutting down <" + taskId + "> ********");
		
		synchronized (this) {
			this.shutdown = true;
		}
		
	}



}
