package Core;

public class StatusMsg {
	private String msg, status;
	private int points;
	
	public StatusMsg(String status, String msg, int points) {
		this.status = status;
		this.msg = msg;
		this.points = points;
	}
	
	public String getStatus( ) {
		return this.status;
	}
	
	public String getMsg() {
		return this.msg;
	}
	
	public int getPoints() {
		return this.points;
	}
}
