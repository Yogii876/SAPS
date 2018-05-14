package Core;

public class PreRequisite {
	
	private CAPE cSub;
	private CSEC primary, secondary, tertiary;
	
	private final int pOne = 24, pTwo = 20, pThree = 16, four = 0, five = 0;
	//Secondary Requirements
	private final int sOne = 10, sTwo = 9, sThree = 8;
	//Tertiary Requirements
	private final int tOne = 3, tTwo = 2, tThree = 1;
	 
	public PreRequisite(CAPE cSubj, CSEC primary, CSEC secondary, CSEC teritiary) {
		 this.cSub = cSubj;
		 this.primary = primary;
		 this.secondary = secondary;
		 this.tertiary = teritiary;
	 }
	
	public PreRequisite(CAPE cSub, CSEC primary, CSEC secondary) {
		 this.cSub = cSub;
		 this.primary = primary;
		 this.secondary = secondary;
	 }
	
	public PreRequisite(CAPE cSub, CSEC primary) {
		this.cSub = cSub;
		this.primary = primary;
	 }
	
	public CAPE getSubject() {
		return this.cSub;
	}
	
	public CSEC getPrimary() {
		return this.primary;
	}
	
	public CSEC getSecondary() {
		return this.secondary;
	}
	
	public CSEC getTertiary() {
		return this.tertiary;
	}
	
	// Write code to change DB values for these information
	
	public void setPrimary(CSEC primary) {
		this.primary = primary;
	}
	
	public void setSecondary(CSEC secondary) {
		this.secondary = secondary;
	}
	
	public void setTertiary(CSEC tertiary) {
		this.tertiary = tertiary;
	}
	
	public int[] pPoints() {
		int[] x = {pOne, pTwo, pThree};
		return x;
	}
	
	public int[] sPoints() {
		int[] x = {sOne, sTwo, sThree};
		return x;
	}
	
	public int[] tPoints() {
		int[] x = {tOne, tTwo, tThree};
		return x;
	}
	
	public int getFour() {
		return four;
	}
	
	public int getFive() {
		return five;
	}

}
