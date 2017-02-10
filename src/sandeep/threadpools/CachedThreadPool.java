package sandeep.threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {

	public static void main(String[] args) {

		ExecutorService execService = Executors.newCachedThreadPool();
		execService.execute(new LoopTaskA());
		execService.submit(new LoopTaskA());
		execService.submit(new LoopTaskA());

		execService.submit(new LoopTaskA());
		execService.submit(new LoopTaskA());
		execService.submit(new LoopTaskA());

		// TO TEST THREAD ADDITION AFTER SHUTDOWN
		// execService.shutdown();
		// execService.submit(new LoopTaskA());

	}

}
