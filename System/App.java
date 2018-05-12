package System;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import Core.*;
import CSV.*;


public class App {
	private ArrayList<Student> students;
	private ArrayList<CAPE> offeredSubjects = new ArrayList<CAPE>();
	private Point point = new Point();
	
	public App () {
		students = (new Reader("c:/users/yohan/Downloads/students.csv")).getStudents();
		generateMappings();
		
			
				
	
	}
		
	private void generateMappings() {
		// creating n by m matrix, where n is the number of students and m the number of subjects offered.
		int n = students.size();
		int m = offeredSubjects.size();

		for (int k = 0; k < n-1; k++) {
			Student stud = students.get(k);
			for (int j = 0; j < m-1; j++) {
				CAPE subj = offeredSubjects.get(j);
				stud.calcPoints(point, subj);
				int points = stud.getPoints(subj); 
				if (points > 0) {
					subj.addStudent(stud.getSid(), points);
					stud.addPossibleSub(subj.getName());
				}
			}
		}
	}
			
			
	private void assignStudents() {
		/**Map<Integer, Map<String, Integer>>
		Iterator it = studentMapping.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			Iterator pIT = (pair.getValue()).entrySet().iterator();
			**/
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
	}
	
	private void sortByName() {
	}

			
			
		
				
				
				
				
				
				
				
				
				
			}
		
		}
		
		
	}
	
	public void setOfferedSubjects(ArrayList<CAPE> subs) {
		offeredSubjects = subs;
	}
	
	
	
}
