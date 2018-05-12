package Core;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Comparator;

public class CAPE extends Subject {
	private String name, primary;
	private String secondary = null;
	private String tertiary = null;
	private int maxStudents = 0;
	private Map<Integer, Integer> eligibleStudents = new HashMap<Integer, Integer>();
	
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
	
	public void addStudent(int key, int value) {
		eligibleStudents.put(key, value);
	}
	
	public void resetStudents() {
		eligibleStudents = new HashMap<Integer, Integer>();
	}
	
	public void setMax(int m) {
		maxStudents = m;
	}
	
	public int getMax() {
		return maxStudents;
	}
	
	 public Map<Integer, Integer> sortStudents()
	    {
	
	        List<Entry<Integer, Integer>> list = new LinkedList<Entry<Integer, Integer>>(eligibleStudents.entrySet());
	
	        // Sorting the list based on values
	        Collections.sort(list, new Comparator<Entry<Integer, Integer>>()
	        {
	            public int compare(Entry<Integer, Integer> o1,
	                    Entry<Integer, Integer> o2)
	            {
	                    return o2.getValue().compareTo(o1.getValue());
	            }
	        });
	
	        // Maintaining insertion order with the help of LinkedList
	        Map<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
	        for (Entry<Integer, Integer> entry : list)
	        {
	            sortedMap.put(entry.getKey(), entry.getValue());
	        }
	
	        return sortedMap;
	    }
}
