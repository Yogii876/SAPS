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
	private Map<Integer, Map<CAPE, Integer>> studentMapping = new HashMap<Integer, Map<CAPE, Integer>>();
	
	public App () {
		students = (new Reader("c:/users/yohan/Downloads/students.csv")).getStudents();
		generateMappings();
		
			
				
	
	}
		
	private void generateMappings() {
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
		    	if (sub.getSecondary() == null) {
		    		if (points >= 16) {
		    			sub.addStudent(sid);
		    		}
		    	}
		    	else if (sub.getTertiary() == null) {
		    		if (points >= 24) {
		    			sub.addStudent(sid);
		    		}
		    	}
		    	else if ()
		    	}
		    	
		    	
		    }
		}

		
	}
			
			
		
				
				
				
				
				
				
				
				
				
			}
		
		}
		
		
	}
	
	public void setOfferedSubjects(ArrayList<CAPE> subs) {
		offeredSubjects = subs;
	}
	
	
	
}
