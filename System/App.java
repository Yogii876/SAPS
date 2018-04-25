package System;

import java.util.ArrayList;
import Core.*;
import CSV.*;

import CSV.CSVReader;
import Core.*;

public class App {
	private ArrayList<Student> students;
	private ArrayList<CAPE> offeredSubjects;
	Point point = new Point();
	
	public App () {
		students = (new Reader("c:/users/yohan/Downloads/students.csv")).getStudents();
		
		for(int i = 0; i<offeredSubjects.size()-1; i++) {
			for(int j =0; j<students.size()-1; j++) {
				students.get(j).calcPoints(point, offeredSubjects.get(i));
			}
		}
	}
	
}
