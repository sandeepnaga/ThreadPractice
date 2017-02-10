package sandeep.threadexceptions;

import java.lang.Thread.UncaughtExceptionHandler;

public class ThreadExceptionHandler implements UncaughtExceptionHandler {

	private String handlerId;

	public ThreadExceptionHandler() {

	}

	public ThreadExceptionHandler(String handlerId) {
	
		this.handlerId = handlerId;
	}

	@Override
	public void uncaughtException(Thread t, Throwable e) {
        System.out.println(this + "Caught Exception in Thread - \"" + t.getName() + e);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getClass().getSimpleName()+ "@" + this.hashCode() + (handlerId == null || "".equals(handlerId)? "": handlerId);
	}

}
