package basicdemos;
class Q {
	int num;

	boolean valueSet = false;

	public synchronized void put(int num) {
		while (valueSet) {
			try {
				wait();

			} catch (Exception e) {

			}
		}
		System.out.println("put :" + num);
		this.num = num;
		valueSet = true;
		notify();
	}

	public synchronized void get() {
		while (!valueSet) {
			try {
				wait();

			} catch (Exception e) {

			}
		}

		System.out.println("Get :" + num);
		valueSet = false;
		notify();
	}
}

class Producer implements Runnable {
	Q q;

	public Producer(Q q) {

		this.q = q;
		Thread t = new Thread(this, "Producer");
		t.start();
	}

	@Override
	public void run() {
		int i = 0;
		while (true) {
			q.put(i++);
			try {
				Thread.sleep(500);
			} catch (Exception e) {

			}
		}

	}

}

class consumer implements Runnable {

	Q q;

	public consumer(Q q) {
		this.q = q;
		Thread t = new Thread(this, "Consumer");
		t.start();
	}

	@Override
	public void run() {

		while (true) {
			q.get();
			try {
				Thread.sleep(500);
			} catch (Exception e) {

			}

		}

	}

}

public class InterThreadCommunication {

	public static void main(String[] args) {

		Q q = new Q();
		new Producer(q);
		new consumer(q);
	}
}
