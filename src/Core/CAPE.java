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
	private String name, primary;
	private String secondary = null;
	private String tertiary = null;
	private boolean sorted = false;
	private int maxStudents = -1;
	private Map<Student, Integer> eligibleStudents = new HashMap<Student, Integer>();
	private Map <Student, Integer> accepted = new LinkedHashMap<Student, Integer>();
	private ArrayList<String> antiRequisites = new ArrayList<String>();
	private Map<Student, Integer> conflictStudents = new LinkedHashMap<Student, Integer>();
	private Map<Student, Integer> alternateStudents = new LinkedHashMap<Student, Integer>();
	
	public CAPE(String name, String primary, String secondary, String tertiary, int max) {
		super(name);
		this.primary = primary;
		this.secondary=secondary;
		this.tertiary=tertiary;
		this.maxStudents = max;
		this.antiRequisites.add(name);
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
	
	public void addAntiReq(String s) {
		antiRequisites.add(s.toLowerCase());
	}
	
	public void removeAntiReq(String s) {
		antiRequisites.remove(s);
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
	
	public ArrayList<String> getAcceptedStudents() {
		if (!sorted) {
			sortStudents();
		}
		
		generateAcceptedList();

		if (accepted.isEmpty()){
			return null;
		}
				
		Set<Student> studs = accepted.keySet();
		ArrayList<String> students = new ArrayList<String>();
		for (Student stud: studs) {
			students.add(stud.toString());
		}
		return students;
	}
	
	// Add antirequisite stuff here
	public void generateAcceptedList() {
		if (!sorted) sortStudents();
		accepted = new LinkedHashMap<Student, Integer>();
		int sSize = 0;
		boolean noMax = (maxStudents == -1);
		for (Map.Entry<Student, Integer> entry : eligibleStudents.entrySet()) {
			Student stud = entry.getKey();
			ArrayList<String> choices = stud.getChoices();
			if (choices.contains((this.name).toLowerCase())) {
				boolean exculsive = isDisjoint(choices, antiRequisites);
				if (exculsive && (noMax || ((accepted.size() + conflictStudents.size() < maxStudents)))) {
					accepted.put(stud, entry.getValue());
					stud.addAcceptedSubject(this);
				}
				else if (!exculsive) {
					conflictStudents.put(stud, entry.getValue());
					stud.addConflict(this);
				}
				else {
					alternateStudents .put(stud, entry.getValue());
					stud.addAlternate(this);
				}
			}
			sSize++;
			if (maxStudents == sSize) {
				break;
			}
		}
	}
	
	private boolean isDisjoint(ArrayList<String> c1, ArrayList<String> c2) {
		return Collections.disjoint(c1, c2);
	}
	
	public ArrayList<String> getAllStudents() {
		if (eligibleStudents.isEmpty()) {
			return null;
		}
		else {
			Set<Student> studs = eligibleStudents.keySet();
			ArrayList<String> students = new ArrayList<String>();
			for (Student stud: studs) {
				students.add(stud.toString());
			}
			return students;			
		}
	}
}
