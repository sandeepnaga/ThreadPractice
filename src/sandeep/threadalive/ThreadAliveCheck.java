package sandeep.threadalive;

import java.util.concurrent.TimeUnit;

import sandeep.threadpools.LoopTaskC;

public class ThreadAliveCheck {

	public static void main (String [] args) throws InterruptedException{
		
		Thread t1 = new Thread(new LoopTaskC());
		Thread t2 = new Thread(new LoopTaskC());
		
		Boolean t1isAlive = t1.isAlive();
		Boolean t2isAlive = t2.isAlive();
		
		System.out.println("Before Start["+ Thread.currentThread().getName()+"]" + "t1isAlive" + t1isAlive +  "t2isAlive" + t2isAlive );
	t1.start();
	t2.start();
	
	  while(true){
	
		  TimeUnit.MILLISECONDS.sleep(600);
		  t1isAlive =  t1.isAlive();
		  t2isAlive =  t2.isAlive();
			System.out.println("IN LOOP ["+ Thread.currentThread().getName()+"]" + "t1isAlive" + t1isAlive +  "t2isAlive" + t2isAlive );
		  
			if(!t1isAlive && !t2isAlive){
				break;
			}
	  }
		
	  System.out.println("After loop["+ Thread.currentThread().getName()+"]" + "t1isAlive" + t1isAlive +  "t2isAlive" + t2isAlive );  
	}
}
