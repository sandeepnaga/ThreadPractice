package sandeep.threadexceptions;

public class HandlingUncaughtExceptionsForEveryThread {

	public static void main(String[] args) {
		
		Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("Default handler"));
		new Thread(new ExceptionLeakingTask(),"MyThread-1").start();
		new Thread(new ExceptionLeakingTask(),"MyThread-2").start();
		new Thread(new ExceptionLeakingTask(),"MyThread-3").start();
		new Thread(new ExceptionLeakingTask(),"MyThread-4").start();
	
	}
}
