package sandeep.returningvalues;

public class ResultBean {

	private int result;
	private String taskId;

	public ResultBean(int result, String taskId) {

		this.result = result;
		this.taskId = taskId;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	@Override
	public String toString() {
		return "ResultBean [result=" + result + ", taskId=" + taskId + "]";
	}

}
