package sandeep.threadexceptions;

import sandeep.namingThreads.NamingThreadFactory;

public class ThreadFactoryWithExceptionHandler extends NamingThreadFactory {

	@Override
	public Thread newThread(Runnable paramRunnable) {
		Thread t = super.newThread(paramRunnable);

		t.setUncaughtExceptionHandler(new ThreadExceptionHandler());
		return t;
	}

}
