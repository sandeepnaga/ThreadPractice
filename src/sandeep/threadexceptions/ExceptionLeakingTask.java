package sandeep.threadexceptions;

public class ExceptionLeakingTask implements Runnable {

	@Override
	public void run() {
		throw new RuntimeException();

	}

}
