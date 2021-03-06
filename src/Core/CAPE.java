package Core;

import java.util.HashMap;
import java.util.Iterator;
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
	private int applied = 0;
	private int rejecSize = 0;
	private ArrayList<Student> rejected = new ArrayList<Student>();
	private Map<Student, Integer> eligibleStudents = new LinkedHashMap<Student, Integer>();
	private ArrayList<String> antiRequisites = new ArrayList<String>();
	private ArrayList<Student> accepted = new ArrayList<Student>();
	private ArrayList<Student> conflictStudents = new ArrayList<Student>();
	private ArrayList<Student> alternateStudents = new ArrayList<Student>();
	private ArrayList<Student> studFull = new ArrayList<Student>();
	private Map<Student, StatusMsg> reasons =  new HashMap<Student, StatusMsg>();
	private Map<Student, StatusMsg> oRejects = new HashMap<Student, StatusMsg>();
	private LinkedHashMap<Student, StatusMsg> accepts = new LinkedHashMap<Student, StatusMsg>();
	private LinkedHashMap<Student, StatusMsg> pendings = new LinkedHashMap<Student, StatusMsg>();
	private LinkedHashMap<Student, StatusMsg> rejects = new LinkedHashMap<Student, StatusMsg>();
	private LinkedHashMap<Student, StatusMsg> alternates = new LinkedHashMap<Student, StatusMsg>();

	
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
	
	public void clearMappings() {
		this.eligibleStudents = new HashMap<Student, Integer>();
		this.accepted = new ArrayList<Student>();
		this.antiRequisites = new ArrayList<String>();
		this.conflictStudents = new ArrayList<Student>();
		this.alternateStudents = new ArrayList<Student>();
		this.rejected = new ArrayList<Student>();
		this.sorted = false;
		this.applied = 0;
		studFull = new ArrayList<Student>();
		reasons =  new HashMap<Student, StatusMsg>();
		oRejects = new HashMap<Student, StatusMsg>();
		accepts = new LinkedHashMap<Student, StatusMsg>();
		pendings = new LinkedHashMap<Student, StatusMsg>();
		rejects = new LinkedHashMap<Student, StatusMsg>();
		alternates = new LinkedHashMap<Student, StatusMsg>();
		rejecSize = 0;

	}
	
	public void resetStudents() {
		clearMappings();
		primary = null;
		secondary = null;
		tertiary = null;
		classSize = -1;
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
	
	public void addRejected(Student s) {
		this.rejected.add(s);
		this.oRejects.put(s, new StatusMsg("Rejected", "Did not meet Requirements", 0));
	}
	
	public ArrayList<Student> getRejects() {
		return this.rejected;
	}
	
	public int getRejectedSize() {
		return this.rejected.size();
	}
	
	public int getPending() {
		return this.conflictStudents.size() + this.alternateStudents.size();
	}
	
	public ArrayList<Student> getAcceptedStudents() {
		return this.accepted;
	}
	
	public ArrayList<Student> getRejectedStudents() {
		return this.rejected;
	}
	
	public ArrayList<Student> getConflictStudents() {
		return this.conflictStudents;
	}
	
	public ArrayList<Student> getAlternateStudents() {
		return this.alternateStudents;
	}
	
	public int getAccNum() {
		return this.accepted.size();
	}
	
	public int getClassSize() {
		if (classSize == -1) return 0;
		return classSize;
	}
	
	public int getMetReq() {
		return this.eligibleStudents.size();
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
		StatusMsg reason;
		Set set = eligibleStudents.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
			Student stud = (Student) entry.getKey();
			int points = (int) entry.getValue();
			ArrayList<String> choices = stud.getChoices();
			
			if (choices.contains((super.name).toLowerCase())) {
				boolean exculsive = isDisjoint(choices, antiRequisites);
				if (exculsive) {
					if (noMax || ((accepted.size() + conflictStudents.size() < classSize))) {
						reason = new StatusMsg("Accepted", "N/A", points);
						if (stud.addAcceptedSubject(this, reason, maxDoable)) {
							accepted.add(stud);
							accepts.put(stud, reason);
						}
						else {
							//TODO change to arraylist as GUI can print message
							//alternateStudents.put(stud, entry.getValue());
							reason = new StatusMsg("Rejected", "Student is already doing the Maximum Number of Courses", points);
							addRejected(stud);
							rejects.put(stud, reason);
							studFull.add(stud);
							stud.addAlternate(this, reason);						
						}
					}
					else if (conflictStudents.size() != 0 && alternateStudents.size() < conflictStudents.size()) {
						reason = new StatusMsg("Pending", "Possible Space Available", points);
						alternates.put(stud, reason);
						alternateStudents.add(stud);
						stud.addAlternate(this, reason);			
					}
					else {
						reason = new StatusMsg("Rejected", "Maximum Class Capacity Reached", points);
						addRejected(stud);
						rejects.put(stud, reason);
						studFull.add(stud);
						stud.addAlternate(this, reason);
						
					}
				}
				else {
					if (noMax || ((accepted.size() + conflictStudents.size() < classSize))) {
						reason = new StatusMsg("Pending", "Has AntiRequisites", points);
						pendings.put(stud, reason);
						conflictStudents.add(stud);
						stud.addConflict(this, reason);
					}
					else if (alternateStudents.size() < conflictStudents.size()) {
						reason = new StatusMsg("Pending", "Has AntiRequisites - Space May Be Available", points);
						pendings.put(stud, reason);
						conflictStudents.add(stud);
						stud.addAlternate(this, reason);			
					}
					else {
						reason = new StatusMsg("Rejected", "Maximum Class Capacity Reached - Has AntiRequisites", points);
						addRejected(stud);
						rejects.put(stud, reason);
						studFull.add(stud);
						stud.addAlternate(this, reason);
					}
				}
			}
			else {
				reason = new StatusMsg("Alternate", "Did not Apply", points);
				alternates.put(stud, reason);
				stud.addAlternate(this, reason);
			}
			choices = new ArrayList<String>();
		}
}
	
	public void sortResults(Map<Student, StatusMsg> unSortedList) {
        Set set = unSortedList.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry ent = (Map.Entry) iterator.next();
        	reasons.put((Student) ent.getKey(), (StatusMsg) ent.getValue());
        }
	}
	
	public Map<Student, StatusMsg> getReasons() {
		sortResults(accepts);
		sortResults(pendings);
		sortResults(alternates);
		sortResults(oRejects);
		sortResults(rejects);
		return this.reasons;
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
	
	public void incApplied() {
		this.applied++;
	}
	
	public int getApplied() {
		return this.applied;
	}
}