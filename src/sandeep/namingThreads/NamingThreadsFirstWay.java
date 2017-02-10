package sandeep.namingThreads;

import java.util.concurrent.TimeUnit;

import sandeep.threadpools.LoopTaskC;

public class NamingThreadsFirstWay {

	public static void main (String [] args) throws InterruptedException{
		String currentThreadName = Thread.currentThread().getName();
		
		System.out.println("["+currentThreadName +"] thread started" );
		
		//new Thread(new LoopTaskB()).start();
		Thread t2 = new Thread(new LoopTaskC());
		
		t2.start();
		TimeUnit.MILLISECONDS.sleep(800);
		t2.setName("MY THREAD 2");
		
		
		
		
		System.out.println("["+currentThreadName +"] thread ended" );
	}
}
