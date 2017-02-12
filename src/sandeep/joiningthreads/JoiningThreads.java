package sandeep.joiningthreads;


import sandeep.daemonthreads.LoopTaskD;

public class JoiningThreads {

	public static void main (String [] args) throws InterruptedException{
		
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "]"  + "Main thread starts here");
	
	
		Thread t1 = new Thread(new LoopTaskD(100));
		Thread t2 = new Thread(new LoopTaskD(200));
		Thread t3 = new Thread(new LoopTaskD(500));
		Thread t4 = new Thread(new LoopTaskD(400));
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		t1.join();
		System.out.println("["+ currentThreadName + "]" + "main thread joined "+ t1.getName()  + "####");
		t2.join();
		System.out.println("["+ currentThreadName + "]" + "main thread joined "+ t2.getName()  + "####");
		t3.join();
		System.out.println("["+ currentThreadName + "]" + "main thread joined "+ t3.getName()  + "####");
		t4.join();
		System.out.println("["+ currentThreadName + "]" + "main thread joined "+ t4.getName()  + "####");
		
		
	}
}
