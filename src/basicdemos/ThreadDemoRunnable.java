package basicdemos;

class His implements Runnable {

	public void run() {
		for (int i = 0; i <= 5; i++) {
			System.out.println("hi");
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Hellos implements Runnable {
	public void run() {
		for (int i = 0; i <= 5; i++) {
			System.out.println("hello");

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

public class ThreadDemoRunnable {

	public static void main(String[] args) {
         His obj1 = new His();
         Hellos obj2 = new Hellos();
         
         Thread t1 = new  Thread(obj1);
         
         Thread t2 = new Thread(obj2);
         
         t1.setName("sandeep");
         t2.setName("harish");
         
         System.out.println(t1.getName());
         System.out.println(t2.getName());
         
         t1.start();
         
         
         t2.start();
         
         
        
         
        // obj1.show();
        // obj2.show();
	}
}
