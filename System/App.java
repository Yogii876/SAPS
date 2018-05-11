package System;

import java.util.ArrayList;
import Core.*;
import CSV.*;

import CSV.*;
import Core.*;

public class App {
	private ArrayList<Student> students;
	private ArrayList<CAPE> offeredSubjects = new ArrayList<CAPE>();
	private Point point = new Point();
	
	public App () {
		students = (new Reader("c:/users/yohan/Downloads/students.csv")).getStudents();
		
		for(int i = 0; i<offeredSubjects.size()-1; i++) {
			for(int j =0; j<students.size()-1; j++) {
				students.get(j).calcPoints(point, offeredSubjects.get(i));
			}
			
		// creating n by m matrix, where n is the number of students and m the number of subjects offered.
		int n = students.size();
		int m = offeredSubjects.size();
		
		int[][] weight = new int[n][m];
		for (int k = 0; k < n-1; k++) {
			for (int j = 0; j < m-1; m++) {
				weight[k][j] = students.get(k).getMapping(j).getPoints();
			}
		}
		}
		
		
	}
	
	public void setOfferedSubjects(ArrayList<CAPE> subs) {
		offeredSubjects = subs;
	}
	
	
	
}
