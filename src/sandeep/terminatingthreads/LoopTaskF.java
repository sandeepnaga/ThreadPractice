package sandeep.terminatingthreads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LoopTaskF implements Runnable {

	public static int count = 0;
	public int instanceNumber;
	private String taskId;
	private boolean shutdown = false;
	private final int DATA_SIZE = 10000;

	public LoopTaskF() {
		instanceNumber = ++count;
		taskId = "LoopTaskF -"+instanceNumber;
	}

	@Override
	public void run() {
		
		 String currentThreadName = Thread.currentThread().getName();
		System.out.println("#######["+ currentThreadName +"] STARTING THREAD <" + taskId + "> #######");

		for (int i = 10;; i++) {

			System.out.println("<TASK " + instanceNumber + ">" + "TICK TICK" + i);
			
			//doSomeWork();
			
			
		
		if(Thread.interrupted()){
		  System.out.println("["+ currentThreadName + "]<"+taskId +"> Interrupted. Canceling...." );
		 break;
		}
			
		}
		System.out.println("********["+ currentThreadName +"] printing interrupt status  <" +Thread.interrupted() + taskId + "> ********");
		System.out.println("********["+ currentThreadName +"] Ending THREAD Done <" + taskId + "> ********");

	}
	
	public void doSomeWork(){
		for(int i=0; i < 2; i++){
			Collections.sort(generateDateSet());
		}
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
