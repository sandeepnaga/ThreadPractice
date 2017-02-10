package sandeep.daemonthreads;

public class DaemonThreads {

	
	public static void main (String [] args){
		String currentThread =  Thread.currentThread().getName();
		System.out.println("##########["+ currentThread + "]" + "thread started##########");
		
		 Thread t1 = new Thread(new LoopTaskD(20),"Deamon");
		 t1.setDaemon(true);
		 t1.start();
		 new Thread(new LoopTaskD(1000),"normal").start();
		
		System.out.println("*************["+ currentThread + "]" + "thread ended ****************");
	}
}
