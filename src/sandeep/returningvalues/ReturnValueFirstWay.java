package sandeep.returningvalues;

public class ReturnValueFirstWay {

	public static void main (String [] args) throws InterruptedException{
		
		String currentThread = Thread.currentThread().getName();
		System.out.println("["+currentThread+"]"+ "Started"	);
		
		AdditionClass instance1 = new AdditionClass(2, 3, 1000);
		AdditionClass instance2 = new AdditionClass(3, 4, 1000);
		AdditionClass instance3 = new AdditionClass(4, 5, 1000);
		
		new Thread(instance1).start();
		new Thread(instance2).start();
		new Thread(instance3).start();
		
		
		
		
		System.out.println("instance 1 sum" + instance1.getSum());
		System.out.println("instance 2 sum" + instance2.getSum());
		System.out.println("instance 3 sum" + instance3.getSum());
		
		System.out.println("["+currentThread+"]"+ "Ended"	);
	}
}
