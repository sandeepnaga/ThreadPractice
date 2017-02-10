package sandeep.basic;

import java.util.concurrent.TimeUnit;

public class SecondWay {

	public static void main(String[] args) {

		System.out.println("Main Thread Started");

		new SecondTask().start();;
		new SecondTask().start();;

		System.out.println("Main Thread Ended");
	}

}

class SecondTask extends Thread {

	public static int count = 0;
	public int id;

	public SecondTask() {
		this.id = ++count;
		
	}

	@Override
	public void run() {
		for (int i = 10; i > 0; i--) {
			System.out.println("<" + id + "> TICK TICK " + i);
			try {
				TimeUnit.MILLISECONDS.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
