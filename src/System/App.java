package System;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import Core.*;
import CSV.*;
import java.io.File;
import java.lang.NullPointerException;
import java.util.Map;


public class App {
	private ArrayList<Student> students = new ArrayList<Student>();
	private ArrayList<CAPE> offeredSubjects = new ArrayList<CAPE>();
	private Map<String, Student>  studentMap = new HashMap<String, Student>();
	private Map<String, CAPE>  subjectMap = new HashMap<String, CAPE>();
	private boolean status = false;
	
	
	public App () {
		// Should take the input from the GUI and populate offeredSubjects using populateSubjects
	}
	
	//TODO delete
	public ArrayList<CAPE> getOffered() {
		return this.offeredSubjects;
	}
	
	
	public ArrayList<CAPE> getConflicts() {
		return this.offeredSubjects;
	}
	
	public ArrayList<CAPE> getAlternates() {
		return this.offeredSubjects;
	}
	
	public void populateStudents(File csvFile) throws Exception {
		if (status) {
			for (CAPE c: offeredSubjects) {
				c.clearMappings();
			}
		}
		Reader fileReader = new Reader(csvFile);
		students = fileReader.getStudents();
		studentMap = fileReader.getMap();
	}
	
	public CAPE searchSubjects(String sName) {
		CAPE subj = (CAPE)subjectMap.get(sName.toLowerCase());
		return subj;
	}
	
	public void populateSubjects(File subFile) throws Exception{
		if (status) {
			for (Student s: students) {
				s.clearMappings();
			}
		}
		CAPEReader fileReader = new CAPEReader(subFile);
		offeredSubjects = fileReader.getStudents();
		subjectMap = fileReader.getMap();
	}
	
	
	public Student searchStudents(String name) {
		Student subj = (Student)studentMap.get(name);
		return subj;
	}
	
	public CAPE populateSubjects(String name, String pReq, String sReq, String tReq, int maxStud) {
		CAPE subj;
		if (tReq != null) {
			subj = new CAPE(name, pReq, sReq, tReq, maxStud);
			offeredSubjects.add(subj);
		}
		else if (sReq != null) {
			subj = new CAPE(name, pReq, sReq, maxStud);
			offeredSubjects.add(subj);
		}
		else {
			subj = new CAPE(name, pReq, maxStud);
			offeredSubjects.add(subj);
		}
		subjectMap.put(subj.getName(), subj);
		status = false;
		return subj;
	}
	
	public boolean getStatus() {
		return status;
	}
		
	public void generateMappings(int i) throws NullPointerException {
		// creating n by m matrix, where n is the number of students and m the number of subjects offered.
		if (students.isEmpty()) {
			throw new NullPointerException("Upload Student Data Before Proceeding");
		}
		if (offeredSubjects.isEmpty()) {
			throw new NullPointerException("Set CAPE Preferences Before Proceeding");
		}
		
		int n = students.size();
		int m = offeredSubjects.size();
		

		for (int k = 0; k < n; k++) {
			Student stud = students.get(k);
			for (int j = 0; j < m; j++) {
				CAPE subj = offeredSubjects.get(j);
				boolean applied = stud.getChoices().contains(subj.getName());
				Object[] res = stud.calcPoints(subj);
				int points = (Integer)res[0];
				if (points > 0) {
					subj.addStudent(stud, points);
					stud.addPossibleSub(subj);
				}
				if (applied) {
					subj.incApplied();
					if (points == 0)	{
						subj.addRejected(stud);
					}
				}
			}
		}
		assignStudents(i);
		status = true;
	}
	private void assignStudents(int m) {
		for (CAPE subj: offeredSubjects ) {
			subj.generateAcceptedList(m);
		}
	}
			

	
	public void setOfferedSubjects(ArrayList<CAPE> subs) {
		offeredSubjects = subs;
	}
	
	public ArrayList<Student> getStudents(){
		return this.students;
	}
	
	public CAPE getSubject(String name) {
		for (CAPE subj : offeredSubjects) {
			if (((subj.getName()).toLowerCase()).equals(name.toLowerCase())) {
				return subj;
			}
		}
		return null;	
	}
	
	public void resetMappings() {
		for (Student stud: students) {
			stud.clearMappings();
		}
		for (CAPE c: offeredSubjects) {
			c.clearMappings();
		}
	}
	
	
	public void editSubject(CAPE c, String p, String s, String t, int max) {
		c.resetStudents();
		c.setPrimary(p);
		if (s != null) c.setSecondary(s);
		if (t != null) c.setTertiary(t);
		c.setMax(max);
	}

}