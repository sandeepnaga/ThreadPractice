package sandeep.threadexceptions;

public class HandlingUncaughtExceptions_DefaultsAndOverrides {

	public static void main (String [] args){
		String currentThreadName = Thread.currentThread().getName();
		
		System.out.println("["+ currentThreadName + "]" + "Main Thread Starts here");
		
		Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("Default handler"));
		
		Thread t1 = new Thread(new ExceptionLeakingTask(),"MyThread-1");
		t1.setUncaughtExceptionHandler(new ThreadExceptionHandler("customized-1"));
		Thread t2 = new Thread(new ExceptionLeakingTask(),"MyThread-2");
		Thread t3 = new Thread(new ExceptionLeakingTask(),"MyThread-3");
		t3.setUncaughtExceptionHandler(new ThreadExceptionHandler("customized-3"));
		Thread t4 = new Thread(new ExceptionLeakingTask(),"MyThread-4");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		
		System.out.println("["+ currentThreadName + "]" + "Main Thread Ends here");
	}
}
