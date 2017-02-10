package sandeep.namingThreads;

import java.util.concurrent.ThreadFactory;

public class NamingThreadFactory implements ThreadFactory {
	
	public static int count=0;
	public static String  name = "MY THREAD";
	

	@Override
	public Thread newThread(Runnable paramRunnable) {
		Thread t = new Thread(paramRunnable);
		t.setName(name + ++count);
		return t;
	}

	

}
