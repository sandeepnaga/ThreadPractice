package sandeep.threadexceptions;

import sandeep.namingThreads.NamingThreadFactory;

public class ThreadExceptionHandlerAlternator extends NamingThreadFactory {

	private int count = 0;

	@Override
	public Thread newThread(Runnable paramRunnable) {
		Thread t = super.newThread(paramRunnable);
		int sequence = ++count;

		if (sequence % 2 == 0) {
			t.setUncaughtExceptionHandler(new ThreadExceptionHandler(
					"Customized"));
		}
		
		return t;
	}

}
