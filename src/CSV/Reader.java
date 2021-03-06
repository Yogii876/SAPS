package CSV;

import Core.*;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.lang.Exception;


public class Reader {
	private ArrayList<Student> students = new ArrayList<Student>();
	private ArrayList<CSEC> csecSubs = new ArrayList<CSEC>();
	private ArrayList<String> capeSubs = new ArrayList<String>();
	private Map<String, Student> sMap = new HashMap<String, Student>();
	
	public Reader(File csvFile) throws Exception {
		//String csvFile = filePath;
		if (csvFile.canRead()) {
			
			BufferedReader br = null;
		    String line = "";
		    String cvsSplitBy = ",";
		    String courseSplitBy = ",,";
		    try {
		    	//int id_num = 1;
		        br = new BufferedReader(new FileReader(csvFile));
		        while ((line = br.readLine()) != null) {
		        	line = line.trim();
		            String[] stud_info = line.split(cvsSplitBy);
		            String fName = (stud_info[0].trim()).toLowerCase(), lName = (stud_info[1].trim()).toLowerCase();               
		            String[] grade_info = line.split(courseSplitBy)[1].split(cvsSplitBy);
		            int grade_length = grade_info.length;
		            int noTime = grade_length / 2;
		            int count = 0;
		            int gIndex = 0;
		            csecSubs = new ArrayList<CSEC>();
		            while (count < noTime) {
		                count++;
		                csecSubs.add(new CSEC(((grade_info[gIndex]).trim()).toLowerCase(), Integer.parseInt(grade_info[gIndex+1].trim())));
		                gIndex += 2;                    
		            }
		            gIndex = 0;
		            String[] sel_info = line.split(courseSplitBy)[2].split(cvsSplitBy);
		            for (String s: sel_info) {
		            	capeSubs.add((s.trim()).toLowerCase());
		            }
		            Student stud = new Student(fName, lName, csecSubs, capeSubs);
		            csecSubs = new ArrayList<CSEC>();
		        	capeSubs = new ArrayList<String>();
		            sMap.put(fName.toLowerCase() + " " + lName.toLowerCase(), stud);
		            students.add(stud);
		        }
		    }
		    catch (Exception e) {
		    	//throw new Exception("Error while parsing file, please sure values are stored in a comma-separated format");
		    	e.printStackTrace();
		    }
		    finally {
		        if (br != null) {
		            try {
		                br.close();
		            } catch (IOException e) {
		            }
		        }
		    }
		}
		else {
			throw new Exception("Unable to read file");
		}

    }
	
	public Map<String, Student> getMap() {
		return sMap;
	}
	
	public ArrayList<Student> getStudents() {
		return this.students;
	}
}