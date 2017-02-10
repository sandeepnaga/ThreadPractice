package b.practice;

public class NoVisibility {
	private static boolean ready;
	private static int number;

	private static class ReaderThread extends Thread {
		public void run() {
			System.out.println("reay value "+ ready);
			while (!ready){
				System.out.println("aa");
				Thread.yield();
			}
			System.out.println(number);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t = new ReaderThread();
		
		number = 42;
		t.start();
		//t.join();
		
		
		//ready = true;
	}
}