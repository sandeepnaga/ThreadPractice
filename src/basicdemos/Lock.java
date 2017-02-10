package basicdemos;

public class Lock implements Runnable {

	public void classMethod() throws InterruptedException {

		synchronized (this) {
			System.out.println("inside lock method");
			Thread.sleep(5000);
			int i = 0;
			while (i < 100) {
				i++;
				System.out.println(i);
			}
		}

	}

	public void normalMethod() {

		synchronized (this) {
			System.out.println("normale Method");
		}

	}

	@Override
	public void run() {
		try {
			classMethod();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws InterruptedException {

		final Lock staticLock = new Lock();

		final Lock objLock = new Lock();

		Thread t1 = new Thread(staticLock);
		t1.setName("staticLokcThread");

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				staticLock.normalMethod();

			}
		});

		t1.start();
		t2.start();
	}

}
