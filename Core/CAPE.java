package Core;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Comparator;
import java.util.Set;

public class CAPE extends Subject {
	private String name, primary;
	private String secondary = null;
	private String tertiary = null;
	private boolean sorted = false;
	private int maxStudents = -1;
	private Map<Student, Integer> eligibleStudents = new HashMap<Student, Integer>();
	private Map <Student, Integer> accepted = new LinkedHashMap<Student, Integer>();
	
	
	public CAPE(String name, String primary, String secondary, String tertiary, int max) {
		super(name);
		this.primary = primary;
		this.secondary=secondary;
		this.tertiary=tertiary;
		this.maxStudents = max;
	}
	
	public CAPE(String name, String primary, String secondary, int max) {
		super(name);
		this.primary = primary;
		this.secondary=secondary;
		this.maxStudents = max;
	}
	
	public CAPE(String name, String primary, int max) {
		super(name);
		this.primary = primary;
		this.maxStudents = max;
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
	
	public void addStudent(Student key, int value) {
		eligibleStudents.put(key, value);
		sorted = false;
	}
	
	public void resetStudents() {
		eligibleStudents = new HashMap<Student, Integer>();
	}
	
	public void setMax(int m) {
		maxStudents = m;
	}
	
	public int getMax() {
		return maxStudents;
	}
	
	private void sortStudents()
	    {
	
	        List<Entry<Student, Integer>> list = new LinkedList<Entry<Student, Integer>>(eligibleStudents.entrySet());
	
	        // Sorting the list based on values
	        Collections.sort(list, new Comparator<Entry<Student, Integer>>()
	        {
	            public int compare(Entry<Student, Integer> o1,
	                    Entry<Student, Integer> o2)
	            {
	                    return o2.getValue().compareTo(o1.getValue());
	            }
	        });
	
	        // Maintaining insertion order with the help of LinkedList
	        Map<Student, Integer> sortedMap = new LinkedHashMap<Student, Integer>();
	        for (Entry<Student, Integer> entry : list)
	        {
	            sortedMap.put(entry.getKey(), entry.getValue());
	        }
	        eligibleStudents = sortedMap;
	        sorted = true;
	        //return sortedMap;
	    }
	
	public Set<Student> getAcceptedStudents() {
		if (eligibleStudents.isEmpty()){
			return null;
		}
		
		if (sorted && !accepted.isEmpty()) {
			return accepted.keySet();
		}
		
		if (!sorted) {
			sortStudents();
		}
		
		if (maxStudents == -1 || eligibleStudents.size() < maxStudents) {
			accepted = eligibleStudents;
			return accepted.keySet();
		}
		else {
			generateAcceptedList();
			return accepted.keySet();
		}
	}
	
	public void generateAcceptedList() {
		accepted = new LinkedHashMap<Student, Integer>();
		for (Map.Entry<Student, Integer> entry : eligibleStudents.entrySet()) {
			accepted.put(entry.getKey(), entry.getValue());
			entry.getKey().addAcceptedSubject(this);
			if (maxStudents == accepted.size()) {
				break;
			}
		}
	}
	
	public Map<Student, Integer> getAllStudents() {
		if (eligibleStudents.isEmpty()) {
			return null;
		}
		if (sorted) {
			return eligibleStudents;
		}
		else {
			sortStudents();
			return eligibleStudents;
		}
	}
}
