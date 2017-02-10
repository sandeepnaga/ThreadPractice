package sandeep.basic;

import java.util.concurrent.TimeUnit;

public class FifthWay {

	public static void main(String[] args) {

		System.out.println("Main THread Started");

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 10; i > 0; i--) {
					System.out.println("TICK TICK " + i);
					try {
						TimeUnit.MILLISECONDS.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}
		}).start();
		;

		System.out.println("Main THread Ended");
	}
}
