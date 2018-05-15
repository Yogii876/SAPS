package System;

import java.util.ArrayList;
import java.util.Set;
import Core.*;
import CSV.*;
import java.io.File;
import java.lang.NullPointerException;
import java.util.Map;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
import BinaryTree.BinarySearchTree;


public class App {
	private ArrayList<Student> students;
	private ArrayList<CAPE> offeredSubjects = new ArrayList<CAPE>();
	private Point point = new Point();
	private BinarySearchTree studentBST;
	private BinarySearchTree capeBST;
	
	
	public App () {
		// Should take the input from the GUI and populate offeredSubjects using populateSubjects
		generateMappings();
	}
	
	
	public void populateStudents(File csvFile) throws Exception {
		Reader fileReader = new Reader(csvFile);
		students = fileReader.getStudents();
		studentBST = fileReader.getTree();
	}
	
	public CAPE searchSubjects(String sName) {
		CAPE subj = (CAPE)capeBST.get(sName);
		return subj;
	}
	
	public Student searchStudents(String name) {
		Student subj = (Student)studentBST.get(name);
		return subj;
	}
	
	public void populateSubjects(String name, String pReq, String sReq, String tReq, int maxStud) {
		if (tReq != null) {
			CAPE subj = new CAPE(name, pReq, sReq, tReq, maxStud);
			offeredSubjects.add(subj);
			capeBST.insert(name.toLowerCase(), subj);
			
		}
		
		else if (sReq != null) {
			CAPE subj = new CAPE(name, pReq, sReq, maxStud);
			offeredSubjects.add(subj);
			capeBST.insert(name.toLowerCase(), subj);

		}
		
		else {
			CAPE subj = new CAPE(name, pReq, maxStud);
			offeredSubjects.add(subj);
			capeBST.insert(name.toLowerCase(), subj);
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
	
	public void assignStudents() {
		for (CAPE subj: offeredSubjects ) {
			subj.generateAcceptedList();
		}
	}
	
	public Map<Student, Integer> getEligible(CAPE subj) {
		return subj.getAllStudents();
	}
	
	public ArrayList<String> getAcceptedStudents(CAPE subj) {
		Set<Student> studs = subj.getAcceptedStudents();
		if (!studs.isEmpty()) {
			ArrayList<String> students = new ArrayList<String>();
			for (Student stud: studs) {
				students.add(stud.toString());
			}
			return students;
		}
		else {
			return null;
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
	
	public CAPE getSubject(String name) {
		for (CAPE subj : offeredSubjects) {
			if (((subj.getName()).toLowerCase()).equals(name.toLowerCase())) {
				return subj;
			}
		}
		return null;	
	}

}
