package Core;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Comparator;
import java.util.Set;

public class CAPE extends Subject {
	private String primary;
	private String secondary = null;
	private String tertiary = null;
	private boolean sorted = false;
	private int classSize = -1;
	private Map<Student, Integer> eligibleStudents = new LinkedHashMap<Student, Integer>();
	//private ArrayList<String> accepted = new ArrayList<String>();
	private ArrayList<String> antiRequisites = new ArrayList<String>();
	//private ArrayList<String> conflictStudents = new ArrayList<String>();
	//private ArrayList<String> alternateStudents = new ArrayList<String>();
	private Map<Student, Integer> accepted = new LinkedHashMap<Student, Integer>();
	private Map<Student, Integer> conflictStudents = new LinkedHashMap<Student, Integer>();
	private Map<Student, Integer> alternateStudents = new LinkedHashMap<Student, Integer>();
	
	public CAPE(String name, String primary, String secondary, String tertiary, int max) {
		super(name.toLowerCase());
		this.primary = primary.toLowerCase();
		this.secondary=secondary.toLowerCase();
		this.tertiary=tertiary.toLowerCase();
		this.classSize = max;
}
	
	public CAPE(String name, String primary, String secondary, int max) {
		super(name.toLowerCase());
		this.primary = primary.toLowerCase();
		this.secondary=secondary.toLowerCase();
		this.classSize = max;
}
	
	public CAPE(String name, String primary, int max) {
		super(name.toLowerCase());
		this.primary = primary.toLowerCase();
		this.classSize = max;
	}
	
	public String getName() {
		return super.name;
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
	
	public ArrayList<String> getAnti() {
		return antiRequisites;
	}
	
	public void setPrimary(String primary) {
		this.primary=primary.toLowerCase();
	}
	
	public void setSecondary(String secondary) {
		this.secondary = secondary.toLowerCase();
	}
	
	public void setTertiary(String tertiary) {
		this.tertiary = tertiary.toLowerCase();
	}
	
	public void addStudent(Student key, int value) {
		eligibleStudents.put(key, value);
		sorted = false;
	}
	
	public void resetStudents() {
		this.eligibleStudents = new HashMap<Student, Integer>();
		this.accepted = new LinkedHashMap<Student, Integer>();
		this.antiRequisites = new ArrayList<String>();
		this.conflictStudents = new LinkedHashMap<Student, Integer>();
		this.alternateStudents = new LinkedHashMap<Student, Integer>();		
		this.sorted = false;
	}
	
	public void addAntiReq(String s) {
		antiRequisites.add(s.toLowerCase());
	}
	
	public boolean hasAnti() {
		return !antiRequisites.isEmpty();
	}
	
	public boolean hasAccepted() {
		return !accepted.isEmpty();
	}

	public boolean hasEligible() {
		return !eligibleStudents.isEmpty();
	}
	
	public void setMax(int m) {
		classSize = m;
	}
	
	public int getMax() {
		return classSize;
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
	        //System.out.println(super.name);
	        for (Entry<Student, Integer> entry : list)
	        {
	        	//System.out.print(entry.getKey().toString() + ": Points: " + entry.getValue() +"\t");
	            sortedMap.put(entry.getKey(), entry.getValue());
	        }
	        eligibleStudents = sortedMap;
	        sorted = true;
	        //return sortedMap;
	    }
	
	private boolean isDisjoint(ArrayList<String> c1, ArrayList<String> c2) {
		return Collections.disjoint(c1, c2);
	}
	
	// Add antirequisite stuff here
	public void generateAcceptedList(int maxDoable) {
		if (!sorted) sortStudents();
		boolean noMax = (classSize == -1);
		for (Map.Entry<Student, Integer> entry : eligibleStudents.entrySet()) {
			Student stud = entry.getKey();
			ArrayList<String> choices = stud.getChoices();
			if (choices.contains((super.name).toLowerCase())) {
				boolean exculsive = isDisjoint(choices, antiRequisites);
				if (exculsive && (noMax || ((accepted.size() + conflictStudents.size() < classSize)))) {
					System.out.println("Accepted: " + stud);
					if (stud.addAcceptedSubject(this, maxDoable)) {
						accepted.put(stud, entry.getValue());						
					}
					else {
						alternateStudents.put(stud, entry.getValue());
						stud.addAlternate(this);						
					}
				}
				else if (!exculsive) {
					System.out.println("Conflicting: " + stud + "Points -	" + entry.getValue());
					conflictStudents.put(stud, entry.getValue());
					stud.addConflict(this);
				}
				else {
					System.out.println("Alternate: " + stud + "Points -	" + entry.getValue());
					alternateStudents.put(stud, entry.getValue());
					stud.addAlternate(this);
				}
			}
			else {
				stud.addAlternate(this);
			}
			
		}
	}
	
	private ArrayList<String> getString(Map<Student, Integer> mapping, boolean type) {
		if (!mapping.isEmpty()) {
			ArrayList<String> students = new ArrayList<String>();
			if (type) {
				Set<Student> studs = mapping.keySet();
				for (Student stud: studs) {
					students.add(stud.toString());
				}
			}
			else {
				for (Map.Entry<Student, Integer> entry : mapping.entrySet()) {
				    Student key = entry.getKey();
				    Integer value = entry.getValue();
				    students.add(key.toString() + "\t\t" + value.toString());
				}
			}
			return students;
		}
		return null;
		
	}
	
	public ArrayList<String> getAllStudents() {
		return getString(eligibleStudents, true);
	}
	
	public ArrayList<String> getAccepted() {
		return getString(accepted, false);
	}
	
	public ArrayList<String> getConflicts() {
		return getString(conflictStudents, false);
	}
	public ArrayList<String> getAlternates() {
		return getString(alternateStudents, false);
	}
}