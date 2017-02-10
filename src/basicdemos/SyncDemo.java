package basicdemos;

class Counter {
	int a;

	public synchronized void increment() {
		a++;
	}
}

public class SyncDemo {

	public static void main(String[] args) throws InterruptedException {

		final Counter c = new Counter();

		Thread t1 = new Thread(new Runnable() {
			public void run() {

				for (int i = 0; i < 1000; i++) {
					c.increment();

				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {

				for (int i = 0; i < 1000; i++) {
					c.increment();

				}
			}
		});


		
				
		
		
		
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(c.a);
	}

}
