package sandeep.terminatingthreads;

import java.util.concurrent.TimeUnit;

public class TerminatingThreadsFirstWay {

	public static void main (String [] args){
		LoopTaskE task1 = new  LoopTaskE();
		LoopTaskE task2 = new  LoopTaskE();
		LoopTaskE task3 = new  LoopTaskE();
		
		new Thread(task1,"MYThread-1").start();
		new Thread(task1,"MYThread-2").start();
		new Thread(task1,"MYThread-3").start();
		
		try {
			TimeUnit.MILLISECONDS.sleep(400);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		task1.cancel();
		task2.cancel();
		task3.cancel();
		
		
	}
}
