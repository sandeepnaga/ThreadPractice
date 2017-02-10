package sandeep.daemonthreads;

import sandeep.namingThreads.NamingThreadFactory;

public class DaemonThreadsFactory extends NamingThreadFactory {

	private static int count = 0;

	public Thread newThread(Runnable r) {
		Thread t = super.newThread(r);

		count++;
		System.out.println("abcd");
		if (count % 2 == 0) {
			System.out.println("setting daemon property&&&&&&&&&&&&&&&&&&&&& cout is"+ count + Thread.currentThread().getName());
			t.setDaemon(true);
		}
		
		if(t.isDaemon()){
			System.out.println("thread is daemon%%%%%%%%%%%%%%%"+ count + t.getName());
		}

		return t;
	}
}
