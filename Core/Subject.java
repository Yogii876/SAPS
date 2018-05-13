package Core;

public abstract class Subject {
	String name;
	
	public Subject(String sName) {
		this.name = sName;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String toString() {
		return this.name;
	}
}
