package sandeep.threadexceptions;

public class HandlingUncaughtExceptionsDifferentlyForEachThread {

	public static void main (String [] args){
		
		Thread t1 = new Thread(new ExceptionLeakingTask());
		
		Thread t2 = new Thread(new ExceptionLeakingTask());
		
		Thread t3 = new Thread(new ExceptionLeakingTask());
		
		t1.setUncaughtExceptionHandler(new ThreadExceptionHandler());
		
		t2.setUncaughtExceptionHandler(new ThreadExceptionHandler());
		
		t3.setUncaughtExceptionHandler(new ThreadExceptionHandler());
	 
		 t1.start();
		 
		 t2.start();
		 
		 t3.start();
	
	}
	
}
