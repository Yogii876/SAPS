package System;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import Core.CAPE;
import Core.Student;

import java.io.File;

public class Test {
	
	private static App controller = new App();;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		try {	
			controller.populateStudents(new File("c:/users/yohan/Downloads/students2.csv"));
			fakeSubjects();
			controller.generateMappings(0);
			for (CAPE c : controller.getOffered()) {
				System.out.println(c + "\t" + c.getMax());
				//System.out.println("Accepted Students: \t" + c.getAccepted());
				//System.out.println("Conflict Students: \t"+ c.getConflicts());
				//System.out.println("Alternates Students: \t" + c.getAlternates() + "\n");
 			}
			for (Student s: controller.getStudents()) {
				System.out.println(s + "\t" + s.getChoices());
				ArrayList<String> sa = s.getAccepted();
				ArrayList<String> sc = s.getConflicts();
				ArrayList<String> sal = s.getAlternates();
				if (sa == null);
				else System.out.println("Accepted Courses: \t" + s.getAccepted());
				if (sc == null);
				else System.out.println("Conflicts Courses: \t" + s.getConflicts());
				if (sal == null);
				else System.out.println("Alternate Courses: \t" + s.getAlternates());
				System.out.println("\n");
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	private static void fakeSubjects() {
		Random r = new Random();
		String[] csec_subjs = {"ADDITIONAL MATHEMATICS", "AGRICULTURAL SCIENCE", "BIOLOGY", "CARIBBEAN HISTORY", "CHEMISTRY", "ECONOMICS", "ELECTRONIC DOCUMENT PREPARATION AND MANAGEMENT", "ENGLISH A", "ENGLISH B", "FAMILY AND RESOURCE MANAGEMENT", "FOOD, NUTRITION AND HEALTH", "FRENCH", "GEOGRAPHY", "HOME ECONOMICS", "HUMAN AND SOCIAL BIOLOGY", "INDUSTRIAL TECHNOLOGY", "INFORMATION TECHNOLOGY", "INTEGRATED SCIENCE", "MATHEMATICS", "MUSIC", "OFFICE ADMINISTRATION", "PHYSICAL EDUCATION AND SPORT", "PHYSICS", "PORTUGUESE", "PRINCIPLES OF ACCOUNTS", "PRINCIPLES OF BUSINESS", "RELIGIOUS EDUCATION", "SOCIAL STUDIES", "SPANISH", "TECHNICAL DRAWING", "TEXTILES, CLOTHING AND FASHION", "THEATRE ARTS", "VISUAL ARTS"};
		String[] csec_subjs1 = {"None", "ADDITIONAL MATHEMATICS", "AGRICULTURAL SCIENCE", "BIOLOGY", "CARIBBEAN HISTORY", "CHEMISTRY", "ECONOMICS", "ELECTRONIC DOCUMENT PREPARATION AND MANAGEMENT", "ENGLISH A", "ENGLISH B", "FAMILY AND RESOURCE MANAGEMENT", "FOOD, NUTRITION AND HEALTH", "FRENCH", "GEOGRAPHY", "HOME ECONOMICS", "HUMAN AND SOCIAL BIOLOGY", "INDUSTRIAL TECHNOLOGY", "INFORMATION TECHNOLOGY", "INTEGRATED SCIENCE", "MATHEMATICS", "MUSIC", "OFFICE ADMINISTRATION", "PHYSICAL EDUCATION AND SPORT", "PHYSICS", "PORTUGUESE", "PRINCIPLES OF ACCOUNTS", "PRINCIPLES OF BUSINESS", "RELIGIOUS EDUCATION", "SOCIAL STUDIES", "SPANISH", "TECHNICAL DRAWING", "TEXTILES, CLOTHING AND FASHION", "THEATRE ARTS", "VISUAL ARTS"};

		String[] cape_subjs = {"ACCOUNTING", "ANIMATION & GAME DESIGN", "AGRICULTURAL SCIENCE", "APPLIED MATHEMATICS", "ART AND DESIGN", "BIOLOGY", "BUILDING AND MECHANICAL ENGINEERING DRAWING", "CARIBBEAN STUDIES", "CHEMISTRY", "COMMUNICATION STUDIES", "COMPUTER SCIENCE", "DIGITAL MEDIA", "ELECTRICAL AND ELECTRONIC ENGINEERING TECHNOLOGY", "ECONOMICS", "ENTREPRENEURSHIP", "ENVIRONMENTAL SCIENCE", "FINANCIAL SERVICES STUDIES", "FOOD AND NUTRITION", "FRENCH", "GEOGRAPHY", "GREEN ENGINEERING", "HISTORY", "INFORMATION TECHNOLOGY", "INTEGRATED MATHEMATICS", "LAW", "LITERATURES IN ENGLISH", "LOGISTICS AND SUPPLY CHAIN OPERATIONS", "MANAGEMENT OF BUSINESS", "PERFORMING ARTS", "PHYSICS", "PHYSICAL EDUCATION AND SPORT", "PURE MATHEMATICS", "SOCIOLOGY", "SPANISH", "TOURISM"};
		List<String> cape_subjs3 = Arrays.asList(cape_subjs);
		ArrayList<String> cape_subjs2 = new ArrayList<String>();
		cape_subjs2.addAll(cape_subjs3);

		//int sub = r.nextInt(cape_subjs2.length);  // [0...4] [min = 0, max = 4]
		while (cape_subjs2.size() != 0) {
			int sub = r.nextInt(cape_subjs2.size());
			String name = cape_subjs2.get(sub);
			String pReq = csec_subjs[r.nextInt(csec_subjs.length)];
			String sReq = csec_subjs[r.nextInt(csec_subjs.length)];
			String tReq = csec_subjs1[r.nextInt(csec_subjs1.length)];
			
			String anti1 = cape_subjs[r.nextInt(csec_subjs.length)];
			String anti2 = cape_subjs[r.nextInt(csec_subjs.length)];
			String anti3 = cape_subjs[r.nextInt(csec_subjs.length)];
			
			//String[] antis = {anti1, anti2, anti3};
			String[] antis = {};
			
			int maxStud = r.nextInt(5) + 1;
			//int maxStud =-1;
			CAPE cape;
			
			if (!tReq.equals("None")) cape = controller.populateSubjects(name, pReq, sReq, tReq, maxStud);
			else if (!sReq.equals("None")) cape = controller.populateSubjects(name, pReq, sReq, null, maxStud);
			else cape = controller.populateSubjects(name, pReq, null, null, maxStud);
			/**
			for (String s: antis) {
				if (!s.equals("None")) cape.addAntiReq(s);
			}
			**/
			cape_subjs2.remove(sub);
		}

		
	}
}
