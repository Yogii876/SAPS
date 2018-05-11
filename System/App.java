package System;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import Core.*;
import CSV.*;


public class App {
	private ArrayList<Student> students;
	private ArrayList<CAPE> offeredSubjects = new ArrayList<CAPE>();
	private Point point = new Point();
	private Map<Integer, Map<String, Integer>> studentMapping = new HashMap<Integer, Map<String, Integer>>();
	
	public App () {
		students = (new Reader("c:/users/yohan/Downloads/students.csv")).getStudents();
			
		// creating n by m matrix, where n is the number of students and m the number of subjects offered.
		int n = students.size();
		int m = offeredSubjects.size();
		
		
		for (int k = 0; k < n-1; k++) {
			for (int j = 0; j < m-1; j++) {
				students.get(k).calcPoints(point, offeredSubjects.get(j));
			studentMapping.put(students.get(k).getSid(), students.get(k).getMapping());
			
		
				
				
				
				
				
				
				
				
				
			}
		
		}
		
		
	}
	
	public void setOfferedSubjects(ArrayList<CAPE> subs) {
		offeredSubjects = subs;
	}
	
	
	
}
