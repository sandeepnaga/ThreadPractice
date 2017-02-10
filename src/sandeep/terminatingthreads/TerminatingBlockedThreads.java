package sandeep.terminatingthreads;

import java.util.concurrent.TimeUnit;

public class TerminatingBlockedThreads {


	public static void main (String [] args) throws InterruptedException{
		String currentThreadName =  Thread.currentThread().getName();
		
		System.out.println("["+ currentThreadName + "]"+ "Main THread starts here");
		
		LoopTaskG task1 = new LoopTaskG();
		LoopTaskG task2 = new LoopTaskG();
		LoopTaskG task3 = new LoopTaskG();
		
		LoopTaskH  task4 = new LoopTaskH();
		
		
		Thread t1 = new Thread(task1,"MyThread-1");
		Thread t2 = new Thread(task2,"MyThread-2");
		Thread t3 = new Thread(task3,"MyThread-3");
		Thread t4 = new Thread(task4,"MyThread-4");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		TimeUnit.MILLISECONDS.sleep(2000);
		
		System.out.println("["+ currentThreadName+"] Interrupting"+ t1.getName() + "....");
		t1.interrupt();
		System.out.println("["+ currentThreadName+"] Interrupting"+ t2.getName() + "....");
		t2.interrupt();
		System.out.println("["+ currentThreadName+"] Interrupting"+ t3.getName() + "....");
		t3.interrupt();
		System.out.println("["+ currentThreadName+"] Interrupting"+ t4.getName() + "....");
		t4.interrupt();
		
		System.out.println("["+ currentThreadName + "]"+ "Main THread Ends here....");
	}


}
