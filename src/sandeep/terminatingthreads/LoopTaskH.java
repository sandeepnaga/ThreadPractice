package sandeep.terminatingthreads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LoopTaskH implements Runnable{



	public static int count = 0;
	public int instanceNumber;
	private String taskId;
	private Boolean sleepInterrupted = false;
	
	
	private final int DATA_SIZE = 10000;

	public LoopTaskH() {
		instanceNumber = ++count;
		taskId = "LoopTaskH -"+instanceNumber;
	}

	@Override
	public void run() {
		
		 String currentThreadName = Thread.currentThread().getName();
		System.out.println("#######["+ currentThreadName +"] STARTING THREAD <" + taskId + "> #######");

		for (int i = 10;; i--) {

			System.out.println("<TASK " + instanceNumber + ">" + "TICK TICK" + i);
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("********["+ currentThreadName +"]  THREAD interrupted <" + taskId + "> Setting interrupted .....");
			     sleepInterrupted = true;
			}
			
			doSomeWork();
			
			if(sleepInterrupted || Thread.interrupted()){
				System.out.println("********["+ currentThreadName +"] Thread Interrupted <" + taskId + "> Canceling....");	
				break;
			}
			
		}
		
		System.out.println("********["+ currentThreadName +"] Ending THREAD Done <" + taskId + "> ********");

	}
	
	public void doSomeWork(){
		System.out.println("********["+ Thread.currentThread().getName() +"] Doing some work <" + taskId + "> ........");
	}
	
	public List<Integer> generateDateSet(){
		List<Integer> intList = new  ArrayList<Integer>();
		Random random = new Random();
		for(int i=0; i < DATA_SIZE; i++){
			intList.add(random.nextInt(DATA_SIZE));
		}
		
		return intList;
	}


}
