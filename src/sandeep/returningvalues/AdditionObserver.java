package sandeep.returningvalues;

public class AdditionObserver implements ResultListener<Integer>{

	private String taskId;
	public AdditionObserver(String taskId){
		this.taskId = taskId;
	}
	
	@Override
	public void notifyResult(Integer t) {
		System.out.println("result is "+ t + "taskId = " + taskId);
		
	}

}
