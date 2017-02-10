package basicdemos;
class Hi extends Thread {

	public void run(){
		show();
	}
	
	public void show() {
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

class Hello extends Thread {
	
	public void run(){
		show();
	}
	public void show() {
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

public class ThreadDemo {

	public static void main(String[] args) throws InterruptedException {
         Hi obj1 = new Hi();
         Hello obj2 = new Hello();
         
         obj1.start();
         
         try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          obj2.start();
         
          obj1.join();
          obj2.join();
          System.out.println("Bye");
         
        // obj1.show();
        // obj2.show();
          
          
	}
}
