package sandeep.basic;

import java.util.concurrent.TimeUnit;

public class FourthWay {

	public static void main(String[] args) {

		System.out.println("Main Thread Started");

		 new Thread(new FourthTask()).start();;  
		 new Thread(new FourthTask()).start();;

		System.out.println("Main Thread Ended");
	}

}

class FourthTask implements Runnable {

	public static int count = 0;
	public int id;

	public FourthTask() {
		this.id = ++count;
		

	}

	@Override
	public void run() {
		for (int i = 10; i > 0; i--) {
			System.out.println("<" + id + ">TICK TICK " + i);
			try {
				TimeUnit.MILLISECONDS.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
