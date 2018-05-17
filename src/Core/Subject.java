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
		String tName = (name.substring(0, 1).toUpperCase()).concat(name.substring(1));
		return tName;
	}
}
