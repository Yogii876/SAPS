package Core;

import java.util.ArrayList;

public class CAPE extends Subject {
	private String name, primary;
	private String secondary = null;
	private String tertiary = null;
	private int maxStudents = 0;
	private ArrayList<Integer> eligibleStudents = new ArrayList<Integer>();
	
	public CAPE(String name, String primary, String secondary, String tertiary) {
		super(name);
		this.primary = primary;
		this.secondary=secondary;
		this.tertiary=tertiary;
	}
	
	public CAPE(String name, String primary, String secondary) {
		super(name);
		this.primary = primary;
		this.secondary=secondary;
	}
	
	public CAPE(String name, String primary) {
		super(name);
		this.primary = primary;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getPrimary() {
		return this.primary;
	}
	
	public String getSecondary() {
		return this.secondary;
	}
	
	public String getTertiary() {
		return this.tertiary;
	}
	
	public void setPrimary(String primary) {
		this.primary=primary;
	}
	
	public void setSecondary(String secondary) {
		this.secondary = secondary;
	}
	
	public void setTertiary(String tertiary) {
		this.tertiary = tertiary;
	}
	
	public void addStudent(int id) {
		eligibleStudents.add(id);
	}
	
	public void resetStudents() {
		eligibleStudents = new ArrayList<Integer>();
	}
	
	public void setMax(int m) {
		maxStudents = m;
	}
	
	public int getMax() {
		return maxStudents;
	}
}
