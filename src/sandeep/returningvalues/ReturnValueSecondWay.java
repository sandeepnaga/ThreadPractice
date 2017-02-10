package sandeep.returningvalues;

public class ReturnValueSecondWay {



	public static void main (String [] args) throws InterruptedException{
		
		String currentThread = Thread.currentThread().getName();
		System.out.println("["+currentThread+"]"+ "Started"	);
		
		ResultListener<Integer> listener1 = new AdditionObserver("task1");
		ResultListener<Integer> listener2 = new AdditionObserver("task2");
		ResultListener<Integer> listener3 = new AdditionObserver("task3");
		
		AdditionClassB instance1 = new AdditionClassB(2, 3, 1000,listener1);
		AdditionClassB instance2 = new AdditionClassB(3, 4, 1000,listener2);
		AdditionClassB instance3 = new AdditionClassB(4, 5, 1000,listener3);
		
		new Thread(instance1).start();
		new Thread(instance2).start();
		new Thread(instance3).start();
		
		
		
		
		System.out.println("instance 1 sum" + instance1.getSum());
		System.out.println("instance 2 sum" + instance2.getSum());
		System.out.println("instance 3 sum" + instance3.getSum());
		
		System.out.println("["+currentThread+"]"+ "Ended"	);
	}

}
