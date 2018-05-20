package Core;

public class StatusMsg {
	private String msg, status;
	
	public StatusMsg(String status, String msg) {
		this.status = status;
		this.msg = msg;
	}
	
	public String getStatus( ) {
		return this.status;
	}
	
	public String getMsg() {
		return this.msg;
	}
}
