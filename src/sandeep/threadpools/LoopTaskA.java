package sandeep.threadpools;

public class LoopTaskA implements Runnable {

	public static int count = 0;
	public int id;

	public LoopTaskA() {
		id = ++count;
	}

	@Override
	public void run() {
		System.out.println("####### STARTING THREAD " + id + " #######");

		for (int i = 10; ; i--) {

			System.out.println("<TASK " + id + ">" + "TICK TICK" + i);
			/*try {
				//Thread.sleep( 200);
				//Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				break;
				//e.printStackTrace();
			}*/
		}
		
		

		//System.out.println("******* DONE THREAD " + id + " *******");

	}

}
