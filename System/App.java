package System;

import java.util.ArrayList;
import Core.*;
import CSV.*;
import java.io.File;
import java.lang.NullPointerException;


public class App {
	private ArrayList<Student> students;
	private ArrayList<CAPE> offeredSubjects = new ArrayList<CAPE>();
	private Point point = new Point();
	
	public App () {
		// Should take the input from the GUI and populate offeredSubjects using populateSubjects
		generateMappings();
	}
	
	public void populateStudents(File csvFile) throws Exception {
		students = (new Reader(csvFile)).getStudents();
	}
	
	public void populateSubjects(String name, String pReq, String sReq, String tReq, int maxStud) {
		if (tReq != null) {
			offeredSubjects.add(new CAPE(name, pReq, sReq, tReq, maxStud));
		}
		
		else if (sReq != null) {
			offeredSubjects.add(new CAPE(name, pReq, sReq, maxStud));			
		}
		
		else {
			offeredSubjects.add(new CAPE(name, pReq, maxStud));						
		}
		
	}
		
	public void generateMappings() throws NullPointerException {
		// creating n by m matrix, where n is the number of students and m the number of subjects offered.
		if (students.isEmpty()) {
			throw new NullPointerException("Please upload a file before proceeding");
		}
		if (offeredSubjects.isEmpty()) {
			throw new NullPointerException("Please enter offered CAPE subjects");
		}
		
		int n = students.size();
		int m = offeredSubjects.size();
		

		for (int k = 0; k < n-1; k++) {
			Student stud = students.get(k);
			for (int j = 0; j < m-1; j++) {
				CAPE subj = offeredSubjects.get(j);
				int points = stud.calcPoints(point, subj);
				//int points = stud.getPoints(subj); 
				if (points > 0) {
					subj.addStudent(stud, points);
					stud.addPossibleSub(subj);
				}
			}
		}
	}
			
			
	/*** private void assignStudents() {
		Map<Integer, Map<String, Integer>>
		Iterator it = studentMapping.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			Iterator pIT = (pair.getValue()).entrySet().iterator();
			
		for (Map.Entry<Integer, Map<CAPE, Integer>> sMap : studentMapping.entrySet()) {
		    Integer sid = sMap.getKey();
		    Map<CAPE, Integer> value = sMap.getValue();
		    for (Map.Entry<CAPE, Integer> cMap : value.entrySet()) {
		    // ...
		    	CAPE sub = cMap.getKey();
		    	int points = cMap.getValue();
		    	if (points > 0) {
		    		sub.addStudent(sid);
		    	}
		    }
		}		
	}***/

	
	public void setOfferedSubjects(ArrayList<CAPE> subs) {
		offeredSubjects = subs;
	}
	
	
	
}
